# Spring in Action 6 Chapter 4 - Working with nonrelational data
## Using NoSQL with Spring Data Cassandra

### Setting up a docker container for cassandra:
- Create a docker network for cassandra container 
```shell
docker network create cassandra-net
```
- Create a docker container running cassandra using that network
```shell
docker run --name my-cassandra --network cassandra-net -p 9042:9042 -d cassandra:latest
```
- Login to CQL(Cassandra Query Language) shell inside the container
```shell
docker run -it --network cassandra-net --rm cassandra cqlsh my-cassandra
```
- Create a keyspace for taco-cloud database
```shell
CREATE KEYSPACE taco_cloud WITH REPLICATION = {'class':'SimpleStrategy', 'replication_factor':1} AND DURABLE_WRITES = true;
```
- Exit out of the CQL Shell
```shell
exit
```
```mermaid
%%{init: {'theme': 'base', 'themeVariables': { 'primaryColor': '#fff', 'edgeLabelBackground':'#fff', 'tertiaryColor': '#e6f2fc'}}}%%
flowchart LR
    subgraph OrdersTable[Stored in ''orders'' table]
        direction TB
        A[TacoOrder]
        style A fill:#fdd634,stroke:#333,stroke-width:1px
        A -->|has list of| B(TacoUDT)
        style B fill:#66c87f,stroke:#333,stroke-width:1px
    end
    
    subgraph TacosTable[Stored in ''tacos'' table]
        direction TB
        C[Taco]
        style C fill:#fdd634,stroke:#333,stroke-width:1px
        C -->|has list of| D(IngredientUDT)
        style D fill:#66c87f,stroke:#333,stroke-width:1px
    end
    
    subgraph IngredientsTable[Stored in ''ingredients'' table]
        direction TB
        E[Ingredient]
        style E fill:#fdd634,stroke:#333,stroke-width:1px
    end
    
    B -.->|copied from| C
    B --> |has list of| D
    D -.->|copied from| E
```