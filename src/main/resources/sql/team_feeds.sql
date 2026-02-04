drop table tbl_team_feeds;
create table tbl_team_feeds
(
    id bigint unsigned auto_increment primary key,
    team_feed_profile varchar(255) unique not null,
    team_technology_stack varchar(255) unique not null,
    team_Detailed_introduction varchar(65535) not null
#     team_size
#     team_current_level
#     team_recruit_position
);