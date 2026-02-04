create table tbl_follows
(
    follow_id int auto_increment primary key,
    follower_id int not null,
    following_id int not null,
    created_at datetime default now() not null
);