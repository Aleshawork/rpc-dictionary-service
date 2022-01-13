insert into object_type(id,code)
values(1,'DulMain'),(2,'Reestra');

insert into users(id,age,name,type_id)
values (1,19,'Alexey',1),(2,22,'Egor',2);

insert into message (id,date,text,user_id)
values(1,to_date('2021/04/13','YYYY/MM/DD'),'Hello Alex!',1),(2,to_date('2021/12/10','YYYY/MM/DD'),'ORM',2);

insert into message (id,date,text,user_id)
values(3,to_date('2021/04/13','YYYY/MM/DD'),'Interface is ambiguous things ',1),(4,to_date('2021/12/10','YYYY/MM/DD'),'Python cool',2);