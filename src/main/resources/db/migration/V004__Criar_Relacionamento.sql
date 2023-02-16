ALTER TABLE Filmes
ADD CONSTRAINT FK_Filmes_Genero
FOREIGN KEY(idgenero)
REFERENCES Filmes(id);

ALTER TABLE Filmes
ADD CONSTRAINT FK_Filmes_Ator
FOREIGN KEY(idator)
REFERENCES Ator(id);

INSERT INTO Contato(clienteid, descricao, contato)
VALUES  (1, "Encanador", "+(55) 14 99610-2925"),
        (2, "Jogador de Basquete", "+(55) 14 99723-3221"),
        (3, "Jogador de Baseball", "+(55) 14 99326-1728");