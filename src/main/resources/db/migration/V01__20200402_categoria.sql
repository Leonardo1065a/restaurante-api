CREATE TABLE categoria (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(300),
    icone VARCHAR(50) NOT NULL,
    tp_icone VARCHAR(1) NOT NULL,
    ordem BIGINT(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;