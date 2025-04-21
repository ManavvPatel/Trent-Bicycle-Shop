# Bicycle Shop Management System (Spring Boot + MS SQL Server)

This is a multi-tier Java-based application designed to manage core operations for a retail bicycle shop. It includes modules for managing customers, products, sales, returns, inventory, suppliers, service transactions, and user accounts with role-based access control.

Originally developed as part of a university project, this system is a follow-up to a prototype created in Microsoft Access (Project 1) and has been redesigned using Spring Boot and MS SQL Server to support a scalable, secure, and modular architecture.

---

## Technologies Used

1. Java 17 or above
2. MySQL (Add MySQL Workbench during installation)
3. MS SQL Server (Add SSMS and SQL server Configuration Manager)
4. An IDE (preferably Visual Studio Code)
---

## User Roles and Access

| Role     | Permissions |
|----------|-------------|
| Admin    | Full system access, user management |
| Owner    | Product, supplier, and order management |
| Employee | View/add sales, returns, customers, repairs |

Passwords are encrypted using `BCryptPasswordEncoder`.

---

## Features

- Role-based login and session management
- Manage products, customers, inventory, suppliers, and repairs
- Track sales, returns, and orders
- Encrypted user credentials
- Modular and layered backend (Model, Repository, Service, Controller)
- Database-agnostic structure: works with MS SQL and MySQL

---

## Setting Up the Environment

# For MySQL

1. Open a folder attached with this report, named ‘Trent-Bicycle-Shop-MySQL’, in VS code or your choice of IDE.
2. Open MySQL workbench.
3. Open TrentBicycleShop.sql file in mySQL workbench. File Path is from: Trent-Bicycle-Shop-MySQL->src->main->resources->db_setup_queries->mysql->TrentBicycleShop.sql
4. Run the whole script.
5. Go back to your IDE and in your resources folder, you will find ‘application.properties’ where you must change the username and password.

   ```
   spring.datasource.username=yourusername
   spring.datasource.password=yourpw
   ```
6. Run the application from terminal at the root folder which is ‘Trent-Bicycle-Shop-MySQL’ using:
   ```
   ./mvnw spring-boot:run
   ```

   or

  You can press any button that runs the program in your respective IDE.

# For MS SQL

1. Go to SQL server Configuration Manager -> SQL Server Network Configuration -> Protocols for MSSQLSERVER -> Enable TCP/IP
2. Now, open a folder attached with this report named ‘Trent-Bicycle-Shop-MS-SQL’, in VS code or your choice of IDE.
3. Open MySQL workbench.
4. Open MSSQL_Query.sql file in MS SQL Server Management Studio. File Path is from: Trent-Bicycle-Shop-MS-SQL ->src->main->resources->db_setup_queries->mysql-> MSSQL_Query.sql
5. Run the whole script.
6. Go back to your IDE and in your resources folder, you will find ‘application.properties’ where you must change the username and password.

   ```
   spring.datasource.username=yourusername
   spring.datasource.password=yourpw
   ```

7. Additionally, make sure the use you add here does exist in SSMS with permissions to connect SQL. If not, then on the left in SSMS, under Object Explorer, right click on your server and go to properties. In properties, go to permissions and select the username you chose in ‘application.properties’ and grant them permission to ‘Connect SQL’.
8. Run the application from terminal at the root folder which is ‘Trent-Bicycle-Shop-MySQL’ using:

   ```
   ./mvnw spring-boot:run
   ```
If your run is successful, you will see this in terminal:
**[TimeStamp] INFO 62647 --- [trentbicycleshop] [ restartedMain] c.m.t.TrentBicycleshopApplication : Started TrentBicycleshopApplication in 2.143 seconds (process running for 2.367)**

Once you are successful, go to http://localhost:8080/login
