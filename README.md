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
