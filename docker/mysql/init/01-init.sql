-- Arquivo para dados iniciais.
-- Adicione inserts de exemplo para nossos testes e correção.
-- Exemplo simples de inserção de dados.
-- Mostraremos 2 tabelas com 3 colunas cada e relacionadas entre si.
USE medalerta;
CREATE TABLE Terceiros(
	idTerceiros INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    enderecoRua VARCHAR(100) NOT NULL,
    enderecoNumero INT NOT NULL,
    enderecoComplemento VARCHAR(50),
    enderecoBairro VARCHAR(50) NOT NULL,
    enderecoCep VARCHAR(10) NOT NULL,
    enderecoCidade VARCHAR(50) NOT NULL,
    enderecoEstado CHAR(2) NOT NULL,
    idUsuario INT NOT NULL,
    PRIMARY KEY (idAcompanhante),
    CONSTRAINT fk_Acompanhante_Usuario
        FOREIGN KEY (idUsuario)
        REFERENCES USUARIO (idUsuario)
        ON DELETE CASCADE
        ON UPDATE CASCADE