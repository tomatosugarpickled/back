create table tbl_post
(
    id int auto_increment primary key,
    post_writer_id int not null,
    post_title varchar(255) not null,
    post_content text not null,
    post_view_count int default 0 not null,
    post_created_at datetime default now() not null,
    post_updated_at datetime default now() not null,
    post_delete_status varchar(255) default 'n' not null
);

photo_url varchar(255),