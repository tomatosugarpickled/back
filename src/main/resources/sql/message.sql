drop table tbl_message;
create table tbl_message
(
    id bigint unsigned auto_increment primary key,
    sender_id bigint unsigned not null,
    receiver_id bigint unsigned not null,
    message_status enum ('read','unread') default 'unread',
    notification_datetime datetime default current_timestamp(),
    message_content text not null,
    message_room_id bigint unsigned not null,
    constraint fk_message_message_room foreign key (message_room_id)
        references tbl_message_room (id),
    constraint fk_created_receiver_id foreign key (sender_id)
        references tbl_member(id),
    constraint fk_invited_receiver_id foreign key (receiver_id)
        references tbl_member(id)
);

select *
from tbl_message;