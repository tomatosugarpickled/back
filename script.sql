create table tbl_file
(
    id bigint unsigned auto_increment
        primary key,
    file_path varchar(255) not null,
    file_name varchar(255) not null,
    file_original_name varchar(255) not null,
    file_size varchar(255) not null,
    file_content_type enum ('image', 'other') not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null
);

create table tbl_member
(
    id bigint unsigned auto_increment
        primary key,
    member_email varchar(255) not null,
    member_password varchar(255) null,
    member_name varchar(255) not null,
    member_phone_number varchar(255) not null,
    member_status enum ('active', 'inactive') default 'active' null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null,
    constraint member_email
        unique (member_email),
    constraint member_phone_number
        unique (member_phone_number)
);

create table tbl_education
(
    id bigint unsigned auto_increment
        primary key,
    education_title varchar(255) not null,
    education_type varchar(255) not null,
    education_major varchar(255) not null,
    education_graduation varchar(255) not null,
    intro_detailed text not null,
    start_date varchar(255) not null,
    end_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null,
    constraint fk_member_education_member
        foreign key (member_id) references tbl_member (id)
);

create table tbl_follow
(
    id bigint unsigned auto_increment
        primary key,
    follower_id bigint unsigned not null,
    following_id bigint unsigned not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null,
    constraint unique_follow
        unique (follower_id, following_id),
    constraint tbl_follow_ibfk_1
        foreign key (follower_id) references tbl_member (id),
    constraint tbl_follow_ibfk_2
        foreign key (following_id) references tbl_member (id)
);

create index following_id
    on tbl_follow (following_id);

create table tbl_like_notification
(
    id bigint unsigned auto_increment
        primary key,
    follow_id bigint unsigned not null,
    constraint fk_follow_like_notification
        foreign key (follow_id) references tbl_follow (id)
);

create table tbl_member_activity
(
    id bigint unsigned auto_increment
        primary key,
    award_title varchar(255) not null,
    activity_type varchar(255) not null,
    start_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null,
    constraint fk_member_activity_member
        foreign key (member_id) references tbl_member (id)
);

create table tbl_activity_file
(
    id bigint unsigned not null
        primary key,
    member_id bigint unsigned not null,
    member_activity_id bigint unsigned not null,
    constraint fk_member_activity_file_activity
        foreign key (member_activity_id) references tbl_member_activity (id),
    constraint fk_member_activity_file_file
        foreign key (id) references tbl_file (id),
    constraint fk_member_activity_file_member
        foreign key (member_id) references tbl_member (id)
);

create table tbl_member_career
(
    id bigint unsigned auto_increment
        primary key,
    affiliation_title varchar(255) not null,
    member_employment_type varchar(255) not null,
    member_role varchar(255) not null,
    member_skill varchar(255) not null,
    intro_detailed text not null,
    start_date varchar(255) not null,
    end_date varchar(255) not null,
    member_id bigint unsigned not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null,
    constraint fk_member_career_member
        foreign key (member_id) references tbl_member (id)
);

create table tbl_member_category_career_member
(
    id bigint unsigned auto_increment
        primary key,
    category_career_name varchar(255) not null
);

create table tbl_member_category_career
(
    id bigint unsigned auto_increment
        primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_career_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_member_category_career
        foreign key (category_id) references tbl_member_category_career_member (id)
);

create table tbl_member_category_interest_member
(
    id bigint unsigned auto_increment
        primary key,
    category_interest_name varchar(255) not null
);

create table tbl_member_category_interest
(
    id bigint unsigned auto_increment
        primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_interest_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_member_category_interest
        foreign key (category_id) references tbl_member_category_interest_member (id)
);

create table tbl_member_category_joining_member
(
    id bigint unsigned auto_increment
        primary key,
    category_joining_name varchar(255) not null
);

create table tbl_member_category_joining
(
    id bigint unsigned auto_increment
        primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_joining_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_member_category_joining
        foreign key (category_id) references tbl_member_category_joining_member (id)
);

