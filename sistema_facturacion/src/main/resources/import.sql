INSERT INTO clientes (nombre, apellido , email) VALUES ('Dayron', 'Novo', 'da@e'),('Lorena', 'Garcia', 'da@e'),('Gabriela', 'Capote', 'da@e'),('Daniela', 'Perez', 'da@e'),('Maria', 'Isabel', 'da@e'),('Edilia', 'Leyva', 'da@e');
insert into productos (nombre, precio) values ('laptop hp', 567.56), ('camara de fotos', 243.21), ('impresora', 54.21);

insert INTO facturas (descripcion, observacion, cliente_id) values ('laptop', 'ninguna', 2);
insert INTO facturas (descripcion, observacion, cliente_id) values ('impresora', 'ninguna', 3);

insert INTO items_factura (cantidad, producto_id, factura_id) values (3, 1, 1);
insert INTO items_factura (cantidad, producto_id, factura_id) values (2, 2, 1);

insert INTO items_factura (cantidad, producto_id, factura_id) values (1, 1, 2);
insert INTO items_factura (cantidad, producto_id, factura_id) values (1, 1, 2);
