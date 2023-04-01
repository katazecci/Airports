SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS airport;
DROP TABLE IF EXISTS flight;
DROP TABLE IF EXISTS application_user;

SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE airport (
  id BIGINT NOT NULL AUTO_INCREMENT,
  code VARCHAR(3) NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

INSERT INTO airport (code, name) VALUES
    ('LAX', 'Los Angeles International Airport'),
    ('ORD', 'Ohare International Airport'),
    ('ATL', 'Hartsfield-Jackson Atlanta International Airport'),
    ('LHR', 'Heathrow Airport'),
    ('CDG', 'Charles de Gaulle Airport'),
    ('SYD', 'Sydney Airport'),
    ('ICN', 'Incheon International Airport'),
    ('PEK', 'Beijing Capital International Airport'),
    ('SIN', 'Singapore Changi Airport'),
    ('DXB', 'Dubai International Airport');

CREATE TABLE flight (
  id BIGINT NOT NULL AUTO_INCREMENT,
  flight_number VARCHAR(10) NOT NULL,
  airline VARCHAR(50) NOT NULL,
  departure_time DATETIME NOT NULL,
  gate VARCHAR(10) NOT NULL,
  airportid BIGINT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (airportid) REFERENCES airport(id)
);

INSERT INTO flight (flight_number, airline, departure_time, gate, airportid) VALUES
    ('AA101', 'American Airlines', '2023-04-01 10:00:00', 'A1', 1),
    ('UA202', 'United Airlines', '2023-04-01 12:00:00', 'B2', 1),
    ('DL303', 'Delta Air Lines', '2023-04-01 14:00:00', 'C3', 1),
    ('AA404', 'American Airlines', '2023-04-01 16:00:00', 'D4', 2),
    ('UA505', 'United Airlines', '2023-04-01 18:00:00', 'E5', 2),
    ('DL606', 'Delta Air Lines', '2023-04-01 20:00:00', 'F6', 2),
    ('AA707', 'American Airlines', '2023-04-01 10:30:00', 'G7', 3),
    ('UA808', 'United Airlines', '2023-04-01 12:30:00', 'H8', 3),
    ('DL909', 'Delta Air Lines', '2023-04-01 14:30:00', 'I9', 3),
    ('BA1010', 'British Airways', '2023-04-01 16:30:00', 'J10', 4),
    ('AF1111', 'Air France', '2023-04-01 18:30:00', 'K11', 4),
    ('QF1212', 'Qantas', '2023-04-01 20:30:00', 'L12', 4),
    ('KE1313', 'Korean Air', '2023-04-01 10:45:00', 'M13', 5),
    ('CA1414', 'Air China', '2023-04-01 12:45:00', 'N14', 5),
    ('SQ1515', 'Singapore Airlines', '2023-04-01 14:45:00', 'O15', 5),
    ('KE1616', 'Korean Air', '2023-04-01 16:45:00', 'P16', 6),
    ('CA1717', 'Air China', '2023-04-01 18:45:00', 'Q17', 6),
    ('SQ1818', 'Singapore Airlines', '2023-04-01 20:45:00', 'R18', 6),
    ('EK1919', 'Emirates', '2023-04-01 11:00:00', 'S19', 7),
    ('QR2020', 'Qatar Airways', '2023-04-01 13:00:00', 'T20', 7),
    ('EY2121', 'Etihad Airways', '2023-04-01 15:00:00', 'U21', 7),
    ('EK2222', 'Emirates', '2023-04-01 17:00:00', 'V22', 8),
    ('QR2323', 'Qatar Airways', '2023-04-01 19:00:00', 'W23', 8),
    ('EY2424', 'Etihad Airways', '2023-04-01 21:00:00', 'X24', 8),
    ('AC2525', 'Air Canada', '2023-04-01 11:15:00', 'Y25', 9),
    ('BA2626', 'British Airways', '2023-04-01 13:15:00', 'Z26', 9),
    ('UA2727', 'United Airlines', '2023-04-01 15:15:00', 'A27', 9),
    ('AC2828', 'Air Canada', '2023-04-01 17:15:00', 'B28', 10),
    ('BA2929', 'British Airways', '2023-04-01 19:15:00', 'C29', 10),
    ('UA3030', 'United Airlines', '2023-04-01 21:15:00', 'D30', 10);
    
CREATE TABLE application_user (
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
	, firstname VARCHAR(100) NOT NULL
	, lastname VARCHAR(100) NOT NULL
	, role  VARCHAR(100) NOT NULL
	,username VARCHAR(250) NOT NULL
	,password_hash VARCHAR(250) NOT NULL);
	INSERT INTO application_user (firstname, lastname, username, password_hash, role) 
	VALUES ('Minna', 'Pellikka', 'user', '$2a$10$1DTvwpXVBArGFixHBuzVJObjTuXhIOkx5pse6KsYs8/C2ckxnGEou', 'USER'), 
	('Otto', 'Pellikka', 'admin', '$2a$10$cDZgyF4xaPMmmoRW3OVcmuf.8o2YSx8.M7CeRKqi.1PVw.t3E8uEC', 'ADMIN');
	
SELECT * FROM airport;
SELECT * FROM flight;
SELECT * FROM application_user;