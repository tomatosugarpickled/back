drop table tbl_follow;
CREATE TABLE tbl_follow (
id bigint unsigned auto_increment primary key,
follower_id bigint unsigned not null,
following_id bigint unsigned not null,
created_datetime datetime default current_timestamp(),
updated_datetime datetime default current_timestamp(),
foreign key (follower_id) references tbl_member(id),
foreign key (following_id) references tbl_member(id),
unique key unique_follow (follower_id, following_id)
);

select
    m.member_name,
    f.id, f.follower_id, f.following_id, f.created_datetime, f.updated_datetime
from tbl_follow f join tbl_member m
                       on f.follower_id = m.id
where f.following_id = 5
 ;

insert into tbl_follow(follower_id, following_id)
values (10, 5);


select *
from tbl_follow
where following_id = 5;