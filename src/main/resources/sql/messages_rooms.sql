drop table tbl_message_rooms;
create table tbl_message_rooms
(
    id bigint unsigned auto_increment primary key,
    created_member_id bigint unsigned not null,
    invited_member_id bigint unsigned not null
);