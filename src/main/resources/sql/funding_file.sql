create table tbl_funding_file(
  id bigint unsigned primary key,
  funding_id bigint unsigned not null,
  constraint fk_funding_file_funding foreign key (funding_id)
      references tbl_funding(id),
  constraint fk_funding_file_file foreign key (id)
      references tbl_file(id)
);

select * from tbl_funding_file;

create view view_funding_file as
(
select f.id,
       file_path,
       file_name,
       file_original_name,
       file_size,
       file_content_type,
       created_datetime,
       updated_datetime,
       funding_id
from tbl_file f
         join tbl_funding_file ff
              on f.id = ff.id
    );

select * from tbl_funding_file;
select * from view_funding_file;
delete from tbl_funding_file;




















