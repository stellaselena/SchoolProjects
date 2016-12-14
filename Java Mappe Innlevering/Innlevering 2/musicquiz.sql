CREATE SCHEMA IF NOT EXISTS serverquiz;
USE serverquiz;
DROP TABLE IF EXISTS musicquiz;

CREATE TABLE musicquiz
(
  artist  VARCHAR(55),
  song VARCHAR(55),
  year  INT
);

INSERT INTO `musicquiz` (`artist`, `song`, `year`)
VALUES
  ('Adele', 'Hometown Glory', 2008),
  ('Rammstein', 'Du Hast', 1997),
  ('Lana Del Ray','Video Games', 2012),
  ('Lenny Kravitz','Fly Away', 1998),
  ('Hozier','Take Me To Church', 2014);