insert into pessoa(id, nome, nascimento) values(1, 'Eduardo Victor', '2002-01-21');
insert into pessoa(id, nome, nascimento) values(2, 'Victor', '1999-07-14');

insert into endereco(id, cidade, logradouro, numero, cep, principal, pessoa_id) values(1, 'Brasília', 'Jardim Botânico', '14', '71458654', 'true', 1);

insert into endereco(id, cidade, logradouro, numero, cep, principal, pessoa_id) values(2, 'Brasília', 'São Sebastião', '08', '71442565', 'false', 1);

insert into endereco(id, cidade, logradouro, numero, cep, principal, pessoa_id) values(3, 'Brasília', 'Gama', '22', '75447896', 'true', 2);