create table tbl_member_category_position_member
(
    id bigint unsigned auto_increment
        primary key,
    category_position_name varchar(255) not null
);

create table tbl_member_category_position
(
    id bigint unsigned auto_increment
        primary key,
    member_id bigint unsigned not null,
    category_id bigint unsigned not null,
    constraint fk_category_position_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_member_category_position
        foreign key (category_id) references tbl_member_category_position_member (id)
);

create table tbl_member_profile_file
(
    id bigint unsigned not null
        primary key,
    member_id bigint unsigned not null,
    constraint fk_member_profile_file_file
        foreign key (id) references tbl_file (id),
    constraint fk_member_profile_file_member
        foreign key (member_id) references tbl_member (id)
);

create table tbl_message_room
(
    id bigint unsigned auto_increment
        primary key,
    created_member_id bigint unsigned not null,
    invited_member_id bigint unsigned not null,
    constraint fk_message_room_created_member
        foreign key (created_member_id) references tbl_member (id),
    constraint fk_message_room_invited_member
        foreign key (invited_member_id) references tbl_member (id)
);

create table tbl_message
(
    id bigint unsigned auto_increment
        primary key,
    sender_id bigint unsigned not null,
    receiver_id bigint unsigned not null,
    message_status enum ('read', 'unread') default 'unread' null,
    notification_datetime datetime default CURRENT_TIMESTAMP null,
    message_content text not null,
    message_room_id bigint unsigned not null,
    constraint fk_created_receiver_id
        foreign key (sender_id) references tbl_member (id),
    constraint fk_invited_receiver_id
        foreign key (receiver_id) references tbl_member (id),
    constraint fk_message_message_room
        foreign key (message_room_id) references tbl_message_room (id)
);

create table tbl_message_notification
(
    id bigint unsigned auto_increment
        primary key,
    message_room_id bigint unsigned not null,
    constraint fk_room_notification
        foreign key (message_room_id) references tbl_message_room (id)
);

create table tbl_oauth
(
    id bigint unsigned not null
        primary key,
    provider enum ('candm', 'kakao') not null,
    constraint fk_oauth_member
        foreign key (id) references tbl_member (id)
);

create table tbl_post
(
    id bigint unsigned auto_increment
        primary key,
    post_title varchar(255) not null,
    post_content text not null,
    post_view_count int default 0 not null,
    member_id bigint unsigned not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null,
    post_status enum ('active', 'inactive') default 'active' null,
    constraint fk_member_post
        foreign key (member_id) references tbl_member (id)
);

create table tbl_post_member
(
    id bigint unsigned auto_increment
        primary key,
    member_id bigint unsigned not null,
    post_id bigint unsigned not null,
    constraint fk_post_member_member
        foreign key (member_id) references tbl_member (id),
    constraint fk_post_member_post
        foreign key (post_id) references tbl_post (id)
);

create table tbl_team
(
    id bigint unsigned auto_increment
        primary key,
    team_title varchar(255) not null,
    team_url varchar(255) not null,
    team_contact_email varchar(255) not null,
    team_status enum ('active', 'inactive') default 'inactive' null,
    team_intro text not null,
    member_id bigint unsigned not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    updated_datetime datetime default CURRENT_TIMESTAMP null,
    constraint team_contact_email
        unique (team_contact_email),
    constraint team_title
        unique (team_title),
    constraint team_url
        unique (team_url),
    constraint fk_member_id_team
        foreign key (member_id) references tbl_member (id)
);

create table tbl_funding
(
    id bigint unsigned auto_increment
        primary key,
    funding_target_amount bigint default 0 null,
    funding_current_amount bigint default 0 null,
    funding_title varchar(255) not null,
    start_date date not null,
    end_date date not null,
    funding_url varchar(255) not null,
    funding_description text null,
    funding_contact_email varchar(255) not null,
    created_datetime datetime default CURRENT_TIMESTAMP null,
    funding_status enum ('active', 'inactive') default 'inactive' null,
    team_id bigint unsigned not null,
    constraint funding_url
        unique (funding_url),
    constraint fk_funding_team
        foreign key (team_id) references tbl_team (id)
);

