CREATE TABLE produto (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(300),
    preco DECIMAL(10,2) NOT NULL,
    id_categoria BIGINT(20) NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categoria(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;