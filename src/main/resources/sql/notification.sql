create table tbl_notifications
(
    notification_id int auto_increment primary key,
    receiver_id int not null,
    sender_id int not null,
    noti_type varchar(255) not null,
    target_post_id int,
    message varchar(255) not null,
    created_at datetime default now() not null
);