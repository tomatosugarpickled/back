drop table tbl_education;
create table tbl_education
(
    id bigint unsigned auto_increment primary key,
    education_title varchar(255) not null,
    education_type varchar(255) not null,
    education_major varchar(255) not null,
    education_graduation varchar(255) not null,
    intro_detailed text not null,
    start_date varchar(255) not null,
    end_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_education_member foreign key(member_id)
    references tbl_member(id)
);

select * from tbl_education;