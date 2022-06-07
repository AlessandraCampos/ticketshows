# ticketshows
Sistema em Java de compras de eventos de shows/teatros

Desenvolvimento de Api de filmes com intuito de estudos 2021
Entidades :
Filmes com atributos de id/ nome do filme / quantidade / genero / classificação / data / horario de inicio / horario filme / sala.
Salas com atributos de id / filme / quantidade de assentos .
Compras com atributos : id / filme / quantidade de tickets
Perfil com atributos id / nome
Usuario com atributos id / email / senha / Perfil
Nesta aplicação cada entidade é composta com Crud que pode ser acessada através de login e senha através de Token JTW .
O acesso aos filmes disponíveis é livre sem necessidade de login .
O usuario pode comprar os ingressos atravé da uri "/compras" informando o filme e a quantidade de ingressos e então a quantidade de assentos disponiveis na sala em o filme está sendo exibido é reduzido.
A aplicação foi desenvolvida em JAVA utilizando STS com banco de dados H2 que após ser iniciada pode ser visualizada em localhost no endereço :
/h2-console . O banco ja está populado através de scripts SQL via migration .
As informações da api podem ser acessadas através da documentação Swagger no endereço /v3/api-docs ou por interface em
/swagger-ui.html
