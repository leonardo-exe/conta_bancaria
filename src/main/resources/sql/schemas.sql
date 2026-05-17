create table Estados (
    sigla varchar(2) primary key,
    estado varchar(32)
);
create table Cidades (
    id serial primary key,
    cidade varchar(32),
    sigla_estado varchar(2),
    foreign key(sigla_estado) references estados(sigla)
);
create table Bairros (
    id serial primary key,
    bairro varchar(32),
    id_cidade int,
    foreign key(id_cidade) references cidades(id)
);
create table Logradouros (
    id serial primary key,
    logradouro varchar(32),
    id_bairro int,
    foreign key(id_bairro) references bairros(id)
);
create table Cep (
    cep varchar(9) primary key
);
create table Enderecos (
    id serial primary key,
    cep varchar(9),
    numero int,
    complemento varchar(32),
    id_logradouro int,
    foreign key (id_logradouro) references Logradouros(id),
    foreign key (cep) references Cep(cep)
);
create table Clientes (
    id serial primary key,
    id_endereco int,
    tipo_pessoa varchar(1),
    foreign key (id_endereco) references enderecos(id)
);
create table PF (
    id_cliente int primary key,
    cpf varchar(11),
    rg varchar(9),
    nome varchar(64),
    foreign key(id_cliente) references clientes(id)
);
create table PJ (
    id_cliente int primary key,
    cnpj varchar(14),
    razao varchar(64),
    foreign key(id_cliente) references clientes(id)
);
create table Emails (
    email varchar(64) primary key,
    id_cliente int,
    foreign key(id_cliente) references clientes(id)
);
create table Telefones (
    numero varchar(9),
    ddd varchar(3),
    id_cliente int,
    primary key(numero, ddd),
    foreign key(id_cliente) references clientes(id)
);
create table Bancos (
    id int primary key,
    foreign key(id) references clientes(id)
);
create table Agencias (
    id serial primary key,
    numero_agencia varchar(20),
    id_endereco int,
    id_banco int,
    foreign key(id_endereco) references enderecos(id),
    foreign key(id_banco) references bancos(id)
);
create table Contas (
    id serial primary key,
    numero_conta varchar(20),
    id_cliente int,
    id_agencia int,
    data_abertura varchar(8),
    foreign key(id_cliente) references clientes(id),
    foreign key(id_agencia) references agencias(id)
);
create table Transacoes (
    id serial primary key,
    tipo_transacao varchar(32)
);
create table Investimentos (
    id serial primary key,
    tipo_investimento varchar(32),
    rendimento decimal
);
create table Movimentacoes (
    id_conta1 int,
    id_conta2 int,
    id_transacao int,
    valor decimal,
    data_movimentacao varchar(8),
    foreign key(id_conta1) references contas(id),
    foreign key(id_conta2) references contas(id),
    foreign key(id_transacao) references transacoes(id)
);
create table Investidos (
    id_conta int,
    id_investimento int,
    valor decimal,
    data_investimento varchar(8),
    foreign key(id_conta) references contas(id),
    foreign key(id_investimento) references investimentos(id)
);
