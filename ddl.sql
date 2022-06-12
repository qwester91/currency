CREATE DATABASE currency
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Russian_Russia.1251'
    LC_CTYPE = 'Russian_Russia.1251'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA IF NOT EXISTS currency
    AUTHORIZATION postgres;

CREATE TABLE IF NOT EXISTS currency.currency
(
    id bigserial NOT NULL ,
    name character varying(50) COLLATE pg_catalog."default",
    description character varying(100) COLLATE pg_catalog."default",
    code character varying(5) COLLATE pg_catalog."default" NOT NULL,
    create_time timestamp with time zone,
    update_time timestamp with time zone,
    CONSTRAINT id PRIMARY KEY (id, code)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS currency.currency
    OWNER to postgres;