1. Ставим докер и открываем системную консоль.

2. Следующей командой ставим POSTGRES и монтируем папку в гостевую ОС. Где /Users/dima/Documents/sqltasks/ - монтируемая папка в расшареннойдля докера директории (можно глянуть в настройках докера)

sudo docker run --name sqltasks -v "$PWD"/:/Users/dima/Documents/sqltasks/ -e POSTGRES_PASSWORD=password1 -d postgres

3. Создаём базу руками т.к. есть проблема с её созданием через скрипты.

docker exec -it sqltasks psql -U postgres -c "CREATE DATABASE sqltasks1;"

3. Создание всех таблиц находится в скрипте. 
ВАЖНО: скрипты лежат не директории /sqltasks (для данного примера), а в другой расшаренной на уровень выше(/Users/dima/Documents/) и в неё смотрит консоль.

docker exec -it sqltasks psql -U postgres -f /Users/dima/Documents/sqltasks/sqltasks1.sql

4. Задания лежат в скрипте sqltasks1_requests.sql или в отдельных файлах, который лежит рядом sqltasks1.sql.

docker exec -it sqltasks psql -U postgres -f /Users/dima/Documents/sqltasks/sqltasks1_requests.sql
