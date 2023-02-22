ALTER TABLE filmes
ADD CONSTRAINT FK_filmes_genero
FOREIGN KEY(idgenero)
REFERENCES genero(id);

ALTER TABLE filmes
ADD CONSTRAINT FK_filmes_ator
FOREIGN KEY(idator)
REFERENCES ator(id);