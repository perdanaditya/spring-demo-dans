--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3
-- Dumped by pg_dump version 13.1

-- Started on 2021-08-10 00:08:55 WIB

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3257 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 200 (class 1259 OID 82917)
-- Name: m_user; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.m_user (
    user_id bigint NOT NULL,
    username character varying NOT NULL,
    password character varying NOT NULL,
    name character varying
);


--
-- TOC entry 201 (class 1259 OID 82923)
-- Name: m_user_user_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.m_user_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3258 (class 0 OID 0)
-- Dependencies: 201
-- Name: m_user_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.m_user_user_id_seq OWNED BY public.m_user.user_id;


--
-- TOC entry 3116 (class 2604 OID 82925)
-- Name: m_user user_id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.m_user ALTER COLUMN user_id SET DEFAULT nextval('public.m_user_user_id_seq'::regclass);


--
-- TOC entry 3250 (class 0 OID 82917)
-- Dependencies: 200
-- Data for Name: m_user; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO public.m_user VALUES (1, 'testUser', '123', 'Testing');


--
-- TOC entry 3259 (class 0 OID 0)
-- Dependencies: 201
-- Name: m_user_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.m_user_user_id_seq', 1, true);


--
-- TOC entry 3118 (class 2606 OID 82928)
-- Name: m_user m_user_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.m_user
    ADD CONSTRAINT m_user_pk PRIMARY KEY (user_id);


--
-- TOC entry 3119 (class 1259 OID 82926)
-- Name: m_user_user_id_uindex; Type: INDEX; Schema: public; Owner: -
--

CREATE UNIQUE INDEX m_user_user_id_uindex ON public.m_user USING btree (user_id);


-- Completed on 2021-08-10 00:08:55 WIB

--
-- PostgreSQL database dump complete
--

