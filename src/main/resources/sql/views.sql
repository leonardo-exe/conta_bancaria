create view view_enderecos as
select e.id, e.numero, l.logradouro, b.bairro, c.cidade, es.sigla
from Enderecos e
inner join Logradouros l on e.id_logradouro = l.id
inner join Bairros b on l.id_bairro = b.id
inner join Cidades c on b.id_cidade = c.id
inner join Estados es on c.sigla_estado = es.sigla;

create view endereco_agencias as
select a.numero_agencia, a.id_banco, v.numero, v.logradouro, v.bairro, v.cidade, v.sigla
from Agencias a
inner join view_enderecos v on a.id_endereco = v.id;

create view extrato as
select c.numero_conta, m.valor, m.data_movimentacao, t.tipo_transacao
from Contas c
inner join Movimentacoes m on c.id = m.id_conta
inner join Transacoes t on m.id_transacao = t.id;