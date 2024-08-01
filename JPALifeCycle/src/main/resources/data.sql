insert into table_rest(id,category,count,hall,number) values(1,'PAIR',2,1,'1A');
insert into table_rest(id,category,count,hall,number) values(2,'PAIR',2,1,'2A');

insert into order_rest(date_begin, date_end, table_id) values('2024-07-31 10:30:00','2024-07-31 11:00:00',1);
insert into order_rest(date_begin, date_end, table_id) values('2024-07-31 13:30:00','2024-07-31 14:00:00',1);

insert into order_rest(date_begin, date_end, table_id) values('2024-07-31 10:30:00','2024-07-31 11:00:00',2);
insert into order_rest(date_begin, date_end, table_id) values('2024-07-31 13:30:00','2024-07-31 14:00:00',2);