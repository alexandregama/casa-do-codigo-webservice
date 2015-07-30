# Casa do Código - SOA
Casa do Código Estoque WebService para consulta de estoque via SOA e sistema de pagamento via REST

##### Consultando um Pagamento com retorno JSON
```json
curl -i -H "Accept: application/json" http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```

##### Consultando um Pagamento com retorno XML
```json
curl -i -H "Accept: application/xml" http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```

##### Criando um Pagamento a partir de uma Transação

```json
curl -i -H "Content-Type: application/json" -X POST -d 
'{
   "valor":"39.9",
   "titular":"Gama"
}' 
http://localhost:8080/casa-do-codigo-webservice/pagamentos
```

Formato da resposta da criação de um Pagamento

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
curl -i -H "Accept: application/json" -X PUT http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```

##### Deletando(cancelando) um Pagamento

```json
curl -i -H "Accept: application/json" -X DELETE http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
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
