CREATE TABLE peixes(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    nome_cientifico varchar(250) NOT NULL,
    nome_comum varchar(250) NOT NULL,
    tipo varchar(100) NOT NULL,
    ativo tinyint(1) DEFAULT 1,
    PRIMARY KEY(id)
)