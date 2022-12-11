CREATE TABLE Processor
(
    name                VARCHAR(100) PRIMARY KEY,
    speed               INTEGER     NOT NULL,
    architecture        VARCHAR(20) NOT NULL,
    memory_type         VARCHAR(20) NOT NULL,
    max_memory_capacity INTEGER     NOT NULL
);