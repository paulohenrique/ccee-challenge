DROP TABLE people IF EXISTS;

CREATE TABLE regiao  (
    id INT PRIMARY KEY AUTO_INCREMENT,
    sigla VARCHAR(2),
    geracao NUMERIC,
    compra NUMERIC,
    agente_id INT
);

CREATE TABLE IF NOT EXISTS `agente` (
    `id` INTEGER  PRIMARY KEY AUTO_INCREMENT,
    `codigo` VARCHAR(50),
    `data` TIMESTAMP
 );

