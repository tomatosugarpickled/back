drop table tbl_member;
DELETE FROM tbl_member where id=6;
create table tbl_member
(
    id bigint unsigned auto_increment primary key,
    member_email varchar(255) unique not null,
    member_password varchar(255),
    member_name varchar(255) not null,
    member_phone_number varchar(255) unique not null,
    member_status enum ('active','inactive') default 'active',
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp()
);

select * from tbl_member;

select *
from tbl_member join tbl_member_career
on tbl_member.id = tbl_member_career.member_id;