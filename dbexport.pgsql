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
    category_id character varying(255) NOT NULL
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.category (
    category_type character varying(255) NOT NULL,
    category_id character varying(255) NOT NULL
);


ALTER TABLE public.category OWNER TO postgres;

--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (bookid, title, price, author, category_id) FROM stdin;
1627794247	ROBIN	1599	Dave Itzkoff	1
0132350882	CLEAN CODE: A HANDBOOK OF AGILE SOFTWARE CRAFTSMANSHIP	1599	Robert C. Martin	3
1118008189	HTML AND CSS: DESIGN AND BUILD WEBSITES	1599	Jon Duckett	3
1501175513	FEAR: TRUMP IN THE WHITE HOUSE	2000	Bob Woodward	1
1476795924	LEADERSHIP: IN TURBULENT TIMES	2000	Doris Kearns Goodwin	5
0786965614	MONSTER MANUAL	2000	Wizards Rpg Team	4
0786965366	Rich Dad Poor Dad	2000	Robert Kiyosaki	2
2785565366	Nineteen Eighty-Four	1949	George Orwell	6
4278861391	The Martian	2011	Andy Weir	7
3359814682	The Secret	2006	Rhonda Byrne	8
8547632691	How Not to Die	2015	Gene Stone	9
7165935247	The Future of the Mind	2014	Michio Kaku	10
1563489522	Leaves of Grass	1855	Walt Whitman	11
1523647221	Golestan	1258	Saadi	11
\.


--
-- Data for Name: category; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.category (category_type, category_id) FROM stdin;
Biography and Memoir	1
Business and Finance	2
Computers	3
Entertainment	4
History	5
Fiction	6
Science Fiction	7
Self-Help	8
Health	9
Science and Nature	10
Poetry	11
\.


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (bookid, category_id);


--
-- Name: category category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.category
    ADD CONSTRAINT category_pkey PRIMARY KEY (category_id);


--
-- Name: book book_category_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_category_id_fkey FOREIGN KEY (category_id) REFERENCES public.category(category_id);


--
-- PostgreSQL database dump complete
--

