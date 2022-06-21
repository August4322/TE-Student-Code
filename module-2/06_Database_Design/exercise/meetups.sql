BEGIN TRANSACTION;

DROP TABLE IF EXISTS Group_Member;
DROP TABLE IF EXISTS Event_Member;
DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS Groups;
DROP TABLE IF EXISTS Member;

CREATE TABLE Member (
--columns
	member_id serial,
	last_name varchar(25) not null,
	first_name varchar(25) not null,
	email_address varchar(100) unique,
	phone_number varchar(25) unique,
	birthday varchar(50),
	reminder_emails boolean not null default(false),
--constraints
	CONSTRAINT pk_member primary key (member_id)
);

CREATE TABLE Groups (
--columns
	group_id serial,
	group_name varchar(100) not null,
	group_member_amount int not null,
--constraints
	CONSTRAINT pk_group primary key (group_id),
	CONSTRAINT chk_group_member_amount check (group_member_amount >= 0)
);

CREATE TABLE Group_Member (
--columns
	member_id int,
	group_id int,
--constraints
	CONSTRAINT pk_group_member primary key (member_id, group_id),
	CONSTRAINT fk_group_member_member foreign key (member_id) references member(member_id),
	CONSTRAINT fk_group_member_group foreign key (group_id) references groups(group_id)
);

CREATE TABLE Event (
--columns
	event_id serial,
	event_name varchar(100) not null,
	description varchar(500),
	start_date date not null,
	start_time time not null,
	duration int not null,
	group_id int,
	event_member_amount int not null,
--constraints
	CONSTRAINT pk_event primary key (event_id),
	CONSTRAINT chk_duration check (duration >= 30),
	CONSTRAINT fk_event_group foreign key (group_id) references groups(group_id)
);

CREATE TABLE Event_Member (
--columns
	member_id int,
	event_id int,
--constraints
	CONSTRAINT pk_event_member primary key (member_id, event_id),
	CONSTRAINT fk_event_member_member foreign key (member_id) references member(member_id),
	CONSTRAINT fk_event_member_event foreign key (event_id) references event(event_id)
);

--INSERT 8 MEMBERS
INSERT INTO member(last_name, first_name, email_address, phone_number, birthday, reminder_emails)
VALUES	('Kitsuragi', 'Kim', 'kitsuragi.kim57@gmail.com', '909-615-5806', '1979-04-20', true),
		('Du Bois', 'Harrier', 'dubois.harry41@gmail.com', '582-202-7621', '1978-06-14', false),
		('Gottlieb', 'Nix', 'gottlieb.nix41@gmail.com', '582-202-1286', '1956-09-12', false),
		('Pidieu', 'Jules', 'pidieu.jules41@gmail.com', '582-202-3172', '1980-10-30', true),
		('McLaine', 'Chester', 'mclaine.chester41@gmail.com', '582-202-2316', '1976-07-01', true),
		('Torson', 'Mack', 'torson.mack41@gmail.com', '582-202-4734', '1989-01-25', false),
		('Heidelstam', 'Trant', 'heidelstam.trant41@gmail.com', '582-202-5694', '1990-12-05', false),
		('DeMettrie', 'Alice', 'demettrie.alice57@gmail.com', '909-615-4322', '1987-05-10', true);

--INSERT 3 GROUPS
INSERT INTO groups(group_name, group_member_amount)
VALUES	('Revachol Citizens Militia', 8),
		('Whirling-in-Rags', 2),
		('Sea Fortress Church', 5);

--INSERT 4 EVENTS
INSERT INTO event(event_name, description, start_date, start_time, duration, event_member_amount)
VALUES	('Precinct 41 Reunion', 'It is time for a reunion to see what the members have been up to.', '2022-01-05', '17:00', 60, 6),
		('Revachol West Fashion Walk', 'Wear your finest to impress the locals', '2022-01-03', '10:00', 120, 1),
		('Discover The Pale at The Dolorian Church of Humanity', 'Discover the beyond', '2022-01-04', '15:00', 240, 2),
		('Book Signing with Insulindian Phasmid', 'A once in a lifetime event', '2022-01-05', '16:00', 30, 2);
		
--INSERT INTO GROUP_MEMBER
--Revachol Citizens Militia
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Kitsuragi'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Du Bois'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Gottlieb'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Pidieu'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'McLaine'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Torson'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Heidelstam'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'DeMettrie'), (SELECT group_id FROM groups WHERE group_name = 'Revachol Citizens Militia'));

--Whirling-in-Rags
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Kitsuragi'), (SELECT group_id FROM groups WHERE group_name = 'Whirling-in-Rags'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Du Bois'), (SELECT group_id FROM groups WHERE group_name = 'Whirling-in-Rags'));

--Sea Fortress Church
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Kitsuragi'), (SELECT group_id FROM groups WHERE group_name = 'Sea Fortress Church'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Du Bois'), (SELECT group_id FROM groups WHERE group_name = 'Sea Fortress Church'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'McLaine'), (SELECT group_id FROM groups WHERE group_name = 'Sea Fortress Church'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Torson'), (SELECT group_id FROM groups WHERE group_name = 'Sea Fortress Church'));
INSERT INTO group_member(member_id, group_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Heidelstam'), (SELECT group_id FROM groups WHERE group_name = 'Sea Fortress Church'));


--INSERT INTO EVENT_MEMBER
--Precinct 41 Reunion
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Du Bois'), (SELECT event_id FROM event WHERE event_name = 'Precinct 41 Reunion'));
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Gottlieb'), (SELECT event_id FROM event WHERE event_name = 'Precinct 41 Reunion'));
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Pidieu'), (SELECT event_id FROM event WHERE event_name = 'Precinct 41 Reunion'));
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'McLaine'), (SELECT event_id FROM event WHERE event_name = 'Precinct 41 Reunion'));
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Torson'), (SELECT event_id FROM event WHERE event_name = 'Precinct 41 Reunion'));
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Heidelstam'), (SELECT event_id FROM event WHERE event_name = 'Precinct 41 Reunion'));

--Revachol West Fashion Walk
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Du Bois'), (SELECT event_id FROM event WHERE event_name = 'Revachol West Fashion Walk'));

--Discover The Pale at The Dolorian Church of Humanity
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Kitsuragi'), (SELECT event_id FROM event WHERE event_name = 'Discover The Pale at The Dolorian Church of Humanity'));
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Du Bois'), (SELECT event_id FROM event WHERE event_name = 'Discover The Pale at The Dolorian Church of Humanity'));

--Book Signing with Insulindian Phasmid
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Kitsuragi'), (SELECT event_id FROM event WHERE event_name = 'Book Signing with Insulindian Phasmid'));
INSERT INTO event_member(member_id, event_id)
VALUES	((SELECT member_id FROM member WHERE last_name = 'Du Bois'), (SELECT event_id FROM event WHERE event_name = 'Book Signing with Insulindian Phasmid'));

COMMIT;