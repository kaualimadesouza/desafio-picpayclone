CREATE TABLE Usuario (
    cpf_cnpj VARCHAR(14) PRIMARY KEY NOT NULL,
    nome_completo VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    saldo NUMERIC NOT NULL,
    tipo_usuario VARCHAR(50) NOT NULL
);