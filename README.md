 Tic-Tac-Toe Game with Java Swing, PostgreSQL Login, Statistics, and Leaderboard

 Student Information

* Name: Gerard Tarigan
* Student ID: 5026251119
* Class: Q

---

 Project Description

This project is a desktop-based Tic-Tac-Toe game developed using Java Swing and PostgreSQL. The application allows users to log in using credentials stored in a database, play against a computer opponent, track their game statistics, and view the top-scoring players through a leaderboard system.

---

 Features

* User Login System using PostgreSQL database
* Tic-Tac-Toe Game GUI built with Java Swing
* Play against a computer opponent
* Win, Loss, and Draw tracking
* Automatic score calculation
* Statistics page displaying player performance
* Top 5 Scorers leaderboard
* JDBC database connectivity
* Multiple player accounts supported

---

 Database

Database Management System: PostgreSQL

Database Name:

game_project

Table Used:

players

Table Structure:

| Column   | Data Type |
| -------- | --------- |
| id       | INTEGER   |
| username | VARCHAR   |
| password | VARCHAR   |
| wins     | INTEGER   |
| losses   | INTEGER   |
| draws    | INTEGER   |
| score    | INTEGER   |

---

 How to Run

 1. Create PostgreSQL Database

Create a database named:

game_project

 2. Create the Players Table

Execute:

```sql
CREATE TABLE players (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50),
    password VARCHAR(50),
    wins INT DEFAULT 0,
    losses INT DEFAULT 0,
    draws INT DEFAULT 0,
    score INT DEFAULT 0
);
```

 3. Insert Sample Data

```sql
INSERT INTO players
(username, password, wins, losses, draws, score)
VALUES
('gerard', '12345', 0, 0, 0, 0),
('player2', '12345', 0, 0, 0, 0),
('player3', '12345', 0, 0, 0, 0),
('player4', '12345', 0, 0, 0, 0),
('player5', '12345', 0, 0, 0, 0);
```

 4. Open the Project

Open the project folder in Visual Studio Code.

 5. Add PostgreSQL JDBC Driver

Download PostgreSQL JDBC Driver and place it inside:

src/lib/

Example:

postgresql-42.7.11.jar

 6. Configure DatabaseManager.java

Update the following values:

```java
private static final String URL =
    "jdbc:postgresql://localhost:5432/game_project";

private static final String USER =
    "postgres";

private static final String PASSWORD =
    "your_password";
```

 7. Configure VS Code Classpath

Project Settings → Referenced Libraries → Add Library

Select:

postgresql-42.7.11.jar

 8. Run the Application

Run:

Main.java

or

testrun.java

Login using:

Username: gerard

Password: 12345

---

 Class Explanation

 Player.java

Represents a player object and stores player information such as username, wins, losses, draws, and score.

 DatabaseManager.java

Handles database connections to PostgreSQL using JDBC.

 PlayerService.java

Contains database operations such as login authentication, statistics updates, leaderboard retrieval, and player data retrieval.

 LoginFrame.java

Provides the login interface where users enter their username and password.

 MainMenuFrame.java

Displays the main menu and allows access to the game, statistics page, leaderboard, and exit function.

 GameLogic.java

Contains the Tic-Tac-Toe game rules including move validation, winner detection, draw detection, and computer moves.

 GameFrame.java

Displays the Tic-Tac-Toe board and handles gameplay interactions between the user and the computer.

 StatisticsFrame.java

Displays the logged-in player's statistics including wins, losses, draws, and score.

 TopScorersFrame.java

Displays the Top 5 players sorted by score.

 Main.java / testrun.java

Application entry point that launches the login screen.

---

 Screenshots

1. Login Screen ![image alt](https://github.com/gerardetarigan79/tictactoe_gameproject/blob/main/screenshot/Screenshot%202026-06-25%20185506.png?raw=true)
2. Main Menu ![image alt](https://github.com/gerardetarigan79/tictactoe_gameproject/blob/main/screenshot/Screenshot%202026-06-25%20185604.png?raw=true)
3. Tic-Tac-Toe Game Board ![image alt](https://github.com/gerardetarigan79/tictactoe_gameproject/blob/main/screenshot/Screenshot%202026-06-25%20190259.png?raw=true)
4. Statistics Page ![image alt](https://github.com/gerardetarigan79/tictactoe_gameproject/blob/main/screenshot/Screenshot%202026-06-25%20185648.png?raw=true)
5. Top Scorers Leaderboard ![image alt](https://github.com/gerardetarigan79/tictactoe_gameproject/blob/main/screenshot/Screenshot%202026-06-25%20185709.png?raw=true)
6. PostgreSQL Database Table ![image alt](https://github.com/gerardetarigan79/tictactoe_gameproject/blob/main/screenshot/Screenshot%202026-06-25%20193126.png?raw=true)

---

 Video Link

YouTube Demonstration:

[[YouTube Video Link](https://youtu.be/1W74K54lftQ)]
