
create table JOGADOR (
	ID_JOGADOR INT,
    CPF VARCHAR(11),
    NICKNAME VARCHAR(50),
    INDICADOR_FOME INT,
    INDICADOR_SEDE INT,
    INDICADOR_SONO INT,
    ID_EMPREGO INT,
    DINHEIRO DECIMAL,
    INDICADOR_JOGADOR_PRESO bool
);

create table VEICULO (
	ID INT,
    PRECO DECIMAL,
    NOME VARCHAR(200),
    PATH_IMAGEM_VEICULO VARCHAR(400)
);

create table SESSAO (
	ID INT
);

create table PRODUTO(
	ID_PRODUTO INT,
    NOME VARCHAR(50),
    PRECO DECIMAL,
    CATEGORIA INT
);