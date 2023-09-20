drop database if exists sondeos;
create database sondeos;
use sondeos;

create table usuarios(
idUsuario int(11) primary key not null auto_increment,
correo varchar(100) unique not null, 
contrasenna varchar(150) not null
);

CREATE TABLE ciudadano(
idCiudadano INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
estrato INT(11) NOT NULL , 
tipoDoc VARCHAR(100) NOT NULL , 
doc INT(15) NOT NULL , 
nombres VARCHAR(100) NOT NULL , 
apellidos VARCHAR(100) NOT NULL , 
sexo VARCHAR(50) NOT NULL , 
celular INT(15) NOT NULL , 
fijo INT(15) NOT NULL , 
municipio VARCHAR(150) NOT NULL , 
direccion VARCHAR(150) NOT NULL , 
barrio VARCHAR(150) NOT NULL , 
fechaNac DATE NOT NULL , 
etnia VARCHAR(100) NOT NULL , 
condicion VARCHAR(100) NOT NULL,
idUsuario int(11) not null
);

create table respuestas(
idRespuesta int(11) primary key auto_increment,
respuesta varchar(200) not null,
idCiudadano int(11) not null,
idTema int(11) not null
);

create table tema(
idTema int(11) primary key auto_increment,
titulo varchar(150) not null, 
descripción varchar(150) not null, 
fechaInicio date not null,
fechaFin date not null,
parametros varchar(100) not null,
pregunta varchar(100) not null,
idAdministrador int(11) not null
);

create table administrador(
idAdministrador int(11) primary key auto_increment,
nombre varchar(100) not null,
apellido varchar(100) not null,
idUsuario int(11) not null
);

create table certificado(
identificador INT(6) ZEROFILL AUTO_INCREMENT primary key, 
fechaCert TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null,
idTema int(11) not null,
idRespuesta int(11) not null,
idCiudadano int(11) not null
);

create table sondeos(
idSondeo int(11) primary key auto_increment,
cantidad int(11) not null,
fechaSondeo date not null,
idRespuesta int(11) not null,
idTema int(11) not null
);

#Relaciones

#Usuario -> ciudadano
alter table ciudadano
add constraint UsuCiuFK foreign key (idUsuario)
references usuarios(idUsuario);

#Usuario -> administrador
alter table administrador
add constraint UsuAdmFK foreign key (idUsuario)
references usuarios(idUsuario);

#Administrador -> tema
alter table tema
add constraint AdmTemFK foreign key (idAdministrador)
references administrador(idAdministrador);

#Ciudadano -> respuesta
alter table respuestas
add constraint ResCiuFK foreign key (idCiudadano)
references ciudadano(idCiudadano);

#Tema -> respuesta
alter table respuestas
add constraint ResTemFK foreign key (idTema)
references tema(idTema);

#Respuesta -> Certificado
alter table certificado
add constraint CerResFK foreign key (idRespuesta)
references respuestas(idRespuesta);

#Tema -> Certificado
alter table certificado
add constraint CerTemFK foreign key (idTema)
references tema(idTema);

#Ciudadano -> Certificado
alter table certificado
add constraint CerCiuFK foreign key (idCiudadano)
references ciudadano(idCiudadano);

#Respuesta -> Sondeos
alter table sondeos
add constraint SonResFK foreign key (idRespuesta)
references respuestas(idRespuesta);

#Tema -> Sondeos
alter table sondeos
add constraint SonTemFK foreign key (idTema)
references tema(idTema);
