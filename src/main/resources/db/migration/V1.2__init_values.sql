INSERT INTO
    ram
    (id, name, speed, capacity)
VALUES
    (61697, 'RAM #11', 500, 1024),
    (61698, 'RAM #12', 700, 2048),
    (61699, 'RAM #13', 900, 4096),
    (61700, 'RAM #14', 1100, 8192),
    (61701, 'RAM #15', 1500, 16384),
    (61958, 'RAM #21', 800, 2048),
    (61959, 'RAM #22', 900, 4096),
    (61960, 'RAM #23', 1200, 8192),
    (61961, 'RAM #24', 1300, 16384),
    (62218, 'RAM #31', 900, 4096),
    (62219, 'RAM #32', 1100, 8192),
    (62220, 'RAM #33', 1300, 16384),
    (62477, 'RAM #41', 1000, 4096),
    (62478, 'RAM #42', 1100, 8192),
    (62479, 'RAM #43', 1300, 16384);

INSERT INTO
    cpu
    (id, name, speed, max_ram_capacity)
VALUES
    (8456, 'Intel Core i3-2200U', 2900, 32768),
    (4609, 'Intel Core i3-3400U', 3200, 32768),
    (4866, 'Intel Core i3-6500U', 3800, 32768),
    (5123, 'Intel Core i3-8800U', 4200, 32768),
    (8452, 'Arm Processor #1', 3200, 32768),
    (8709, 'Arm Processor #2', 3400, 32768),
    (8966, 'Arm Processor #3', 3800, 32768),
    (9223, 'Arm Processor #4', 4200, 32768);

INSERT INTO
    board
    (id, name, ram_slots)
VALUES
    (4354, 'Motherboard #12', 2),
    (4609, 'Motherboard #11', 4),
    (4867, 'Motherboard #13', 4),
    (5124, 'Motherboard #14', 8),
    (8453, 'Motherboard #21', 2),
    (8710, 'Motherboard #22', 4),
    (8967, 'Motherboard #23', 4),
    (9224, 'Motherboard #24', 8);