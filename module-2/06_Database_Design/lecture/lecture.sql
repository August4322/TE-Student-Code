
BEGIN TRANSACTION;

DROP TABLE IF EXISTS Art_Person;
DROP TABLE IF EXISTS Purchases;
DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Art;

CREATE TABLE Person(
--columns
	person_id serial,
	name varchar(100) not null,
	phone_number varchar(25) unique,
	address varchar(500),
--constraints
	CONSTRAINT pk_person primary key (person_id)
	--constraint name_of_constraint type_of_constraint (column_being_constrained)
);

CREATE TABLE Art(
--columns
	art_id serial,
	title varchar(150) not null,
	gallery_has_art boolean not null default(false),
--constraints
	CONSTRAINT pk_art primary key (art_id)
);

CREATE TABLE Art_Person(
--columns
	person_id int,
	art_id int,
--constraints
	CONSTRAINT pk_art_person primary key (person_id, art_id),
	CONSTRAINT fk_art_person_person foreign key (person_id) references person(person_id),
	CONSTRAINT fk_art_person_art foreign key (art_id) references art(art_id)
);

CREATE TABLE Purchases(
--columns
	purchase_id serial,
	person_id int not null,
	art_id int not null,
	puchase_date date not null,
	price money not null,
--constraints
	CONSTRAINT pk_purchases primary key (purchase_id),
	CONSTRAINT fk_purchases_person foreign key (person_id) references person(person_id),
	CONSTRAINT fk_purchases_art foreign key (art_id) references art(art_id),
	CONSTRAINT chk_price check (price >= 0::money)
);


COMMIT;