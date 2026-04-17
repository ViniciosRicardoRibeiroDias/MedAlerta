ALTER DATABASE medalerta
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

use medalerta;

create table Usuario (
	idUsuario int auto_increment not null,
	nome varchar(100) not null,
    telefone varchar(20) not null,
    email varchar(100) not null,
    enderecoRua varchar(100),
    enderecoNumero int,
    enderecoComplemento varchar(50),
    enderecoBairro varchar(50),
    enderecoCEP varchar(10),
    enderecoCidade varchar(50),
    enderecoEstado varchar(02),
    primary key (idUsuario)
);

create table Medicamento (
	idMedicamento int auto_increment not null,
    nomeComercial varchar(100) not null,
    nomeGenerico varchar(100),
    quantidade enum('unidade', 'ml'),
    formaUso varchar(100),
    observacao varchar(200),
    primary key (idMedicamento)
);

CREATE TABLE Prescricao (
    idPrescricao INT AUTO_INCREMENT NOT NULL,
    idUsuario INT NOT NULL,
    idMedicamento INT NOT NULL,
    dosagemValor INT NOT NULL,
	dosagemUnidade VARCHAR(30) NOT NULL,
    frequenciaUso INT,
	frequenciaTipo ENUM('horas',
	    'dias', 'semanas', 'dose única'),
    PRIMARY KEY (idPrescricao),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY (idMedicamento) REFERENCES Medicamento(idMedicamento)
);

create table HorarioMedicamento (
    idHorarioMedicamento int auto_increment not null,
    idPrescricao int not null,
    horario time not null,
    primary key (idHorarioMedicamento),
    foreign key (idPrescricao) references Prescricao(idPrescricao)
);

CREATE TABLE Alerta(
	idAlerta INT auto_increment NOT NULL,
    idHorarioMedicamento INT NOT NULL,
    tempoMinutos INT NOT NULL,
    statusAlerta ENUM('emitido', 'pendente', 'confirmado'),
    ativo BOOLEAN DEFAULT FALSE,
    PRIMARY KEY (idAlerta),
    FOREIGN KEY (idHorarioMedicamento) REFERENCES HorarioMedicamento(idHorarioMedicamento)
);

CREATE TABLE EstoqueMedicamento (
    idEstoque INT AUTO_INCREMENT NOT NULL,
    idPrescricao INT NOT NULL,
    quantidadeTotal INT NOT NULL,
    quantidadeAtual INT NOT NULL,
    PRIMARY KEY (idEstoque),
    FOREIGN KEY (idPrescricao) REFERENCES Prescricao(idPrescricao)
);

CREATE TABLE Cuidador (
    idCuidador INT NOT NULL AUTO_INCREMENT,
    idUsuario INT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    enderecoRua VARCHAR(100) NOT NULL,
    enderecoNumero INT NOT NULL,
    enderecoComplemento VARCHAR(50),
    enderecoBairro VARCHAR(50) NOT NULL,
    enderecoCep VARCHAR(10) NOT NULL,
    enderecoCidade VARCHAR(50) NOT NULL,
    enderecoEstado CHAR(2) NOT NULL,
    PRIMARY KEY (idCuidador),
    CONSTRAINT fk_Usuario
      FOREIGN KEY (idUsuario)
          REFERENCES Usuario (idUsuario)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);

