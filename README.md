### Dependencies
- Spring Web
- DevTools
- JPA
- Lombok
- Mustache
- MySQL
- Spring Security

### DB 사용자 생성
```sql
create user 'ares'@'%' identified by 'ares1234';
GRANT ALL PRIVILEGES ON *.* TO 'ares'@'%';
create database security;
use security;
```