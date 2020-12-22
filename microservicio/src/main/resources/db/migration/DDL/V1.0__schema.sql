create table servicio_estetico(
    id int(11) not null auto_increment,
    id_servicio varchar(12) not null,
    nombre varchar(100) not null,
    tipo_servicio varchar(50) not null,
    costo int(10) not null,
    estado_servicio boolean not null,
    primary key (id)
);

create table promocion(
    id int(11) not null auto_increment,
    id_servicio varchar(12) not null,
    porcentaje float not null,
    dia varchar(10),
    primary key (id),
    foreign key (id_servicio) references servicio_estetico(id_servicio)
);