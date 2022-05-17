USE cazoAppDB;

SELECT * FROM socio;

#SELECT socio_nombre, socio_apellido, usuario_nombre, usuario_clave FROM socio JOIN usuario ON socio.usuario_id LIKE usuario.usuario_id;

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

CREATE TABLE imagen(
	imagen_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    imagen_mime VARCHAR(255),
    imagen_nombre VARCHAR(255),
    imagen_contenido LONGBLOB
);

CREATE TABLE usuario(
	usuario_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    usuario_nombre VARCHAR(50) NOT NULL,
    usuario_clave VARCHAR(255) NOT NULL,
    usuario_clave_rep VARCHAR(255) NOT NULL,
    usuario_tipo ENUM("NORMAL", "ADMINISTRADOR") DEFAULT "NORMAL",
    imagen_id BIGINT(20),
    CONSTRAINT fk_foto_usuario FOREIGN KEY(imagen_id) REFERENCES imagen(imagen_id)
);

CREATE TABLE socio(
	socio_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    socio_nombre VARCHAR(50) NOT NULL,
    socio_apellido VARCHAR(50) NOT NULL,
    socio_sexo ENUM("MASCULINO", "FEMENINO", "OTRO") NOT NULL,
    socio_fecha_nac DATE NOT NULL,
    socio_telefono VARCHAR(20) NOT NULL,
    socio_correo VARCHAR(255) NOT NULL,
    usuario_id BIGINT(20),
    documento_id BIGINT(20),
    procedencia_id BIGINT(20),
    CONSTRAINT fk_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(usuario_id),
    CONSTRAINT fk_documento FOREIGN KEY(documento_id) REFERENCES documento(documento_id),
    CONSTRAINT fk_procedencia FOREIGN KEY(procedencia_id) REFERENCES procedencia(procedencia_id)
);

CREATE TABLE actividad(
	actividad_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    actividad_nombre VARCHAR(50) NOT NULL
);

CREATE TABLE actividad_tipo(
	actividad_tipo_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    actividad_tipo_nombre VARCHAR(50) NOT NULL,
    actividad_tipo_descripcion VARCHAR(255) NOT NULL,
    actividad_id BIGINT(20),
    CONSTRAINT actividad_actividad_tipo_fk FOREIGN KEY(actividad_id) REFERENCES actividad(actividad_id)
);

CREATE TABLE reserva(
	reserva_id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    reserva_fecha DATE NOT NULL,
    actividad_id BIGINT(20),
    actividad_tipo_id BIGINT(20),
    usuario_id BIGINT(20),
    CONSTRAINT reserva_actividad_fk FOREIGN KEY(actividad_id) REFERENCES actividad(actividad_id),
    CONSTRAINT reserva_actividad_tipo_fk FOREIGN KEY(actividad_tipo_id) REFERENCES actividad_tipo(actividad_tipo_id),
    CONSTRAINT reserva_usuario_fk FOREIGN KEY(usuario_id) REFERENCES usuario(usuario_id)
);*/