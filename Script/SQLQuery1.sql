--create database prueba1
--go
--use prueba1
--go
--create table persona ( 
--idpersona int not null primary key identity(1,1) ,
--nombre varchar(50) not null,
--apellidoP varchar(50) not null,
--apellidoM varchar(50) not null,
--Estado bit not null default 1)
--go
--insert into persona(nombre,apellidoP,apellidoM)VALUES ('Juan','Anton','Bernal')
--insert into persona(nombre,apellidoP,apellidoM)VALUES ('Tania','Tafur','Callirgos')
--insert into persona(nombre,apellidoP,apellidoM)VALUES ('Chrsitian','Tocto','Lopez')
--go
--create procedure AgregarPersona(
--@nombre varchar(50),
--@apellidoP varchar(50),
--@apellidoM varchar(50))
--as
--insert into persona(nombre,apellidoP,apellidoM)VALUES (@nombre,@apellidoP,@apellidoM)
--go
--create procedure Listar
--as
--select * from persona where Estado=1
--go
--create procedure UpdatePersona(
--@nombre varchar(50),
--@apellidoP varchar(50),
--@apellidoM varchar(50),
--@idper int)
--as
--update persona set nombre=@nombre,apellidoP=@apellidoP,apellidoM=@apellidoM where idpersona=@idper
--go
--create procedure DeletePersona(
--@idper int)
--as
--update persona set Estado=0 where idpersona=@idper

GO
USE MASTER 
GO

GO
CREATE DATABASE SESION
GO

GO
USE SESION
GO

GO
CREATE TABLE SESION(
USUARIO VARCHAR(30),
PASS VARCHAR(MAX),
ESTATUS BIT
)
GO

GO
CREATE PROCEDURE ENCRIPT(
@USUARIO VARCHAR(30),
@PASS VARCHAR(MAX),
@ESTATUS BIT
)
AS
INSERT INTO SESION(USUARIO,PASS,ESTATUS) VALUES (@USUARIO,@PASS,@ESTATUS)
GO
GO


CREATE PROCEDURE Listar
AS
SELECT * FROM SESION
GO

CREATE PROCEDURE UpdateSessionActivo(
@USUARIO VARCHAR(30),
@PASS VARCHAR(MAX),
@ESTATUS BIT
)
AS
update SESION set ESTATUS = 1 where USUARIO = @USUARIO AND PASS = @PASS
GO

CREATE PROCEDURE UpdateSessionInactivo(
@USUARIO VARCHAR(30),
@PASS VARCHAR(MAX),
@ESTATUS BIT
)
AS
update SESION set ESTATUS = 0 where USUARIO = @USUARIO AND PASS = @PASS
GO
--GO
--USE SEGURIDAD
USE SESION
SELECT * FROM SESION