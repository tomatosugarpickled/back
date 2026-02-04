create table tbl_notifications
(
    id int auto_increment primary key,
    receiver_id int not null,
    message_sender_id int not null,
    notification_type varchar(255) not null,
    target_follower_id bigint not null,
    message varchar(255) not null,
    created_at datetime default now() not null
);