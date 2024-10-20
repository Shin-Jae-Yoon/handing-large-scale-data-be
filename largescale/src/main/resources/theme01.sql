# query result : 13s
# 해당 쿼리는 날릴 수록 커넥션이 쌓여서, DB 입장에서도 부하가 많이 발생
# 웬만하면 안쓰되, 굳이 써야하고, 빈도가 많지도 않고, 서비스에 그리 중요하지 않아서
# 결과가 빨리 나올 필요가 없다고 한다면
# 별도의 커넥션을 뚫어서 얘만 socketTimeout 을 확 늘려주는 방식 채택 가능
SELECT * FROM account ORDER BY memo DESC limit 100;

# query result : 121ms
SELECT * FROM account ORDER BY user_id limit 100;
