create table tbl_post
(
    post_id int auto_increment primary key,
    member_id int not null,
    title varchar(255) not null,
    content text not null,
    photo_url varchar(255),
    view_count int default 0 not null,
    created_at datetime default now() not null,
    updated_at datetime default now() not null,
    delete_status varchar(255) default 'n' not null
);
