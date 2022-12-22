CREATE TABLE cpu_architecture
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE ram_type
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) UNIQUE NOT NULL
);

CREATE TABLE cpu
(
    id               INTEGER PRIMARY KEY NOT NULL,
    name             VARCHAR(100) UNIQUE NOT NULL,
    speed            INTEGER             NOT NULL,
    max_ram_capacity INTEGER             NOT NULL
);

CREATE TABLE ram
(
    id       INTEGER PRIMARY KEY NOT NULL,
    name     VARCHAR(100) UNIQUE NOT NULL,
    speed    INTEGER             NOT NULL,
    capacity LONG                NOT NULL
);

CREATE TABLE board
(
    id        INTEGER PRIMARY KEY NOT NULL,
    name      VARCHAR(100) UNIQUE NOT NULL,
    ram_slots INTEGER DEFAULT 0
);

CREATE TABLE assembly
(
    id             INTEGER PRIMARY KEY AUTO_INCREMENT,
    motherboard_id INTEGER,
    cpu_id         INTEGER,
    FOREIGN KEY (cpu_id) REFERENCES cpu (id) ON UPDATE CASCADE,
    FOREIGN KEY (motherboard_id) REFERENCES board (id) ON UPDATE CASCADE
);

CREATE TABLE ram_combination
(
    assembly_id INTEGER NOT NULL,
    ram_id      INTEGER NOT NULL,
    count       INTEGER DEFAULT 0,
    FOREIGN KEY (ram_id) REFERENCES ram (id),
    FOREIGN KEY (assembly_id) REFERENCES assembly (id) on delete cascade
);
