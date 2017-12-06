Para rodar precisa do Mysql;
Rodar o jar com os parametros do banco abaixo

**java -jar -Dspring.datasource.password=suaSenhaAqui cc-login-1.0.0-SNAPSHOT.jar**


Será criado o database loginDatabase e a tabela usuario;  	
Após API no ar popular o banco acessando a URL:
**http://localhost:8080/gera/dados**

Dadso gerados na tabela de usuario:
| id | login    | senha  |
+----+----------+--------+
|  1 | juliano  | 123456 |
|  2 | diego    | 123456 |
|  3 | sergio   | 123456 |
|  4 | fernando | 1  