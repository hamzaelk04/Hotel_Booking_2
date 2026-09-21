CREATE TABLE IF NOT EXISTS users
(
    id         UUID PRIMARY KEY      DEFAULT gen_random_uuid(),
    name       VARCHAR(150) NOT NULL,
    email      VARCHAR(150) NOT NULL UNIQUE,
    phone      VARCHAR(10)  NOT NULL,
    password   VARCHAR(255) NOT NULL,
    role       user_role    NOT NULL DEFAULT 'Client',
    created_at TIMESTAMPTZ  NOT NULL DEFAULT NOW()
);