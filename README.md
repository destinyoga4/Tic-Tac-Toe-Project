# Tic-Tac-Toe-Project with Java Swing, Login, and Statistic

## Student Information
Name       : Destin Yoga Aghniansyah
Student ID : 5026251100
Class      : E

## Project Description
This project is a simple Tic-Tac-Toe game built using Java Swing.
The application includes login, play game, game statistics, and Top 5 Scorer
feature. This game consist 1 user and 1 computer with random move.

## Features
- Login using database (MySQL)
- Playing Tic-Tac-Toe using Swing GUI
- Record Wins, Losses, Draws, and Score
- Display personal statistic
- Display Top 5 Scorers using Jtable

## Database
Database used : MySQL
Database Table : Just one table namely players

## How to Run
### 1. Create the database.
You can copy this code and paste into the sql query<br>
CREATE DATABASE game_project;

### 2. Import schema.sql.
- First use the database that has been created<br>
USE game_project;<br>
- Then import the schema.sql

### 3. Download the connector, JDBC driver for MySQL
You can download in this link<br>
https://dev.mysql.com/downloads/connector/j/

### 4. Open the Java project.
Open the referenced library fot the java project.

### 5. Add JDBC driver.
Add the file jar that has been downloaded before.

### 6. Configure DatabaseManager.java.
Configure the DatabaseManager.java with your own database.
Change the username dan password with your username and password that you use for login to the database.

### 7. Run Main.java.
Login with username dan password that has been registered in database table.
Example :
username : student1
password : 12345

## Class Explanation
| Class | Explanation |
| --- | --- |
| Main | Entry point of the application, launch the game. |
| DatabaseManager | Manages the MySql database connection. |
| Player | Model class representing player data, username, wins, losses, draws, and score. |
| PlayerService | Handle player login, update statistic in database, and get top 5 scorers. |
| GameLogic | Contains the logic of the game, the core tic-tac-toe rules and domputers random move logic. |
| LoginFrame | Swing window for user login. |
| MainMenuFrame | Swing window for displaying navigation after succesful login. |
| GameFrame | Swing window for gameplay tic-tac-toe. |
| StatisticsFrame | Swing window for displaying the personal statistic user. |
| TopScorersFrame | Swing windows for displaying top 5 scorers player from database using jtable. |

## Screenshots
<img width="422" height="551" alt="Screenshot 2026-06-26 163031" src="https://github.com/user-attachments/assets/843cebaf-7760-4faf-9a19-66462110901f" />
<img width="482" height="614" alt="image" src="https://github.com/user-attachments/assets/3d97d0bd-d5c6-4945-8563-db0a62ba0d22" />
<img width="479" height="607" alt="image" src="https://github.com/user-attachments/assets/204f7fe9-2a42-4991-be43-9f262c2b50e3" />
<img width="355" height="421" alt="image" src="https://github.com/user-attachments/assets/b10a1e2c-fd19-4486-aed6-842d74445f12" />
<img width="604" height="424" alt="image" src="https://github.com/user-attachments/assets/e9cf647b-1104-4131-84ad-a538b2547bce" />

## Video Link
https://youtu.be/MDAICclmvew




