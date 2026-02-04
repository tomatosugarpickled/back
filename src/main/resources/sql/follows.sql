create table tbl_follows
(
    follow_id int auto_increment primary key,
    follower_id int not null unique,
    following_id int not null unique,
    created_at datetime default now() not null
);