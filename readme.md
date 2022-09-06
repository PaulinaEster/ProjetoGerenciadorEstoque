# Para começar
  1. Clone a branch main do repositorio e vá até a pasta rabbitMQ e de um `docker-compose up` para subir o container com o RabbitMQ.
  2. Vá até a pasta librabbitmq e de um `maven install`.
  3. Rode o projeto java `estoquepreco`, esse é o produtor de mensagens, se você procurar no projeto vai encontrar os arquivos controllers que você pode usar para mandar as mensagens.
  4. Se quiser consumir as mensagens do estoque rode o projeto java `consumido-estoque`.
  5. Se quiser consumir as mensaens da fila preco va até a pasta `consumidor-preco-nodejs` de um `npm install` e depois de o comando `node consumidor.js`.
## `Para verificar se o RabbitMQ esta rodando`:
  1. Vá até `http://localhost:15672` e coloque a senha e usuario que estão no application.properties, você vai entrar na interface grafica do RabbitMQ.
  
