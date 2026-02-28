USE CandM;
SET FOREIGN_KEY_CHECKS = 0;

-- ===== VIEW DROP =====
DROP VIEW IF EXISTS view_member_profile_file;
DROP VIEW IF EXISTS view_team_file;
DROP VIEW IF EXISTS view_funding_file;
DROP VIEW IF EXISTS view_activity_file;

-- ===== Level 4 =====
DROP TABLE IF EXISTS tbl_activity_file;

-- ===== Level 3 =====
DROP TABLE IF EXISTS tbl_pay;
DROP TABLE IF EXISTS tbl_donation;
DROP TABLE IF EXISTS tbl_funding_file;

-- ===== Level 2 =====
DROP TABLE IF EXISTS tbl_message;
DROP TABLE IF EXISTS tbl_post_member;
DROP TABLE IF EXISTS tbl_post_team;
DROP TABLE IF EXISTS tbl_like_notification;
DROP TABLE IF EXISTS tbl_message_notification;
DROP TABLE IF EXISTS tbl_funding;
DROP TABLE IF EXISTS tbl_team_file;
DROP TABLE IF EXISTS tbl_team_member;
DROP TABLE IF EXISTS tbl_team_category_business_field;
DROP TABLE IF EXISTS tbl_team_category_current_level;
DROP TABLE IF EXISTS tbl_team_category_position;
DROP TABLE IF EXISTS tbl_team_category_size;

-- ===== Level 1 =====
DROP TABLE IF EXISTS tbl_oauth;
DROP TABLE IF EXISTS tbl_team;
DROP TABLE IF EXISTS tbl_post;
DROP TABLE IF EXISTS tbl_follow;
DROP TABLE IF EXISTS tbl_member_career;
DROP TABLE IF EXISTS tbl_education;
DROP TABLE IF EXISTS tbl_member_activity;
DROP TABLE IF EXISTS tbl_member_profile_file;
DROP TABLE IF EXISTS tbl_message_room;
DROP TABLE IF EXISTS tbl_member_category_career;
DROP TABLE IF EXISTS tbl_member_category_interest;
DROP TABLE IF EXISTS tbl_member_category_joining;
DROP TABLE IF EXISTS tbl_member_category_position;

-- ===== Level 0 =====
DROP TABLE IF EXISTS tbl_member;
DROP TABLE IF EXISTS tbl_file;
DROP TABLE IF EXISTS tbl_member_category_career_member;
DROP TABLE IF EXISTS tbl_member_category_interest_member;
DROP TABLE IF EXISTS tbl_member_category_joining_member;
DROP TABLE IF EXISTS tbl_member_category_position_member;
DROP TABLE IF EXISTS tbl_team_category_business_field_team;
DROP TABLE IF EXISTS tbl_team_category_current_level_team;
DROP TABLE IF EXISTS tbl_team_category_position_team;
DROP TABLE IF EXISTS tbl_team_category_team_size_team;

SET FOREIGN_KEY_CHECKS = 1;

-- ============================================================
-- Level 0: 독립 테이블 (10개)
-- ============================================================

CREATE TABLE tbl_member (
    id bigint unsigned auto_increment primary key,
    member_email varchar(255) unique not null,
    member_password varchar(255),
    member_name varchar(255) not null,
    member_phone_number varchar(255) unique not null,
    member_status enum('active','inactive') default 'active',
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp()
);

CREATE TABLE tbl_file (
    id bigint unsigned auto_increment primary key,
    file_path varchar(255) not null,
    file_name varchar(255) not null,
    file_original_name varchar(255) not null,
    file_size varchar(255) not null,
    file_content_type enum('image', 'other') not null,
    created_datetime datetime default current_timestamp,
    updated_datetime datetime default current_timestamp
);

CREATE TABLE tbl_member_category_career_member (
    id bigint unsigned auto_increment primary key,
    category_career_name varchar(255) not null
);

CREATE TABLE tbl_member_category_interest_member (
    id bigint unsigned auto_increment primary key,
    category_interest_name varchar(255) not null
);

CREATE TABLE tbl_member_category_joining_member (
    id bigint unsigned auto_increment primary key,
    category_joining_name varchar(255) not null
);

CREATE TABLE tbl_member_category_position_member (
    id bigint unsigned auto_increment primary key,
    category_position_name varchar(255) not null
);

CREATE TABLE tbl_team_category_business_field_team (
    id bigint unsigned auto_increment primary key,
    category_business_field_name varchar(255) not null
);

CREATE TABLE tbl_team_category_current_level_team (
    id bigint unsigned auto_increment primary key,
    category_current_level_name varchar(255) not null
);

CREATE TABLE tbl_team_category_position_team (
    id bigint unsigned auto_increment primary key,
    category_team_position_name varchar(255) not null
);

CREATE TABLE tbl_team_category_team_size_team (
    id bigint unsigned auto_increment primary key,
    category_team_size_name varchar(255) not null
);

-- ============================================================
-- Level 1: tbl_member / tbl_file 참조 (13개)
-- ============================================================

