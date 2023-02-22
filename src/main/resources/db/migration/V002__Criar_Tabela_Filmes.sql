CREATE TABLE IF NOT EXISTS filmes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nomefilme VARCHAR(255) NOT NULL,
    idgenero BIGINT NOT NULL,
    idator BIGINT NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO filmes(nomefilme, idgenero, idator) VALUES('Algum Filme', 1, 1);
INSERT INTO filmes(nomefilme, idgenero, idator) VALUES('Outro Filme', 2, 2);
INSERT INTO filmes(nomefilme, idgenero, idator) VALUES('O Filme', 3, 3);

