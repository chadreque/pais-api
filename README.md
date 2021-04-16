# Pais-api

**Version 1.0.0**

Aplicação rest desenvolvida em Spring Boot e Jersey JAX-RS para desafio de candidatura

Um desafio de código da [2iBi](https://2ibi.com/) no âmbito da vaga de Back-End Engineer. Rest desenvolvido em Java, implementando o padrão Rx-Js em Jersey e Spring Boot.
Visa em disponibilizar uma API que contem propriedades de um pais. Nela é possivel criar uma novo pais nao existente, buscar um ou varios paises existente, actualizar um pais, eliminar um pais e ordenar os paises de acordo com os atributos do pais.

---


## Instalação e configuração

A aplicação foi desenvolvido pensando em duas bases de dados PostgreSQL e MySQL. No ambiente de desenvolvimento, a base de dados MySQL foi usado, no ambiente de produção 
PostgreSQL foi usado. 
A aplicação já vem com essas duas bibliotecas maven incluídas. Caso queira usar outra base de dados, primeiro insira a biblioteca maven no arquivo pom e atualize o maven, 
em seguida, insira os dados da base de dados no arquivo de propriedades.
Cria uma base de dados com o nome paisapi_db
Descomente as propiedades no ficheiro de propriedade application.properties [application.properties](https://github.com/chadreque/pais-api/blob/master/src/main/resources/application.properties)
e introduza propriedades da sua base de dados

```java
#MySQL database Properties
spring.datasource.url=jdbc:mysql://192.168.18.5:3306/paisapi_db
spring.datasource.username=root
spring.datasource.password=root
pring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.database=mysql

# HIBERNATE Properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.order_inserts=true #for batch insertion
spring.jpa.show-sql=true

```
### Formato e atributos
Ao adicionar um novo pais deve-se fornecer os atribuitos para que se crie o pais. I ID é gereado automaticamente assim com a data de registo.
No caso de atualização, todo o elemento deve ser introduzido incluindo o id para que se possa atualizar o elemento em questão.

```rest
{
        "nome": "",
        "capital": "",
        "regiao": "",
        "subRegiao": "",
        "area": ""
}
```


## API ENDPOINTS

##### BUSCAR TODOS PAISES (GET)
- localhost/paises

##### BUSCAR UM PAIS (GET)
- localhost/paises/{id}

##### ADICIONAR PAIS (POST)
- localhost/paises

##### ATUALIZAR PAIS (PUT)
- localhost/paises

##### ELEIMINAR PAIS (DELETE)
- localhost/paises/{id}


##### BUSCA ORDENADA (GET)
- localhost/paises?orderby={nome-atributo}&ordertype={asc}
- localhost/paises?orderby={nome-atributo}&ordertype={desc}

Caso seja omitido o ordertype (localhost/paises?orderby={nome-atributo}), ordena por padrão {asc}

## Live Demo

Use o link para a demonstração da API
https://paisapp.herokuapp.com/paises

O aplicação foi hospedado no [Heroku](https://dashboard.heroku.com/) e usa a base de dados PostgreSQL do adons free (Dynos). 
O Heroku já disponibiliza as propriedades de configuração do PostgreSQL de forma automática, basta configurar as bibliotecas 
na aplicação e introduzir o mecanismo de criação de base de dados no arquivo application.properties

```java

spring.jpa.hibernate.ddl-auto=update

```

## Contribuidores
- Chadreque Micajo <https://www.linkedin.com/in/chadreque-micajo-14151a95>

## Licença & direitos autorais
© 2021 Chadreque Micajo