CREATE TABLE tbl_oauth (
    id bigint unsigned primary key,
    provider enum('candm', 'kakao') not null,
    constraint fk_oauth_member foreign key (id) references tbl_member(id)
);

CREATE TABLE tbl_team (
    id bigint unsigned auto_increment primary key,
    team_title varchar(255) unique not null,
    team_url varchar(255) unique not null,
    team_contact_email varchar(255) unique not null,
    team_status enum('active', 'inactive') default 'inactive',
    team_intro text not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_id_team foreign key (member_id) references tbl_member(id)
);

CREATE TABLE tbl_post (
    id bigint unsigned auto_increment primary key,
    post_title varchar(255) not null,
    post_content text not null,
    post_view_count int default 0 not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    post_status enum('active', 'inactive') default 'active',
    constraint fk_member_post foreign key (member_id) references tbl_member(id)
);

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

CREATE TABLE tbl_member_career (
    id bigint unsigned auto_increment primary key,
    affiliation_title varchar(255) not null,
    member_employment_type varchar(255) not null,
    member_role varchar(255) not null,
    member_skill varchar(255) not null,
    intro_detailed text not null,
    start_date varchar(255) not null,
    end_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_career_member foreign key (member_id) references tbl_member(id)
);

CREATE TABLE tbl_education (
    id bigint unsigned auto_increment primary key,
    education_title varchar(255) not null,
    education_type varchar(255) not null,
    education_major varchar(255) not null,
    education_graduation varchar(255) not null,
    intro_detailed text not null,
    start_date varchar(255) not null,
    end_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_education_member foreign key (member_id) references tbl_member(id)
);

CREATE TABLE tbl_member_activity (
    id bigint unsigned auto_increment primary key,
    award_title varchar(255) not null,
    activity_type varchar(255) not null,
    start_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_member_activity_member foreign key (member_id) references tbl_member(id)
);

CREATE TABLE tbl_member_profile_file (
    id bigint unsigned not null primary key,
    member_id bigint unsigned not null,
    constraint fk_member_profile_file_member foreign key (member_id) references tbl_member(id),
    constraint fk_member_profile_file_file foreign key (id) references tbl_file(id)
);

CREATE TABLE tbl_message_room (
    id bigint unsigned auto_increment primary key,
    created_member_id bigint unsigned not null,
    invited_member_id bigint unsigned not null,
    created_datetime datetime default current_timestamp(),
    updated_datetime datetime default current_timestamp(),
    constraint fk_message_room_created_member foreign key (created_member_id) references tbl_member(id),
    constraint fk_message_room_invited_member foreign key (invited_member_id) references tbl_member(id)
);

CREATE TABLE tbl_member_category_career (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_career_member foreign key (member_id) references tbl_member(id),
    constraint fk_member_category_career foreign key (category_id) references tbl_member_category_career_member(id)
);

CREATE TABLE tbl_member_category_interest (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_interest_member foreign key (member_id) references tbl_member(id),
    constraint fk_member_category_interest foreign key (category_id) references tbl_member_category_interest_member(id)
);

CREATE TABLE tbl_member_category_joining (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_joining_member foreign key (member_id) references tbl_member(id),
    constraint fk_member_category_joining foreign key (category_id) references tbl_member_category_joining_member(id)
);

CREATE TABLE tbl_member_category_position (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_position_member foreign key (member_id) references tbl_member(id),
    constraint fk_member_category_position foreign key (category_id) references tbl_member_category_position_member(id)
);

-- ============================================================
-- Level 2: tbl_team, tbl_post, tbl_follow, tbl_message_room 참조 (13개)
-- ============================================================

CREATE TABLE tbl_funding (
    id bigint unsigned auto_increment primary key,
    funding_target_amount bigint default 0,
    funding_current_amount bigint default 0,
    funding_title varchar(255) not null,
    start_date date not null,
    end_date date not null,
    funding_url varchar(255) unique not null,
    funding_description text,
    funding_contact_email varchar(255) not null,
    created_datetime datetime default current_timestamp(),
    funding_status enum('active', 'inactive') default 'inactive',
    team_id bigint unsigned not null,
    constraint fk_funding_team foreign key (team_id) references tbl_team(id)
);

CREATE TABLE tbl_team_file (
    id bigint unsigned primary key,
    team_id bigint unsigned not null,
    constraint fk_team_file_team foreign key (team_id) references tbl_team(id),
    constraint fk_team_file_file foreign key (id) references tbl_file(id)
);

CREATE TABLE tbl_team_member (
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    constraint fk_team_member foreign key (team_id) references tbl_team(id)
);

CREATE TABLE tbl_team_category_business_field (
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_business_field foreign key (team_id) references tbl_team(id),
    constraint fk_category_business_field_team foreign key (catergory_id) references tbl_team_category_business_field_team(id)
);

CREATE TABLE tbl_team_category_current_level (
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_current_level foreign key (team_id) references tbl_team(id),
    constraint fk_category_current_level_team foreign key (catergory_id) references tbl_team_category_current_level_team(id)
);

