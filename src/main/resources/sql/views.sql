create view View_Bancos as
select Bancos.id, PJ.razao
from Bancos
inner join PJ on Bancos.id = PJ.id_cliente;