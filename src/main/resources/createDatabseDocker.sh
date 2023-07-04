docker run --name sqlserver -p 1433:1433 -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Password123' -d mcr.microsoft.com/mssql/server:2019-latest

---
docker ps
-- 
docker exec -it sqlserver /opt/mssql-tools/bin/sqlcmd -S localhost -U sa -P Password123

