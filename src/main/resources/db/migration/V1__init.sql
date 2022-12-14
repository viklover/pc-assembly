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

CREATE TABLE motherboard
(
    id               INTEGER PRIMARY KEY AUTO_INCREMENT,
    cpu_architecture VARCHAR(10),
    ram_type         VARCHAR(20),
    ram_slots        INTEGER DEFAULT 0,
    FOREIGN KEY (cpu_architecture) references cpu_architecture (name),
    FOREIGN KEY (ram_type) references ram_type (name)
);

CREATE TABLE ram_combination
(
    id     INTEGER PRIMARY KEY AUTO_INCREMENT,
    ram_id INTEGER NOT NULL,
    count  INTEGER DEFAULT 0,
    FOREIGN KEY (ram_id) references ram (id)
);

CREATE TABLE assembly
(
    motherboard_id     INTEGER NOT NULL,
    cpu_id             INTEGER NOT NULL,
    ram_combination_id INTEGER NOT NULL,
    FOREIGN KEY (cpu_id) references cpu (id),
    FOREIGN KEY (motherboard_id) references motherboard (id),
    FOREIGN KEY (ram_combination_id) references ram_Combination (id)
);