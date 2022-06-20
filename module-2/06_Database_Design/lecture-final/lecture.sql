
BEGIN TRANSACTION;

DROP TABLE IF EXISTS Painting_Person;
DROP TABLE IF EXISTS Purchases;
DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Painting;


CREATE TABLE person(
 -- columns
 person_id serial,
 name varchar(100) not null,
 phone_number varchar(25) unique,
 address varchar(500),
 -- constraints
 -- constraint name_of_constraint type_of_constraint ( column_being_constrained )
 constraint pk_person primary key (person_id)

) ;

CREATE TABLE painting(
   --columns
	painting_id serial,
	title varchar(150) not null,
	gallery_has_art boolean not null default(false),
	-- constraints
	constraint pk_painting primary key (painting_id)

);


CREATE TABLE painting_person(
	person_id int,
	painting_id int,
	constraint pk_painting_person primary key (person_id, painting_id),
	constraint fk_painting_person_person foreign key (person_id) references person(person_id),
	constraint fk_painting_person_painting foreign key (painting_id) references painting(painting_id)
);

CREATE TABLE purchases (

	purchase_id serial,
	person_id int not null,
	painting_id int not null,
	purchase_date date not null,
	price money not null,
	--constraints
	constraint pk_purchases primary key (purchase_id),
	constraint fk_purchases_person foreign key (person_id) references person(person_id),
	constraint fk_purchases_painting foreign key (painting_id) references painting(painting_id),
	constraint chk_price check (price >=  0::money)

);





COMMIT;