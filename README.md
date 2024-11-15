# Libary Project

## Goal
The purpose of this project is to create a book rental system. Here, we added classes such as author, publisher, and book genre, inserted data into them, and linked this data to the book class through Hibernate relationships. Each class performs operations like add, update, delete, and get within itself. Afterward, we implemented a system that allows renting books from the book class through a book rental class.


## private situations
Instead of returning entities as the method's return type, we created DTO classes. This allows us to hide special cases or columns/information in the entity classes that we don't want to expose, keeping them confidential.We mapped DTOs to entities and  entities to DTOs mapped.

Dto class
![image](https://github.com/user-attachments/assets/fec0c6ab-4282-47d8-921d-bf3b6f7427e7)

Mapped<br/>
![image](https://github.com/user-attachments/assets/720bc87d-20da-4a0f-a63b-59c51612093b)

------------------------------------------------------------------------------------------------------------------

We defined the HTTP response types ourselves.
![image](https://github.com/user-attachments/assets/1a22edb3-2cc6-4e86-87a3-15826835f8ac)

------------------------------------------------------------------------------------------------------------------

We associated the classes with each other using Hibernate relationships.
![image](https://github.com/user-attachments/assets/5e58288f-4de6-483e-92e4-70b3f5db3f27)

------------------------------------------------------------------------------------------------------------------

We used PA Lifecycle Callback methods to update one condition based on another condition in the book class.
![image](https://github.com/user-attachments/assets/d636ac2a-e7d5-4c52-91c9-327a7fbdf7bc)

------------------------------------------------------------------------------------------------------------------

Additionally, we created our own error classes. This way, when the system encounters an error, it hides any sensitive or potentially vulnerable information and only displays the message we want on the screen.
![image](https://github.com/user-attachments/assets/4aaebac8-6164-46a0-983b-712badb597a2)

<br/><br/>

## Photos
This Book Class Response 
![image](https://github.com/user-attachments/assets/7c65fbf1-3f62-4248-9c9d-d888199c7c30)

This Author Class Response 
![image](https://github.com/user-attachments/assets/2e6a5553-cb29-4b09-991b-c434a20d617b)

This BookType Class Response 
![image](https://github.com/user-attachments/assets/7ce95ac3-cc51-4df2-b12e-719b845144ad)

This Publisher Class Response 
![image](https://github.com/user-attachments/assets/c7626cc9-5312-4460-945c-c3a1de2b1012)

This Rent A Book Class Response 
![image](https://github.com/user-attachments/assets/57a07e61-45b1-411f-95b7-14f8c808c7b9)


## Next steps.
AOP<br/>
Spring Security / login <br/>
Ui



