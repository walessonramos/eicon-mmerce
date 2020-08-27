insert into t_cliente (t_cliente_id, t_cliente_nome) values (1,'Ronaldo Nazário');
insert into t_cliente (t_cliente_id, t_cliente_nome) values (2,'Zinédine Zidane');
insert into t_cliente (t_cliente_id, t_cliente_nome) values (3,'Ronaldo de Assis Moreira');
insert into t_cliente (t_cliente_id, t_cliente_nome) values (4,'Arthur Antunes Coimbra');
insert into t_cliente (t_cliente_id, t_cliente_nome) values (5,'Paulo Roberto Falcão');
insert into t_cliente (t_cliente_id, t_cliente_nome) values (6,'Edson Arantes do Nascimento');

insert into t_produto (t_produto_id, t_produto_nome, t_produto_valor) values (1,'SmartPhone S10', 2.500);
insert into t_produto (t_produto_id, t_produto_nome, t_produto_valor) values (2,'Smart TV LG 55 4K', 3.500);
insert into t_produto (t_produto_id, t_produto_nome, t_produto_valor) values (3,'NoteBook DELL Core I5 tela 15.6 8 GB RAM', 3.200);
insert into t_produto (t_produto_id, t_produto_nome, t_produto_valor) values (4,'SmartPhone Xiaomi mi 9 lite', 2.000);
insert into t_produto (t_produto_id, t_produto_nome, t_produto_valor) values (5,'Galax Tab Samsung 2 GB RAM', 1.000);

INSERT INTO `eicommerce`.`t_pedido` (`t_pedido_id`, `t_pedido_data`, `t_pedido_qtd`, `t_pedido_valor_total`, `t_cliente_id`, `t_produto_id`) VALUES ('1', '2020-08-15 22:17:53.812000', '2', '2000', '1', '5');
INSERT INTO `eicommerce`.`t_pedido` (`t_pedido_id`, `t_pedido_data`, `t_pedido_qtd`, `t_pedido_valor_total`, `t_cliente_id`, `t_produto_id`) VALUES ('2', '2020-08-19 22:17:53.812000', '3', '7500', '2', '1');



