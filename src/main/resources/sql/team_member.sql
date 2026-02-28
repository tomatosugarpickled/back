create table tbl_team_member(
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    constraint fk_team_member foreign key (team_id)
                            references tbl_team(id)
);

