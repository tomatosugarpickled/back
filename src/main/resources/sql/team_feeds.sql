drop table tbl_team_feeds;
create table tbl_team_feeds
(
    id bigint unsigned auto_increment primary key,
    team_feed_profile varchar(255) unique not null,
    team_technology_stack varchar(255) unique not null,
    team_Detailed_introduction text not null,
    team_size varchar(255),
    team_current_level varchar(255),
    team_recruit_position varchar(255)
);