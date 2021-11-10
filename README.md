# API-REST
Para deployar en heroku. App mutantes de desafio MercadoLibre para parcial 1.

Hecho por: Martiniano Juarroz 

Consigna
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens. Te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN. Para eso te ha pedido crear un programa con un método o función con la siguiente firma:

boolean isMutant(String[] dna);

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las cuales representa cada base nitrogenada del ADN.Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras iguales, de forma oblicua, horizontal o vertical.

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
