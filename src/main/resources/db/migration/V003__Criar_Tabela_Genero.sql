CREATE TABLE IF NOT EXISTS genero (
    id BIGINT NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO genero(descricao) VALUES('Terror');
INSERT INTO genero(descricao) VALUES('Comédia');
INSERT INTO genero(descricao) VALUES('Romance');
