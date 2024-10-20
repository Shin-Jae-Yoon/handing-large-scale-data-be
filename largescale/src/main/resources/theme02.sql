# query result : 6s
SELECT * FROM user ORDER BY create_date DESC, user_id ASC limit 100;

# 쿼리가 오래 걸리니 실행계획 분석해보자
# - type 에 ALL 이 보인다. 이건 FULL-TABLE-SCAN 한다는 말이지
# - rows 에 489만이 보인다. 인덱스 전혀 안타고 테이블 다 뒤지는 중
# - Extra 에 Using file sort 보인다. 외부 정렬이 돌아간다는 의미

# 인덱스를 타는 컬럼의 ORDER BY 라면, B-Tree 구조의 맨 아래를 쭈욱 타니까 매우 간단
# File sort 는 모든 데이터를 가져와서 전부 정렬하는 것
# - 현재 500만 개를 정렬하니까 메모리 위에 올라가지 않을 것
# - 물리 disk 를 미친 듯이 써가면서 정렬하기에 성능이 나오지 않음

# 왜 인덱스를 타지 않았을까 ?
# - 비트리 구조의 맨 밑이 아래와 같다고 생각해보자
# - (1, 2), (2, 2), (3, 1), (3, 3), (4, 1), (5, 2), (5, 4), (5, 6)
# - create_date ASC, id ASC -> 인덱스를 탐
# - create_date DESC, id DESC -> 인덱스를 탐
# - create_date DESC, id ASC -> 갑자기 내려가다가 올라가? 인덱스 안탐
# - 그래서 정렬 조건까지 신경 쓴 쿼리에 대한 인덱스를 따로 만들어줘야함

# 번외) 카카오 테크 블로그의 Ascending index vs Descending index 참고
# - 링크 : https://tech.kakao.com/posts/351

# 번외) 2천만개 데이터 어떻게 넣었어요?
# - 랜덤이 가능한 부분에 대해서는 로직 짜고, bulk insert 로 때려박았음
EXPLAIN SELECT * FROM user ORDER BY create_date DESC, user_id ASC limit 100;

