create table tbL_activity_file(
    id bigint unsigned primary key ,
    member_id bigint unsigned not null,
    member_activity_id bigint unsigned not null,
    constraint fk_member_activity_file_member foreign key (member_id)
    references tbL_member(id),
    constraint fk_member_activity_file_file foreign key (id)
    references tbl_file(id),
    constraint fk_member_activity_file_activity foreign key (member_activity_id)
    references tbl_member_activity(id)
);

drop table tbL_activity_file;
select * from tbL_activity_file;

create view view_activity_file as
(
select f.id, af.member_id,af.member_activity_id, file_path, file_name, file_original_name, file_size, file_content_type, f.created_datetime, f.updated_datetime
from tbl_file f join tbl_activity_file af
on f.id = af.id
join tbl_member_activity ma
on af.member_activity_id = ma.id);

select * from view_activity_file;
drop VIEW view_activity_file;
