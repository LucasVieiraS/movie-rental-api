CREATE TABLE IF NOT EXISTS Filmes (
    id BIGINT NOT NULL,
    nomefilme VARCHAR NOT NULL,
    idgenero BIGINT NOT NULL,
    idator BIGINT NOT NULL,
    PRIMARY KEY(id)
);