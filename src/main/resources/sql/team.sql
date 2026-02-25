drop table tbl_team;
create table tbl_team
(
    id bigint unsigned auto_increment primary key,
    team_title varchar(255) unique not null,
    team_url varchar(255) unique not null,
    team_contact_email varchar(255) unique not null,
    team_status enum ('active', 'inactive') default 'inactive',
    team_intro text not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_id_team foreign key (member_id)
        references tbl_member (id)
);

select * from tbl_team;