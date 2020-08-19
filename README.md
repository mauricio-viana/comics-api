# Comics API

Recriando API quadarinho flix, objetivo exercitar os conhecimentos com a linguagem Java e acrescentar segurança, autenticação 
e novas funcionalidades de paginação a API.

## Como utilizar o projeto?
Os passos abaixo estão baseados em sistema [Linux Ubuntu](https://ubuntu.com/)

### Requesitos
- Java 8
- Docker

**DataBase**

Obtendo a imagem [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```sh
# Criando container
$ docker run --name comicsflix-db -d -p 5432:5432 -e POSTGRES_USER=user_comicsflix -e POSTGRES_PASSWORD=password_comicsflix -e POSTGRES_DB=comicsflix postgres
```

**Projeto**

```sh
# Baixe o projeto
$ git clone https://github.com/mauricio-viana/comicsflix-api.git
```

**Opcional: Pupular tabelas**

1º - Crie o arquivo com nome import.sql dentro do diretorio src/main/resources

2º - Gerar senha [BCrypt](https://passwordhashing.com/BCrypt)

3º - Copie as instruções abaixo para dentro do arquivo import.sql (Não esqueça de substituir a senha do user_api)

```sql
INSERT INTO category( title, color, description) VALUES('Quadrinhos?','#6BD1FF','Conteúdos sobre os quadrinhos');
INSERT INTO category( title, color, description) VALUES('Previsões e curiosidades','#1548a9','Youtubers com teorias sobre os destinos dos animes e desvendando mistérios.');

INSERT INTO video(title, url, description,category_id) VALUES ('BARBA BRANCA: O PIRATA QUE MORREU DE PÉ','https://www.youtube.com/watch?v=SvJcHB5R-Dg','',1);
INSERT INTO video(title, url, description,category_id) VALUES ('CRONOLOGIA: X-MEN - GUIA DE LEITURA','https://www.youtube.com/watch?v=jBWORLynLv8','',1);
INSERT INTO video(title, url, description,category_id) VALUES ('REVELADO! O ORIGEM DOS TITÃS: NÃO ERA O QUE VOCÊ PENSAVA','https://www.youtube.com/watch?v=UjCxp1Zbsro','',1);
INSERT INTO video(title, url, description,category_id) VALUES ('10 HQs PARA COMEÇAR A LER MARVEL','https://www.youtube.com/watch?v=1Hfv2BgBVLY','',1);
INSERT INTO video(title, url, description,category_id) VALUES ('YU YU HAKUSHO: DIFERENÇAS MANGÁ VS ANIME ► CURIOSIDADES!','https://www.youtube.com/watch?v=8Vqe6BhnSfc','',1);

INSERT INTO video(title, url, description,category_id) VALUES ('O MOTIVO DE RAYLEIGH E ODEN NÃO CONTAREM AO MUNDO SOBRE O SÉCULO PERDIDO-IM HAKUBA E MIHAWK','https://www.youtube.com/watch?v=RlppdidjcCg','',2);
INSERT INTO video(title, url, description,category_id) VALUES ('REVELADO QUEM É O PAI DE ZORO E A MORTE DE UM CHAPÉU DE PALHA CONFIRMADA? ONE PIECE','https://www.youtube.com/watch?v=cQBwvjatvjA','',2);

INSERT INTO user_api(name, email, password) VALUES ('User', 'api@email.com', 'COLE AQUI SUA SENHA'); 
```

## Autor

**Mauricio Viana**

- Linkedin: [@mauricio-viana](https://www.linkedin.com/in/mauricio-viana)
- Github: [@mauricio-viana](https://github.com/mauricio-viana)