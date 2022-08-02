-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER morbius_owner
WITH PASSWORD 'finalcapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO morbius_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO morbius_owner;

CREATE USER morbius_appuser
WITH PASSWORD 'finalcapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO morbius_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO morbius_appuser;
