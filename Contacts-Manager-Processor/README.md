# Requisiti

- Docker compose
- Java 17

## Servizi presenti

- Elasticsearch
- PostgreSQL
- RabbitMQ
- Spring Boot

# Panoramica

L'applicazione e' formata da due elementi principali:

- Il processore, cioe' colui che riceve i messaggi di rabbitmq e li processa inserendoli all'interno di elasticsearch.
- L'applicazione web, che offre il frontend dinamico attraverso htmx e le classiche operazioni CRUD.

Il servizio web utilizza Spring Data JPA per poter gestire le classiche operazioni CRUD.
L'applicazione e' strutturata col classico pattern MVC sono presenti quindi i controller, i services e le repository. 

Ogni volta che viene fatta un'operazione su un contatto, l'applicazione manda sulla coda di RabbitMQ l'operazione insieme al contatto stesso, in modo da notificare gli altri servizi interessati.
Il processore prendera' questi messaggi e si occupera' di gestirli per aggiornare Elasticsearch.

La ricerca di un contatto avviene tramite il campo presente in alto a destra dell'interfaccia web, ancora senza indicatore di caricamento che, per ragioni temporali, non e' stato implementato.

