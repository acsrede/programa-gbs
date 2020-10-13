DROP TABLE IF EXISTS programa;

CREATE TABLE programa (
    id VARCHAR(10),
    nome VARCHAR(100) NOT NULL,
    data_cadastro TIMESTAMP NOT NULL,
    ativo BIT(1) DEFAULT 1,
    data_exclusao TIMESTAMP
);

INSERT INTO programa (id, nome, data_cadastro, ativo) VALUES ('MAVO', 'MAIS VOCE', TO_TIMESTAMP('2020-09-30 08:00:00.765000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);
INSERT INTO programa (id, nome, data_cadastro, ativo) VALUES ('N19H', 'NOVELA 19H', TO_TIMESTAMP('2020-09-30 08:00:00.765000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);
INSERT INTO programa (id, nome, data_cadastro, ativo) VALUES ('HUCK', 'CALDEIRAO DO HUCK', TO_TIMESTAMP('2020-09-30 08:00:00.765000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);
INSERT INTO programa (id, nome, data_cadastro, ativo) VALUES ('DFAU', 'DOMINGAO DO FAUSTAO', TO_TIMESTAMP('2020-09-30 08:00:00.765000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 1);