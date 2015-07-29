# Casa do Código - SOA
Casa do Código Estoque WebService para consulta de estoque via SOA e sistema de pagamento via REST

##### Consultando um Pagamento 
```json
curl -i -H "Accept: application/json" http://localhost:8080/casa-do-codigo-webservice/pagamentos/1
```

#### Criand um pagamento a partir de uma Transação

```json
curl -i -H "Content-Type: application/json" -X POST -d 
'{
   "valor":"39.9",
   "titular":"Gama"
}' 
http://localhost:8080/casa-do-codigo-webservice/pagamentos
```

Formato da resposta da criação de um pagamento

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
