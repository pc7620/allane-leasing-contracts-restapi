# allane-leasing-contracts-restapi
A leasing application to be able to administrate leasing contracts.

--Preconditions

Before running the application, the following prerequisites must be met:
Java 11 or higher must be installed.
Docker must be installed.
A MySQL or MariaDB database must be available. This can be done by running a Docker container with the database. For example, the following command can be used to start a MariaDB container:
docker run -d -p 3306:3306 --name mariadb -e MYSQL_ROOT_PASSWORD=<password> mysql



--How to start the application

To start the application, follow these steps:

Clone the repository to your local machine.
Navigate to the root directory of the project.
Build the project
Run the project
docker-compose up --build 

The application will be accessible at http://localhost:8080.




--Reason for Chosen Solution

The chosen solution uses Java 11 and Spring Boot because they are widely used and provide a robust, reliable, and scalable framework for building REST APIs. Hibernate is used as the ORM to map the Java entities to the database tables, which simplifies the data persistence process.

The Flyway database migration tool is used to create and manage the database schema, which makes it easier to manage schema changes as the application evolves. This approach ensures that the database schema is always up-to-date and avoids any issues caused by manual schema updates.

The use of Docker and Docker Compose enables the application to be easily packaged and deployed, which simplifies the deployment process.

Overall, the chosen solution provides a robust, reliable, and scalable framework for building REST APIs, while also ensuring that the database schema is always up-to-date and simplifying the deployment process.




Swagger URI :http://localhost:8080/swagger-ui/index.html
