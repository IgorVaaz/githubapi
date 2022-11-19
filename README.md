# githubapi

### :pushpin: Features
1. [x] Funcionalidade de filtro dos repositórios por repositórios arquivados e ativos;
2. [x] Funcionalidade de ordenação alfabética e por data do ultimo commit dos repositórios;
3. [x] Funcionalidade de pesquisa simples dos repositórios 

### 🎲 Iniciando projeto pela primeira vez

```bash
# Clone este repositório
git clone https://github.com/IgorVaaz/githubapi

# Inicie a aplicação com uma IDE de sua preferência

#Acesse o seguinte endereço no navegador
http://localhost:8080/swagger-ui/

```
### 🛠 Detalhes Tecnicos

- Java 11
- Arquitetura baseada em Clean Arch
- Spring boot
- Swagger
- RestTemplate
- MVC

## Documentação da API

- ### Pesquisar repositórios

```
GET /repositories/{user}
```

CURL de exemplo:
curl -X GET "http://localhost:8080/repositories/igorvaaz?filter=ACTIVE&order=LAST_COMMIT" -H "accept: */*"

## Tecnologias

<div style="display: inline_block">
  <img align="center" alt="java" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" />
  <img align="center" alt="spring" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" />
  <img align="center" alt="swagger" src="https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white" />
</div>

### :sunglasses: Autor

Criado por Igor Vaz.

[![Linkedin Badge](https://img.shields.io/badge/-Igor-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/igorvaz/)](https://www.linkedin.com/in/igorvaz/)
[![Hotmail Badge](https://img.shields.io/badge/-vazigor@hotmail.com-c14438?style=flat-square&logo=Hotmail&logoColor=white&link=mailto:vazigor@hotmail.com)](mailto:vazigor@hotmail.com)

## Licença

Este projeto esta sobe a licença MIT.
