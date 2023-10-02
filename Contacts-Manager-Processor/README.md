# Requirements

- Docker
- Postgresql TODO integrare docker
- aggiungere istruzioni d'uso 


L'applicazione si e' formata da due elementi principali:

- Il processore, cioe' colui che riceve i messaggi di rabbitmq e li processa inserendoli all'interno di elasticsearch.
- L'applicazione web, che offre il frontend dinamico attraverso htmx e le classiche operazioni CRUD.
