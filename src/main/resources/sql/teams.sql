drop table tbl_teams;
create table tbl_teams
(
    id bigint unsigned auto_increment primary key,
    team_name varchar(255) unique not null,
    team_url varchar(255) unique not null,
    team_leader_email varchar(255) unique not null,
    team_approved_or_not boolean not null default false,
    created_datetime datetime default current_timestamp(),
    team_deleted enum ('disable','able') default 'disable'
);