drop table tbl_message_room;
create table tbl_message_room
(
    id bigint unsigned auto_increment primary key,
    created_member_id bigint unsigned not null,
    invited_member_id bigint unsigned not null,
    constraint fk_message_room_created_member foreign key (created_member_id)
        references tbl_member (id),
    constraint fk_message_room_invited_member foreign key (invited_member_id)
        references tbl_member (id)
);