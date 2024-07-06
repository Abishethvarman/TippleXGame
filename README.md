# Tipple X  

### Technologies used:  

FrontEnd : HTML, CSS & JS  
Backend : Spring Boot with spring web, h2, JPA repository dependencies.  

## Architecture   
This game application is built using a layered architecture, separating concerns into different layers: Presentation, Service, Repository, and Database. 

### User interface    

![xxo](https://github.com/Abishethvarman/TippleXGame/assets/57715922/2d256ee0-3618-4cef-9b45-55ad3ad085d4)

### Frontend Setup  
Just clone the front end file and open the index.html in a browser.

### Backend Setup  
Just clone the Backend repo and run in a enviroment where JDK 17 and Maven is compatible.
Once it start running http://localhost:8080/test will give a message.

### Issues Tackled  
I created a simple entity and followed in a way to store the gameState of the current game and the played games. It was difficult, after a careful analysis by refering couple of project I have implemented the two entity implementation which works fine but doesnt result the id for the game 
![xxo error](https://github.com/Abishethvarman/TippleXGame/assets/57715922/c43a1e86-ba98-4b6b-a5aa-897e2250d77a)  
The same id is persisting inside the state I have infused there. 

Data persisted successfully in the DB and the connection inbbetween the two entities messed and gave the same value for each id component where the foreign key doesn't work.
![xxo h2 persist](https://github.com/Abishethvarman/TippleXGame/assets/57715922/3e274e22-1518-455c-a4b4-e92486c61acb)  

These are the main and important issue where I coulnt able to store the previous data. It can only producting the latest one. 




