CREATE TABLE cpu_architecture
(
    name VARCHAR(20) PRIMARY KEY
);

CREATE TABLE ram_type
(
    name VARCHAR(20) PRIMARY KEY
);

CREATE TABLE cpu
(
    id               INTEGER PRIMARY KEY AUTO_INCREMENT,
    name             VARCHAR(100) UNIQUE NOT NULL,
    speed            INTEGER             NOT NULL,
    architecture     VARCHAR(20)         NOT NULL,
    ram_type         VARCHAR(20)         NOT NULL,
    max_ram_capacity INTEGER             NOT NULL,
    FOREIGN KEY (architecture) references cpu_architecture (name),
    FOREIGN KEY (ram_type) references ram_type (name)
);

CREATE TABLE ram
(
    id       INTEGER PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(100) UNIQUE NOT NULL,
    type     VARCHAR(20)         NOT NULL,
    speed    INTEGER             NOT NULL,
    capacity LONG                NOT NULL,
    FOREIGN KEY (type) references ram_type (name)
);

CREATE TABLE board
(
    id               INTEGER PRIMARY KEY AUTO_INCREMENT,
    name             VARCHAR(100) UNIQUE NOT NULL,
    cpu_architecture VARCHAR(10),
    ram_type         VARCHAR(20),
    ram_slots        INTEGER DEFAULT 0,
    FOREIGN KEY (cpu_architecture) references cpu_architecture (name),
    FOREIGN KEY (ram_type) references ram_type (name)
);

CREATE TABLE assembly
(
    id             INTEGER PRIMARY KEY AUTO_INCREMENT,
    motherboard_id INTEGER,
    cpu_id         INTEGER,
    FOREIGN KEY (cpu_id) references cpu (id),
    FOREIGN KEY (motherboard_id) references board (id)
);

CREATE TABLE ram_combination
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    assembly_id INTEGER NOT NULL,
    ram_id      INTEGER NOT NULL,
    count       INTEGER DEFAULT 0,
    FOREIGN KEY (ram_id) references ram (id),
    FOREIGN KEY (assembly_id) references assembly (id) on delete cascade
);

