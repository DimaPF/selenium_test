1. ������ ����� � ��������� ��������� �������.

2. ��������� �������� ������ POSTGRES � ��������� ����� � �������� ��. ��� /Users/dima/Documents/sqltasks/ - ����������� ����� � �������������� ������ ���������� (����� ������� � ���������� ������)

sudo docker run --name sqltasks -v "$PWD"/:/Users/dima/Documents/sqltasks/ -e POSTGRES_PASSWORD=password1 -d postgres

3. ������ ���� ������ �.�. ���� �������� � � ��������� ����� �������.

docker exec -it sqltasks psql -U postgres -c "CREATE DATABASE sqltasks1;"

3. �������� ���� ������ ��������� � �������. 
�����: ������� ����� �� ���������� /sqltasks (��� ������� �������) � � ������ ����������� �� ������� ����(/Users/dima/Documents/) � � �� ������� �������.

docker exec -it sqltasks psql -U postgres -f /Users/dima/Documents/sqltasks/sqltasks1.sql

4. ������� ����� � ������� sqltasks1_requests.sql, ������� ����� ����� sqltasks1.sql. � ���� ��� ������ ������ ����� � ��������� ����, �� �� ���� � ���� ������� ������ :)

docker exec -it sqltasks psql -U postgres -f /Users/dima/Documents/sqltasks/sqltasks1_requests.sql
