CREATE TABLE IF NOT EXISTS users (
    id uuid NOT NULL,
    username text,
    password text,
    created_by text,
    created_at timestamp without time zone,
    updated_by text,
    updated_at timestamp without time zone,
    is_deleted boolean
);

CREATE TABLE IF NOT EXISTS user_access_token (
    id uuid NOT NULL,
    user_id uuid NOT NULL,
    token text,
    expireAt timestamp without time zone,
    created_by text,
    created_at timestamp without time zone,
    updated_by text,
    updated_at timestamp without time zone,
    is_deleted boolean
);

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
ALTER TABLE ONLY user_access_token
    ADD CONSTRAINT user_access_token_pkey PRIMARY KEY (id);

INSERT INTO users VALUES (uuid_generate_v4(), 'userTest', 'rum5tb4c', 'system', current_timestamp, 'system', current_timestamp, false);