CREATE TABLE tbl_team_category_position (
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_position foreign key (team_id) references tbl_team(id),
    constraint fk_category_position_team foreign key (catergory_id) references tbl_team_category_position_team(id)
);

CREATE TABLE tbl_team_category_size (
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_size foreign key (team_id) references tbl_team(id),
    constraint fk_category_team_size_team foreign key (catergory_id) references tbl_team_category_team_size_team(id)
);

CREATE TABLE tbl_message (
    id bigint unsigned auto_increment primary key,
    sender_id bigint unsigned not null,
    receiver_id bigint unsigned not null,
    message_status enum('read','unread') default 'unread',
    notification_datetime datetime default current_timestamp(),
    message_content text not null,
    message_room_id bigint unsigned not null,
    constraint fk_message_message_room foreign key (message_room_id) references tbl_message_room(id),
    constraint fk_created_receiver_id foreign key (sender_id) references tbl_member(id),
    constraint fk_invited_receiver_id foreign key (receiver_id) references tbl_member(id)
);

CREATE TABLE tbl_post_member (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    post_id bigint unsigned not null,
    constraint fk_post_member_member foreign key (member_id) references tbl_member(id),
    constraint fk_post_member_post foreign key (post_id) references tbl_post(id)
);

CREATE TABLE tbl_post_team (
    id bigint unsigned auto_increment primary key,
    team_id bigint unsigned not null,
    post_id bigint unsigned not null,
    constraint fk_post_team_team foreign key (team_id) references tbl_team(id),
    constraint fk_post_team foreign key (id) references tbl_post(id)
);

CREATE TABLE tbl_like_notification (
    id bigint unsigned auto_increment primary key,
    follow_id bigint unsigned not null,
    constraint fk_follow_like_notification foreign key (follow_id) references tbl_follow(id)
);

CREATE TABLE tbl_message_notification (
    id bigint unsigned auto_increment primary key,
    message_room_id bigint unsigned not null,
    constraint fk_room_notification foreign key (message_room_id) references tbl_message_room(id)
);

-- ============================================================
-- Level 3: tbl_funding 참조 (3개)
-- ============================================================

CREATE TABLE tbl_pay (
    id bigint auto_increment primary key,
    pay_final_amount bigint not null,
    pay_status enum('active', 'inactive') not null,
    pay_method enum('creditcard', 'banktransfer', 'paypal') not null,
    funding_id bigint unsigned not null,
    member_id bigint unsigned not null,
    constraint fk_pay_member foreign key (member_id) references tbl_member(id),
    constraint fk_pay_funding foreign key (funding_id) references tbl_funding(id)
);

CREATE TABLE tbl_donation (
    id bigint unsigned auto_increment primary key,
    donation_amount bigint unsigned default 0,
    funding_id bigint unsigned not null,
    member_id bigint unsigned not null,
    constraint fk_funding_donation foreign key (funding_id) references tbl_funding(id),
    constraint fk_member_donation foreign key (member_id) references tbl_member(id)
);

CREATE TABLE tbl_funding_file (
    id bigint unsigned primary key,
    funding_id bigint unsigned not null,
    constraint fk_funding_file_funding foreign key (funding_id) references tbl_funding(id),
    constraint fk_funding_file_file foreign key (id) references tbl_file(id)
);

-- ============================================================
-- Level 4: tbl_member_activity 참조 (1개)
-- ============================================================

CREATE TABLE tbl_activity_file (
    id bigint unsigned primary key,
    member_id bigint unsigned not null,
    member_activity_id bigint unsigned not null,
    constraint fk_member_activity_file_member foreign key (member_id) references tbl_member(id),
    constraint fk_member_activity_file_file foreign key (id) references tbl_file(id),
    constraint fk_member_activity_file_activity foreign key (member_activity_id) references tbl_member_activity(id)
);

-- ============================================================
-- VIEW 생성 (4개)
-- ============================================================

CREATE VIEW view_member_profile_file AS (
    SELECT f.id, file_path, file_name, file_original_name, file_size, file_content_type,
           created_datetime, updated_datetime, member_id
    FROM tbl_file f JOIN tbl_member_profile_file mpf ON f.id = mpf.id
);

CREATE VIEW view_team_file AS (
    SELECT f.id, file_path, file_name, file_original_name, file_size, file_content_type,
           created_datetime, updated_datetime, team_id
    FROM tbl_file f JOIN tbl_team_file tf ON f.id = tf.id
);

CREATE VIEW view_funding_file AS (
    SELECT f.id, file_path, file_name, file_original_name, file_size, file_content_type,
           created_datetime, updated_datetime, funding_id
    FROM tbl_file f JOIN tbl_funding_file ff ON f.id = ff.id
);

CREATE VIEW view_activity_file AS (
    SELECT f.id, af.member_id, af.member_activity_id, file_path, file_name,
           file_original_name, file_size, file_content_type, f.created_datetime, f.updated_datetime
    FROM tbl_file f JOIN tbl_activity_file af ON f.id = af.id
    JOIN tbl_member_activity ma ON af.member_activity_id = ma.id
);
