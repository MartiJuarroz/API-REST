# API-REST
Para deployar en heroku. App mutantes de desafio MercadoLibre para parcial 1.
Martiniano Juarroz 
Consigna
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens.

URLs Útiles
Link de la aplicación
https://mutantes-app.herokuapp.com/

Requests
Chequear si una cadena de ADN pertenece un Mutante
POST https://mutantes-app.herokuapp.com/api/v1/mutant/

Ejemplo de body de la Request:

{
  "dna": [
    "ATGCGA",
    "CCGTCC",
    "TTAAGT",
    "ATAAGG",
    "CCTTTA",
    "TTTTGG"
  ]
}
Estados posibles en la respuesta
200: Mutante positivo
403: Humano
400: Error. Por favor intente más tarde