create table tbl_donation
(
    id bigint unsigned auto_increment
        primary key,
    donation_amount bigint unsigned default '0' null,
    funding_id bigint unsigned not null,
    member_id bigint unsigned not null,
    constraint fk_funding_donation
        foreign key (funding_id) references tbl_funding (id),
    constraint fk_member_donation
        foreign key (member_id) references tbl_member (id)
);

create table tbl_funding_file
(
    id bigint unsigned not null
        primary key,
    funding_id bigint unsigned not null,
    constraint fk_funding_file_file
        foreign key (id) references tbl_file (id),
    constraint fk_funding_file_funding
        foreign key (funding_id) references tbl_funding (id)
);

create table tbl_pay
(
    id bigint auto_increment
        primary key,
    pay_final_amount bigint not null,
    pay_status enum ('active', 'inactive') not null,
    pay_method enum ('creditcard', 'banktransfer', 'paypal') not null,
    funding_id bigint unsigned not null,
    member_id bigint unsigned not null,
    constraint fk_pay_funding
        foreign key (funding_id) references tbl_funding (id),
    constraint fk_pay_member
        foreign key (member_id) references tbl_member (id)
);

create table tbl_post_team
(
    id bigint unsigned auto_increment
        primary key,
    team_id bigint unsigned not null,
    post_id bigint unsigned not null,
    constraint fk_post_team
        foreign key (id) references tbl_post (id),
    constraint fk_post_team_team
        foreign key (team_id) references tbl_team (id)
);

create table tbl_team_category_business_field_team
(
    id bigint unsigned auto_increment
        primary key,
    category_business_field_name varchar(255) not null
);

create table tbl_team_category_business_field
(
    id bigint unsigned auto_increment
        primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_business_field
        foreign key (team_id) references tbl_team (id),
    constraint fk_category_business_field_team
        foreign key (catergory_id) references tbl_team_category_business_field_team (id)
);

create table tbl_team_category_current_level_team
(
    id bigint unsigned auto_increment
        primary key,
    category_current_level_name varchar(255) not null
);

create table tbl_team_category_current_level
(
    id bigint unsigned auto_increment
        primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_current_level
        foreign key (team_id) references tbl_team (id),
    constraint fk_category_current_level_team
        foreign key (catergory_id) references tbl_team_category_current_level_team (id)
);

create table tbl_team_category_position_team
(
    id bigint unsigned auto_increment
        primary key,
    category_team_position_name varchar(255) not null
);

create table tbl_team_category_position
(
    id bigint unsigned auto_increment
        primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_position
        foreign key (team_id) references tbl_team (id),
    constraint fk_category_position_team
        foreign key (catergory_id) references tbl_team_category_position_team (id)
);

create table tbl_team_category_team_size_team
(
    id bigint unsigned auto_increment
        primary key,
    category_team_size_name varchar(255) not null
);

create table tbl_team_category_size
(
    id bigint unsigned auto_increment
        primary key,
    team_id bigint unsigned not null,
    catergory_id bigint unsigned not null,
    constraint fk_category_size
        foreign key (team_id) references tbl_team (id),
    constraint fk_category_team_size_team
        foreign key (catergory_id) references tbl_team_category_team_size_team (id)
);

create table tbl_team_file
(
    id bigint unsigned not null
        primary key,
    team_id bigint unsigned not null,
    constraint fk_team_file_file
        foreign key (id) references tbl_file (id),
    constraint fk_team_file_team
        foreign key (team_id) references tbl_team (id)
);

create table tbl_team_member
(
    id bigint unsigned auto_increment
        primary key,
    team_id bigint unsigned not null,
    constraint fk_team_member
        foreign key (team_id) references tbl_team (id)
);


