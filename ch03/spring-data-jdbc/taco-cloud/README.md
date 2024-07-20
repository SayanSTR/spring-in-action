# spring-in-action
Learning Spring Basics

Figure 2.2 The Taco Cloud Domain Entity Relationship Diagram
```mermaid
erDiagram
    TacoOrder {
        sequence id
        timestamp placedAt
        varchar deliveryName
        varchar deliveryStreet
        varchar deliveryCity
        varchar deliveryState
        varchar deliveryZip
        varchar ccNumber
        varchar ccExpiration
        varchar ccCVV
    }
    Taco {
        varchar name
    }
    Ingredient {
        varchar id
        varchar name
        varchar type
    }
    IngredientType {
        varchar type "WRAP"
        varchar type "PROTEIN"
        varchar type "VEGGIES"
        varchar type "CHEESE"
        varchar type "SAUCE"
    }
    
    TacoOrder ||--|{ Taco: includes
    Taco }|--|{ Ingredient: contains
    Ingredient }|--|| IngredientType: has

```

>> Note:  
O| - Zero or one  
|| - One and only one  
O{ - Zero or many  
|{ - One or many

```mermaid
erDiagram
    Taco_Order {
        int id PK
        string delivery_name
        string delivery_street
        string delivery_city
        string delivery_state
        string delivery_zip
        string cc_number
        string cc_expiration
        string cc_cvv
        timestamp placed_at
    }

    Taco {
        int id PK
        string name
        int taco_order_key FK
        timestamp createdAt
    }

    Ingredient_Ref {
        int taco FK
        int taco_key FK
        string ingredient
    }

    Ingredient {
        string id PK
        string name
        string type
    }

    Taco_Order ||--o{ Taco : "contains"
    Taco ||--o{ Ingredient_Ref : "references"
    Ingredient ||--o{ Ingredient_Ref : "is referenced in"
```
As Spring Data JDBC does not support many-to-many relationships, the Ingredient_Ref 
table is used to represent the many-to-many relationship between Taco and Ingredient.

As Spring Data automatically creates implementations of the Repository interfaces, 
we don't need the implementation classes anymore. If we use CrudRepository, in 
that case we don't even need to declare the basic operations in the interface. 
In case we extend from Repository, then we had to mention(declare) the methods to 
find, save and update data.

We’ll need to annotate our domain classes so that Spring
Data JDBC will know how to persist them. Generally speaking, this means annotating
the identity properties with @Id—so that Spring Data will know which field represents
the object’s identity—and optionally annotating the class with @Table.