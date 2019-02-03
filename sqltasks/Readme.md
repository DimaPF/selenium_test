1. Download and install docker (https://store.docker.com/editions/community/docker-ce-desktop-mac)
2. Run system console (Terminal) and open directory with scripts.
3. Use next command for installation of POSTGRES  and mount directory in guest OS. 
Where "/sqltasks/" - directory which will be shared on Guest OS; "$PWD" - directory which will be shared on Host OS  ($PWD mean current directory, if you want you can use any path). 
Note: this directory should be used from other shared for Docker directory. Check list of shared directories in Docker > Preferences > File sharing.

sudo docker run --name sqltasks -v "$PWD"/:/sqltasks/ -e POSTGRES_PASSWORD=password1 -d postgres

3.1 Check if container run. To check container status:
docker ps -a

OPTIONAL: And start it if needed (using CONTAINER ID):
docker start 6a244701b9b6
(where 6a244701b9b6 - docker container id)

4. In console use next command for creating (because their a problem for creating it using scripts).
docker exec -it sqltasks psql -U postgres -c "CREATE DATABASE sqltasks1;"

for sqltasks2 ("CREATE DATABASE sqltasks2;")

5. All tables will be created from script "sqltasks1.sql". Use next command (scripts should be located in mounted directory!):
docker exec -it sqltasks psql -U postgres -f /sqltasks/dump/sqltasks1.sql

for sqltasks2 (docker exec -it sqltasks psql -U postgres -f /sqltasks/dump/sqltasks2.sql)

6. All tasks in script "sqltasks1_requests.sql" or in single files like "sqltasks1.sql". Use next command (scripts should be located in mounted directory!):
docker exec -it sqltasks psql -U postgres -f /sqltasks/queries/sqltasks1_requests.sql

for sqltasks2 (docker exec -it sqltasks psql -U postgres -f /sqltasks/queries/sqltasks2_requests.sql)