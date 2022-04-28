#CREATE DATABASE cazoAppDB;

USE cazoAppDB;

/*CREATE TABLE documento(
	documento_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    documento_tipo ENUM("DNI", "LE", "LC", "CI"),
    documento_valor VARCHAR(20) NOT NULL
);

CREATE TABLE procedencia(
	procedencia_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    procedencia_nac VARCHAR(100) NOT NULL,
    procedencia_prov VARCHAR(100) NOT NULL,
    procedencia_ciudad VARCHAR(100) NOT NULL,
    procedencia_loc VARCHAR(100) NOT NULL,
    procedencia_dir VARCHAR(100) NOT NULL,
    procedencia_dir_num INT NOT NULL,
    procedencia_cod VARCHAR(10) NOT NULL
);

CREATE TABLE foto_usuario(
	foto_usuario_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    foto_usuario_mime VARCHAR(255),
    foto_usuario_nombre VARCHAR(255),
    foto_usuario_contenido LONGBLOB
);

CREATE TABLE usuario(
	usuario_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    usuario_nombre VARCHAR(50) NOT NULL,
    usuario_clave VARCHAR(50) NOT NULL,
    usuario_correo VARCHAR(255) NOT NULL,
    usuario_tipo ENUM("NORMAL", "ADMINISTRADOR") DEFAULT "NORMAL",
    foto_usuario_id BIGINT(20),
    CONSTRAINT fk_foto_usuario FOREIGN KEY(foto_usuario_id) REFERENCES foto_usuario(foto_usuario_id)
);

CREATE TABLE socio(
	socio_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    socio_nombre VARCHAR(50) NOT NULL,
    socio_apellido VARCHAR(50) NOT NULL,
    socio_sexo ENUM("MASCULINO", "FEMENINO", "OTRO") NOT NULL,
    socio_fecha_nac DATE NOT NULL,
    socio_telefono VARCHAR(20) NOT NULL,
    usuario_id BIGINT(20),
    documento_id BIGINT(20),
    procedencia_id BIGINT(20),
    CONSTRAINT fk_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(usuario_id),
    CONSTRAINT fk_documento FOREIGN KEY(documento_id) REFERENCES documento(documento_id),
    CONSTRAINT fk_procedencia FOREIGN KEY(procedencia_id) REFERENCES procedencia(procedencia_id)
);*/