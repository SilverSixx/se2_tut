init_sql:
	docker run --name mysql8 -e MYSQL_ROOT_PASSWORD=2311 -p 3306:3306 -d mysql

mysql_cli:
	docker exec -it mysql8 mysql -uroot -p2311

createdb:
	docker exec -it mysql8 mysql -uroot -p2311 -e "CREATE DATABASE IF NOT EXISTS se2;"

dropdb:
	docker exec -it mysql8 mysql -uroot -p2311 -e "DROP DATABASE IF EXISTS se2;"

.PHONY: init_sql createdb dropdb mysql_cli
