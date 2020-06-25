INSERT INTO cargo_entity (id, nome, descricao) 
VALUES (1000, '', '');

INSERT INTO curso_entity (id, nome_curso, instituicao, data_inicial, data_final) 
VALUES (1000, '', '', now(), now());

INSERT INTO endereco_entity (id, cep, logradouro, numero, bairro, cidade, estado, telefone, celular, email) 
VALUES (1000, '1', '', '', '', '', '', '1', '1', '');

INSERT INTO experiencia_entity (id, nome_empresa, cargo, data_inicial, data_final) 
VALUES (1000, '', '', now(), now());

INSERT INTO formacao_entity (id, nome_curso, instituicao, data_inicial, data_final) 
VALUES (1000, '', '', now(), now());

INSERT INTO login_entity (id, username, senha) 
VALUES (1000, '', '');

INSERT INTO candidato_entity (id, nome_completo, rg, cpf, sexo, data_nascimento, is_inativo, login_id, endereco_id) 
VALUES (1000, '', '', '', '', now(), false, 1000, 1000);

INSERT INTO curriculo_entity (id, candidato_id, curso_id, experiencia_id, formacao_id) 
VALUES (1000, 1000, 1000, 1000, 1000);

INSERT INTO empresa_entity (id, razao_social, nome_fantasia, cnpj, is_inativo, login_id, endereco_id) 
VALUES (1000, '', '', '', false, 1000, 1000);

INSERT INTO vaga_entity (id, descricao, salario, carga_horaria, is_finalizado, cargo_id, empresa_id) 
VALUES (1000, '', 0, '', false, 1000, 1000);

INSERT INTO candidato_vaga_entity (id, candidato_id, vaga_id) 
VALUES (1000, 1000, 1000);