** Recursos protegidos via token JWT  **   

* Acessar recurso "cursos" sem autenticação (deve retornar acesso negado)    
http://localhost:8080/aula4/jwt/api/cursos

* Acessar recurso "usuarios/registre-se" para criar um usuário na aplicação  
http://localhost:8080/aula4/jwt/api/usuarios/registre-se

* Acessar o recurso "login" padrão para informar usuário e senha e recuperar o token gerado  
http://localhost:8080/aula4/jwt/api/login

Com o token gerado, acessar novamente os recursos protegidos, passando no header:

Authorization: Bearer <beader>
