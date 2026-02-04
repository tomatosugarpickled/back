use CandM;
-- 펀딩 테이블
create table tbl_funding (
funding_id int auto_increment primary key,       -- 펀딩 고유번호
funding_target_amount int not null,            -- 펀딩 목표금액
funding_current_amount int default 0,          -- 펀딩 현재금액
funding_name varchar(255) not null,                      -- 펀딩 이름
funding_start_date date not null,                        -- 펀딩 시작일
funding_end_date date not null,                          -- 펀딩 마감일
funding_description text,                                -- 펀딩 내용
funding_user_email varchar(255) not null,                -- 사용자 이메일
funding_created_at datetime default current_timestamp(),   -- 펀딩 등록일
funding_status varchar(255) not null -- 펀딩 상태
);

funding_category varchar(100) not null,                  -- 펀딩 카테고리
funding_image_url varchar(255),                          -- 펀딩 이미지
funding_video_url varchar(255),                          -- 펀딩 영상