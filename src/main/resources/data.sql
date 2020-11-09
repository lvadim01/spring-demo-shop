INSERT INTO USERS (USERNAME,PASSWORD,WALLET,ENABLED)
	VALUES ('winify1','{bcrypt}$2y$12$vj4Mzq6QYjIWhPyZt8ON8e3KrJ.bIillQ5swgMXqw/6uQD19jPlP6',10.00,true),
	       ('winify2','{bcrypt}$2y$12$vj4Mzq6QYjIWhPyZt8ON8e3KrJ.bIillQ5swgMXqw/6uQD19jPlP6',5.00,true),
	       ('winify3','{bcrypt}$2y$12$vj4Mzq6QYjIWhPyZt8ON8e3KrJ.bIillQ5swgMXqw/6uQD19jPlP6',0.00,true);

INSERT INTO AUTHORITIES (USERNAME,AUTHORITY)
	VALUES ('winify1','ROLE_ADMIN'),
           ('winify2','ROLE_ADMIN'),
           ('winify3','ROLE_ADMIN');
	       
INSERT INTO PRODUCTS (NAME,CREATION_TIME,PRICE,STOCK,OWNER_ID)
	VALUES ('Apple','2020-10-16 20:02:21.000',5.51,30,1),
		   ('Mango','2019-10-16 20:02:21.000',10.33,7,1),
		   ('Banana','2018-10-16 20:02:21.000',6,0,1),
		   ('Nokia','2019-10-16 20:02:21.000',40.99,5,2),
		   ('Samsung','2020-10-17 20:02:21.000',50.99,0,2),
		   ('LG','2020-11-18 20:02:21.000',100,4,2),
		   ('Opel','2008-10-17 20:02:21.000',400.99,6,3),
		   ('VW','2004-10-17 20:02:21.000',60,0,3),
		   ('Mazda','2002-10-17 20:02:21.000',80.79,10,3);
	
