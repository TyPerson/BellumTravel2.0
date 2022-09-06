drop database bellumtravel;
create database bellumtravel
default character set utf8
default collate utf8_general_ci;

use bellumtravel;

CREATE TABLE Pessoa (
    idPessoa INTEGER primary key auto_increment,
    nome VARCHAR(120),
    cpf VARCHAR(14), /*000.000.000-00*/
    telefone VARCHAR(19), /*000-(000)90000-0000*/
    email VARCHAR(100),
    endereco VARCHAR(200),
    manager BOOLEAN,
    sexo VARCHAR(1),
    UNIQUE (IdPessoa, cpf)
) default charset = utf8;

CREATE TABLE Viagem (
    codigo INTEGER UNIQUE primary key auto_increment,
    destino SMALLINT,
    itinerario VARCHAR(300),
    periodo SMALLINT,
    programacao VARCHAR(500),
    vagas SMALLINT,
    dataInicio VARCHAR(11),
    dataFim VARCHAR(11)
) default charset = utf8;

CREATE TABLE Reserva (     /*problema ocorreu, na foreign key*/
    protocolo INTEGER,
    momento DATE,
    confirmado BOOLEAN,
    pagamento SMALLINT,
    idReserva INTEGER primary key auto_increment,
    foreign key (idPessoa) references Pessoa(idPessoa),
    foreign key (codViagem) references Viagem(codigo),
    UNIQUE (protocolo, IdReserva)
) default charset = utf8;
