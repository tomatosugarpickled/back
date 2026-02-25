drop table tbl_member_activity;
create table tbl_member_activity (
    id bigint unsigned auto_increment primary key,
    award_title varchar(255) not null,
    activity_type varchar(255) not null,
    start_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_activity_member foreign key(member_id)
    references tbl_member(id)
);

select * from tbl_member_activity;




