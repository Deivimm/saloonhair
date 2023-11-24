CREATE TABLE fornecedor (
        cnpj VARCHAR(14) PRIMARY KEY UNIQUE NOT NULL,
        razaoSocial TEXT NOT NULL,
        nomeFantasia TEXT,
        endereco VARCHAR(255),
        cidade VARCHAR(255),
        cep VARCHAR(9),
        fone VARCHAR(15),
        celular1 VARCHAR(15) NOT NULL,
        celular2 VARCHAR(15),
        email VARCHAR(255)
);