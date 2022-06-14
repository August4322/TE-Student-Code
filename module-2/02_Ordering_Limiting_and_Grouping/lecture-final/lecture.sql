-- QUESTIONS FROM PULSE SURVEY

SELECT *
FROM city
WHERE city_name like 'New%';

SELECT *
FROM city
WHERE city_name like 'New %';

SELECT * 
FROM park
WHERE date_established BETWEEN '1980-01-01' AND '1989-12-31';
-- WHERE date_established >= '1980-01-01' AND date_established <= '1989-12-31';

SELECT city_name AS name, population*2 AS double_population, area/population AS anything_I_want
FROM city;


-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC; -- ASC for ascending

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
select state_name, census_region
FROM state
ORDER BY census_region DESC, state_name ASC;

-- The biggest park by area. Select only park_name. Largest to smallest.
SELECT park_name, area
FROM park
ORDER BY area DESC;



-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT *
FROM city
ORDER BY population DESC
LIMIT 10;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT (CURRENT_DATE - date_established)/365 AS age, park_name
FROM park
ORDER BY age DESC, park_name ASC
LIMIT 20;

SELECT CURRENT_DATE; -- gives us the current day
SELECT EXTRACT(year from CURRENT_DATE); -- gives us the year
SELECT EXTRACT(month from CURRENT_DATE); -- month
SELECT EXTRACT(day from CURRENT_DATE); -- day

SELECT EXTRACT(year from CURRENT_DATE) - EXTRACT(year from date_established) as years_in_operation, park_name
FROM park
ORDER BY years_in_operation DESC
LIMIT 20;

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
select city_name || ' (' || state_abbreviation || ')' as formatted_city_state
FROM city
ORDER BY city_name;

-- The all parks by name and date established.
SELECT 'NAME: ' || park_name || ' (' || date_established || ')'
FROM park
ORDER BY park_name;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
-- Census_Region: state   West: California
SELECT 'Census Region: ' || census_region || ' (' || state_name || ') ' AS census_region_state 
FROM state
WHERE LOWER(census_region) = 'west' OR LOWER(census_region) = 'midwest'
ORDER BY census_region_state;


SELECT LOWER(census_region), UPPER(census_region) -- If we want to capitalize or lower case something
FROM state;

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population)::DECIMAL(11,2) AS avg_state_population -- If we want to cast to a specific datatype use ::type
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS total_population
FROM state
WHERE census_region IN ('West', 'South');
-- WHERE census_region = 'West' or census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT COUNT(population) 
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(*) AS row_count, -- includes all rows
	   COUNT(state_nickname) AS nickname_count -- includes all values that are not null
FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(city_name) AS num_of_cities
FROM city
GROUP BY state_abbreviation
ORDER BY num_of_cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT AVG(area), has_camping
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, 'Total Population: ' || SUM(population) AS total_population_by_state
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest
FROM city
GROUP BY state_abbreviation
ORDER BY smallest;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
select city_name, population
FROM city
ORDER BY city_name
OFFSET 20 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT COUNT(city_name) AS cities,
	( 
		 SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation
	)
FROM city
GROUP BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest, 
		(
			SELECT city_name FROM city c2 WHERE c2.population = MIN(c1.population) and c2.state_abbreviation = c1.state_abbreviation
		)
FROM city c1
GROUP BY state_abbreviation
ORDER BY smallest;
