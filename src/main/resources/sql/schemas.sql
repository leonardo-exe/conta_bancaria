create table estados (
    id serial primary key,
    sigla varchar(2),
    estado varchar(32)
);
create table cidades (
    id serial primary key,
    cidade varchar(32),
    id_estado int,
    foreign key(id_estado) references estados(id)
);
create table bairros (
    id serial primary key,
    bairro varchar(32),
    id_cidade int,
    foreign key(id_cidade) references cidades(id)
);
create table logradouros (
    id serial primary key,
    logradouro varchar(32),
    id_bairro int,
    foreign key(id_bairro) references bairros(id)
);
create table CEP (
    CEP varchar(8) primary key,
    id_logradouro int,
    foreign key(id_logradouro) references logradouros(id)
);
create table enderecos (
    id serial primary key,
    CEP varchar(8),
    numero int,
    complemento varchar(32),
    foreign key(CEP) references CEP(CEP)
);
create table clientes (
    id serial primary key,
    id_endereco int,
    tipo_pessoa varchar(1),
    foreign key (id_endereco) references enderecos(id)
);
create table pessoa_fisica (
    id_cliente int primary key,
    CPF varchar(11),
    RG varchar(9),
    nome varchar(64),
    foreign key(id_cliente) references clientes(id)
);
create table pessoa_juridica (
    id_cliente int primary key,
    CNPJ varchar(14),
    razao varchar(64),
    foreign key(id_cliente) references clientes(id)
);
create table emails (
    email varchar(64) primary key,
    id_cliente int,
    foreign key(id_cliente) references clientes(id)
);
create table telefones (
    numero varchar(9),
    DDD varchar(3),
    id_cliente int,
    primary key(numero, DDD),
    foreign key(id_cliente) references clientes(id)
);
create table bancos (
    id int primary key,
    foreign key(id) references clientes(id)
);
create table agencias (
    id serial primary key,
    numero_agencia varchar(20),
    id_endereco int,
    id_banco int,
    foreign key(id_endereco) references enderecos(id),
    foreign key(id_banco) references bancos(id)
);
create table contas (
    id serial primary key,
    numero_conta varchar(20),
    id_cliente int,
    id_agencia int,
    data_abertura varchar(8),
    foreign key(id_cliente) references clientes(id),
    foreign key(id_agencia) references agencias(id)
);
create table transacoes (
    id serial primary key,
    tipo_transacao varchar(32)
);
create table investimentos (
    id serial primary key,
    tipo_investimento varchar(32),
    rendimento decimal
);
create table movimentacoes (
    id_conta1 int,
    id_conta2 int,
    id_transacao int,
    valor decimal,
    data_movimentacao varchar(8),
    foreign key(id_conta1) references contas(id),
    foreign key(id_conta2) references contas(id),
    foreign key(id_transacao) references transacoes(id)
);
create table investidos (
    id_conta int,
    id_investimento int,
    valor decimal,
    data_investimento varchar(8),
    foreign key(id_conta) references contas(id),
    foreign key(id_investimento) references investimentos(id)
);
