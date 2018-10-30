--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: cat; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE public.cat AS ENUM (
    'Biography and Memoir',
    'Business and Finance',
    'Computers',
    'Entertainment',
    'History',
    'Fiction',
    'Science Fiction',
    'Self-Help',
    'Health',
    'Science and Nature',
    'Poetry'
);


ALTER TYPE public.cat OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    bookid character varying(20) NOT NULL,
    title character varying(100) NOT NULL,
    price integer NOT NULL,
    author character varying(100) NOT NULL,
    category public.cat
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    type character varying(100) NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (bookid, title, price, author, category) FROM stdin;
1627794247	ROBIN	1599	Dave Itzkoff	Biography and Memoir
0132350882	CLEAN CODE: A HANDBOOK OF AGILE SOFTWARE CRAFTSMANSHIP	1599	Robert C. Martin	Computers
1118008189	HTML AND CSS: DESIGN AND BUILD WEBSITES	1599	Jon Duckett	Computers
1501175513	FEAR: TRUMP IN THE WHITE HOUSE	2000	Bob Woodward	Biography and Memoir
1476795924	LEADERSHIP: IN TURBULENT TIMES	2000	Doris Kearns Goodwin	History
0786965614	MONSTER MANUAL	2000	Wizards Rpg Team	Entertainment
0786965366	Rich Dad Poor Dad	2000	Robert Kiyosaki	Business and Finance
2785565366	Nineteen Eighty-Four	1949	George Orwell	Fiction
4278861391	The Martian	2011	Andy Weir	Science Fiction
3359814682	The Secret	2006	Rhonda Byrne	Self-Help
8547632691	How Not to Die	2015	Gene Stone	Health
7165935247	The Future of the Mind	2014	Michio Kaku	Science and Nature
1563489522	Leaves of Grass	1855	Walt Whitman	Poetry
1523647221	Golestan	1258	Saadi	Poetry
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (type) FROM stdin;
Biography and Memoir
Business and Finance
Computers
Entertainment
History
Fiction
Science Fiction
Self-Help
Health
Science and Nature
Poetry
\.


--
-- PostgreSQL database dump complete
--

