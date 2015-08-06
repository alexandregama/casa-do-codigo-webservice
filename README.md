# Casa do Código - SOA
Casa do Código WebService que contempla os seguintes serviços
- Consulta de Estoque via SOAP
- Sistema de Pagamento via REST

# Sistema de Pagamento - REST

##### Consultando um Pagamento com retorno JSON
```json
$ curl -i -H "Accept: application/json" http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```

##### JSON de resposta da consulta de um Pagamento
```json
{
   "id":1,
   "estadoAtual":"CRIADO",
   "valor":10,
   "links":[
      {
         "rel":"confirmar",
         "uri":"/pagamentos/1",
         "method":"PUT"
      },
      {
         "rel":"cancelar",
         "uri":"/pagamentos/1",
         "method":"DELETE"
      }
   ]
}
```

##### Consultando um Pagamento com retorno XML
```json
$ curl -i -H "Accept: application/xml" http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```

##### XML de resposta da consulta de um Pagamento
```xml
<?xml version="1.0" encoding="UTF-8"?>
<pagamento id="1">
   <estadoAtual>CRIADO</estadoAtual>
   <valor>10</valor>
   <links>
      <rel>confirmar</rel>
      <uri>/pagamentos/1</uri>
      <method>PUT</method>
   </links>
   <links>
      <rel>cancelar</rel>
      <uri>/pagamentos/1</uri>
      <method>DELETE</method>
   </links>
</pagamento>
```

##### Criando um Pagamento a partir de uma Transação

```json
$ curl -i -H "Content-Type: application/json" -X POST -d 
```

##### JSON de resposta da criação de um Pagamento
```json
{
   "valor":"39.9",
   "titular":"Gama"
} 
```

##### Formato da resposta da criação de um Pagamento

```json
{
   "id":2,
   "status":"CRIADO",
   "valor":42.9,
   "links":[
      {
         "rel":"confirmar",
         "uri":"/pagamentos/2",
         "method":"PUT"
      },
      {
         "rel":"cancelar",
         "uri":"/pagamentos/2",
         "method":"DELETE"
      }
   ]
}
```

##### Confirmando um Pagamento

```json
$ curl -i -H "Accept: application/json" -X PUT http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```

##### Deletando(cancelando) um Pagamento

```json
$ curl -i -H "Accept: application/json" -X DELETE http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```
Obs: Aqui foi usado DELETE por questão de exercício mas deveria ter sido usado PATCH ou PUT

##### Revisão dos principais status code

###### 2xx - Successful family
* 200 - Ok
* 201 - Created
* 202 - Accepted
* 204 - No Content

###### 3xx Redirection family
* 301 - Moved Permanently
* 304 - Not Modified 

###### 4xx Client error family
* 400 - Bad Request
* 401 - Unauthorized
* 403 - Forbidden
* 404 - Not Found
* 405 - Method not allowed
* 408 - Request Timeout
* 409 - Conflict
* 415 - Unsupported Media Type

###### 5xx Server error family
* 500 - Internal Server Error
* 501 - Not Implemented
* 502 - Bad Gateway
