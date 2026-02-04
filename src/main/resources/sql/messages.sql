drop table tbl_messages;
create table tbl_messages
(
    id bigint unsigned auto_increment primary key,
    message_room_id bigint unsigned not null,
    sender_id bigint unsigned not null,
    receiver_id bigint unsigned not null,
    read_or_not boolean not null default false,
    notification_datetime datetime default current_timestamp()
);