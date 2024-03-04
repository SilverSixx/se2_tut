initSql:
	docker run --name mysql8 -e MYSQL_ROOT_PASSWORD=2311 -p 3306:3306 -d mysql
stopSql:
	docker stop mysql8
dropSql:
	docker rm mysql8
mysqlCli:
	docker exec -it mysql8 mysql -uroot -p2311
createDb:
	docker exec -it mysql8 mysql -uroot -p2311 -e "CREATE DATABASE IF NOT EXISTS se2;"
dropDb:
	docker exec -it mysql8 mysql -uroot -p2311 -e "DROP DATABASE IF EXISTS se2;"

.PHONY: initSql createDb dropDb mysqlCli stopSql dropSql
