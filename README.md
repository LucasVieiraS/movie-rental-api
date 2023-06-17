<div align="center">
  <h1>Movie Rental API</h1>
  <p>Responsible for handling movie information for a movie rental service</p>
</div>
<div align="center">
  <a href="/"><img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"></a>
  <a href="/"><img src="https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white"></a>
  <a href="/"><img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"></a>
</div>

## Entities:

```Ator```
>- id<br>
>- nome<br>
>- filmes<br>

```Filmes```
>- id<br>
>- nomefilme<br>
>- ator<br>
>- genero<br>

## Methods:

```/atores```
  - ```/todos```: returns all actors<br>
  - ```/```: returns actors, filtering by ```nome```<br>

```/filmes```
  - ```/todos```: returns all movies<br>
  - ```/```: returns movies, filtering by ```nomefilme```, ```genero```, ```ator```.

```/genero```
  - ```/todos```: returns all genres<br>
  - ```/```: returns genres, filtering by ```descricao```<br>

## Contributing

If you wanna contribute to the project, follow these rules:
- Fork the project
- Create a new branch with the feature name
- Open a pull-request
- Wait for approval
