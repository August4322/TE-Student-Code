BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);


DROP TABLE IF EXISTS cards;
CREATE TABLE cards (
    card_id SERIAL,
    img_path varchar(200) NOT NULL,
    title varchar(150) NOT NULL,
    caption varchar(500) NOT NULL,
    is_detrimental boolean NOT NULL DEFAULT(false)
);

COMMIT TRANSACTION;
