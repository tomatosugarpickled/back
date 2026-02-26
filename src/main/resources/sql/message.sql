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



select m.member_name, msg.message_room_id, msg.message_content, msg.notification_datetime
from tbl_member m
         join
     (
         select
             msg2.message_room_id, msg1.message_content, msg1.notification_datetime,
             case
                 when msg1.receiver_id = 2 then msg1.sender_id
                 else msg1.receiver_id
                 end as member_id
         from tbl_message msg1
                  join
              (
                  select message_room_id, max(id) id
                  from tbl_message
                  where receiver_id = 2  or sender_id = 1
                  group by message_room_id
              ) msg2
              on msg1.id = msg2.id
     ) msg
     on m.id = msg.member_id;

