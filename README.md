# treinamento-microservices-2020
Projetos de estudos desenvolvidos durante o treinamento de microservices.

Para executar os projetos, ir no diretório da aula e executar o comando: 

    ./mvnw clean package spring-boot:run

Em cada diretório de aula, está o zip contendo a estruturada gerada no momento em que o módulo foi implementado (talvez as versões sejam diferentes agora no Spring Initializer).

## Aula 2 - Primeira API Rest com Spring Boot

GET [/v1/cursos](http://localhost:8080/aula2/api/v1/cursos)  
GET [/v2/cursos](http://localhost:8080/aula2/api/v2/cursos)

## Aula 4

### Spring Data JPA

GET [/v3/cursos](http://localhost:8080/aula4/api/v3/cursos)  
GET [/v3/cursos/{id}](http://localhost:8080/aula4/api/v3/cursos/{id})  
POST [/v3/cursos](http://localhost:8080/aula4/api/v3/cursos)  
DELETE [/v3/cursos/{id}](http://localhost:8080/aula4/api/v3/cursos/{id})  
PUT [/v3/cursos/{id}](http://localhost:8080/aula4/api/v3/cursos/{id})  
POST [/v3/cursos/filter](http://localhost:8080/aula4/api/v3/cursos/filter)  

### Spring Hateoas

GET [/v4/cursos/hateoas](http://localhost:8080/aula4/api/v4/cursos/hateoas)  
GET [/v4/cursos/hateoas/{id}](http://localhost:8080/aula4/api/v4/cursos/hateoas/{id})  

### Jackson

GET [/v4/cursos](http://localhost:8080/aula4/api/v4/cursos)  
GET [/v4/cursos/mapping](http://localhost:8080/aula4/api/v4/cursos/mapping)  
GET [/v4/cursos/dto](http://localhost:8080/aula4/api/v4/cursos/dto)  

### Spring Security

GET [/v5/cursos](http://localhost:8080/aula4/api/v5/cursos)  

