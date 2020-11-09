CREATE TABLE USERS (
	ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	USERNAME VARCHAR(45) NOT NULL,
	PASSWORD VARCHAR(70) NOT NULL,
	WALLET DECIMAL(9,2) NOT NULL,
	ENABLED BOOLEAN NOT NULL,
	CONSTRAINT USERS_PK PRIMARY KEY (ID)
);

CREATE TABLE PRODUCTS (
	ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	NAME VARCHAR(45) NOT NULL,
	CREATION_TIME TIMESTAMP NOT NULL,
	PRICE DECIMAL(9,2) NOT NULL,
	STOCK BIGINT NOT NULL,
	OWNER_ID BIGINT NOT NULL,
	CONSTRAINT PRODUCTS_PK PRIMARY KEY (ID),
	CONSTRAINT PRODUCTS_FK FOREIGN KEY (OWNER_ID) REFERENCES USERS(ID)
);

CREATE TABLE AUTHORITIES (
	ID BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	USERNAME VARCHAR(45) NOT NULL,
	AUTHORITY VARCHAR(45) NOT NULL, 
	CONSTRAINT AUTH_PK PRIMARY KEY (ID)
);