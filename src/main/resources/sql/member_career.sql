drop table tbl_member_career;
create table tbl_member_career(
    id bigint unsigned auto_increment primary key,
    affiliation_title varchar(255) not null,
    member_employment_type varchar(255) not null,
    member_role varchar(255) not null,
    member_skill varchar(255) not null,
    intro_detailed text not null,
    start_date varchar(255) not null,
    end_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_career_member foreign key(member_id)
    references tbl_member(id)
);

select * from tbl_member_career;