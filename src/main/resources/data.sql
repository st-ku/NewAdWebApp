insert into ROLE (id,name) values (1,'ROLE_ADMIN');
insert into ROLE (id,name) values (2,'ROLE_MANAGER');
insert into ROLE (id,name) values (3,'ROLE_USER');
insert into user_entity (id,username,password,role_id) values (1,'ADMIN','$2y$12$JGoV/u8wBcmfecw/CJ3ZI.BW3E2JZF3g6.gkfdqzSXIZGIDnU59GC',1);
insert into AD_CATEGORY (Category_Id, category_name) values (1,'Auto');
insert into AD_CATEGORY (Category_Id, category_name) values (2,'Tech');
insert into AD_CATEGORY (Category_Id, category_name) values (3,'Realt');
insert into AD_CATEGORY (Category_Id, category_name) values (4,'Other');