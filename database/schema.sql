CREATE DATABASE game_project;

\c game_project

CREATE TABLE players (
id SERIAL PRIMARY KEY,
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL,
wins INT DEFAULT 0,
losses INT DEFAULT 0,
draws INT DEFAULT 0,
score INT DEFAULT 0
);

INSERT INTO players
(username, password, wins, losses, draws, score)
VALUES
('gerard', '12345', 4, 2, 2, 46),
('player2', '12345', 0, 0, 0, 0),
('player3', '12345', 0, 0, 0, 0),
('player4', '12345', 2, 1, 0, 20),
('player5', '12345', 1, 2, 1, 13);

SELECT * FROM players;

SELECT username, wins, losses, draws, score
FROM players;

SELECT username, score
FROM players
ORDER BY score DESC;

SELECT username, score
FROM players
ORDER BY score DESC
LIMIT 5;