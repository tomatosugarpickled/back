drop table tbl_members;
create table tbl_members
(
    id bigint unsigned auto_increment primary key,
    member_email varchar(255) unique not null,
    member_password varchar(255) not null,
    member_name varchar(255) not null,
    member_phone_number varchar(255) not null,
    member_verified boolean not null default false,
    created_datetime datetime default current_timestamp(),
    edited_datetime datetime default current_timestamp()
);