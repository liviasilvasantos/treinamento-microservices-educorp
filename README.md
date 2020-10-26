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
@Deprecated POST [/v3/cursos/filter](http://localhost:8080/aula4/api/v3/cursos/filter)  
GET [/v3/cursos/filter2?codigo={codigo}&descricao={descricao}](http://localhost:8080/aula4/api/v3/cursos/filter2?codigo={codigo}&descricao={descricao})

### Spring Hateoas

GET [/v4/cursos/hateoas](http://localhost:8080/aula4/api/v4/cursos/hateoas)  
GET [/v4/cursos/hateoas/{id}](http://localhost:8080/aula4/api/v4/cursos/hateoas/{id})  

### Jackson

GET [/v4/cursos](http://localhost:8080/aula4/api/v4/cursos)  
GET [/v4/cursos/mapping](http://localhost:8080/aula4/api/v4/cursos/mapping)  
GET [/v4/cursos/dto](http://localhost:8080/aula4/api/v4/cursos/dto)  

### Spring Security

GET [/v5/cursos](http://localhost:8080/aula4/api/v5/cursos)  

## Aula 5

### Documentação de API

[Documentação Swagger](http://localhost:8080/aula5/api/swagger-ui/index.html)

### Versionamento de API

GET [/cursos/p](http://localhost:8080/aula5/api/cursos/p) -H "Accept: application/vnd.cursos.educorp-v1.0+json"  
GET [/cursos/p](http://localhost:8080/aula5/api/cursos/p) -H "Accept: application/vnd.cursos.educorp-v2.0+json"  
GET [/cursos/h](http://localhost:8080/aula5/api/cursos/h) -H "API-VERSION=1"  
GET [/cursos/h](http://localhost:8080/aula5/api/cursos/h) -H "API-VERSION=2"  
GET [/cursos/v/?version={version}](http://localhost:8080/aula5/api/cursos/v/?version={version})  

### Profile

## Aula 7

### Spring Devtools  

GET [/v7/cursos](http://localhost:8080/aula7/api/v7/cursos)  

### Spring Actuator

GET [/manager](http://localhost:8080/aula7/api/manager)  
GET [/manager/info](http://localhost:8080/aula7/api/manager/info)  
[Spring Boot Admin Server](http://localhost:8081/)

### Tratamento de Exceções

GET [/v8/cursos/{id_existente}](http://localhost:8080/aula7/api/v8/cursos/{id_existente})  
GET [/v8/cursos/{id_inexistente}](http://localhost:8080/aula7/api/v8/cursos/{id_inexistente})  
POST [/v8/cursos](http://localhost:8080/aula7/api/v8/cursos)  
GET [/v8/cursos/{id_invalido}](http://localhost:8080/aula7/api/v8/cursos/{id_invalido})  

