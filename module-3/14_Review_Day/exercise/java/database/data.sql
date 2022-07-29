BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO cards(img_path, title, caption)
VALUES('imgs/casio_watch.jpg','Casio Watch','It''s Morbin'' Time');

INSERT INTO cards(img_path, title, caption)
VALUES('imgs/morbin_time_mug.webp','Morbin'' Mug','Bring Me To Life');

INSERT INTO cards(img_path, title, caption)
VALUES('imgs/vulture.jpg','Morbin'' Friend','We Should Team Up');

INSERT INTO cards(img_path, title, caption)
VALUES('imgs/inconspicuous_outfit.webp','Inconspicuous Outfit','I Put The Morb In Morbius');

INSERT INTO cards(img_path, title, caption, is_detrimental)
VALUES('imgs/rotten.jfif','Bad Review','Morbtastic', true);

COMMIT TRANSACTION;
