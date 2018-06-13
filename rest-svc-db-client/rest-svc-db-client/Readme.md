# rest-svc-db-client 
is a Spring Boot 2 application which uses JPA and Spring Data JPA repositories to access the Sakila sample database in a MySQL instance. It has a REST API based upon Spring Web MVC controllers.

The Maven pom.xml uses Fabric8.io to deploy everything to Kubernetes without having to maintain the K8s descriptor files manually. 
