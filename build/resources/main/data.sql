-- 1. Brand 데이터 (9개: A ~ I)
INSERT INTO brand (id, name, active, created_date, last_modified_date)
VALUES (1, 'A', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active, created_date, last_modified_date)
VALUES (2, 'B', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active,created_date, last_modified_date)
VALUES (3, 'C', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active,created_date, last_modified_date)
VALUES (4, 'D', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active,created_date, last_modified_date)
VALUES (5, 'E', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active,created_date, last_modified_date)
VALUES (6, 'F', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active,created_date, last_modified_date)
VALUES (7, 'G', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active,created_date, last_modified_date)
VALUES (8, 'H', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO brand (id, name, active,created_date, last_modified_date)
VALUES (9, 'I', true,CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 2. Category 데이터 (8개)
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (1, '상의', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (2, '아우터', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (3, '바지', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (4, '스니커즈', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (5, '가방', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (6, '모자', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (7, '양말', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO category (id, name, created_date, last_modified_date)
VALUES (8, '악세서리', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO item (id, name, active, price, category_id, brand_id, created_date, last_modified_date)
VALUES
    -- 브랜드 A (id:1)
    (1,  'A 상의',    true,  11200, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2,  'A 아우터', true,   5500,  2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (3,  'A 바지',   true,   4200,  3, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (4,  'A 스니커즈', true, 9000,  4, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (5,  'A 가방',    true,  2000,  5, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (6,  'A 모자',    true,  1700,  6, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (7,  'A 양말',    true,  1800,  7, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (8,  'A 액세서리', true, 2300,  8, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 B (id:2)
    (9,  'B 상의',     true, 10500, 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (10, 'B 아우터',   true, 5900,  2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (11, 'B 바지',     true, 3800,  3, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (12, 'B 스니커즈', true, 9100,  4, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (13, 'B 가방',     true, 2100,  5, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (14, 'B 모자',     true, 2000,  6, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (15, 'B 양말',     true, 2000,  7, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (16, 'B 액세서리', true, 2200,  8, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 C (id:3)
    (17, 'C 상의',     true, 10000, 1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (18, 'C 아우터',   true, 6200,  2, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (19, 'C 바지',     true, 3300,  3, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (20, 'C 스니커즈', true, 9200,  4, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (21, 'C 가방',     true, 2200,  5, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (22, 'C 모자',     true, 1900,  6, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (23, 'C 양말',     true, 2200,  7, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (24, 'C 액세서리', true, 2100,  8, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 D (id:4)
    (25, 'D 상의',     true, 10100, 1, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (26, 'D 아우터',   true, 5100,  2, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (27, 'D 바지',     true, 3000,  3, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (28, 'D 스니커즈', true, 9500,  4, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (29, 'D 가방',     true, 2500,  5, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (30, 'D 모자',     true, 1500,  6, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (31, 'D 양말',     true, 2400,  7, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (32, 'D 액세서리', true, 2000,  8, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 E (id:5)
    (33, 'E 상의',     true, 10700, 1, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (34, 'E 아우터',   true, 5000,  2, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (35, 'E 바지',     true, 3800,  3, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (36, 'E 스니커즈', true, 9900,  4, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (37, 'E 가방',     true, 2300,  5, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (38, 'E 모자',     true, 1800,  6, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (39, 'E 양말',     true, 2100,  7, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (40, 'E 액세서리', true, 2100,  8, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 F (id:6)
    (41, 'F 상의',     true, 11200, 1, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (42, 'F 아우터',   true, 7200,  2, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (43, 'F 바지',     true, 4000,  3, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (44, 'F 스니커즈', true, 9300,  4, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (45, 'F 가방',     true, 2100,  5, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (46, 'F 모자',     true, 1600,  6, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (47, 'F 양말',     true, 2300,  7, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (48, 'F 액세서리', true, 1900,  8, 6, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 G (id:7)
    (49, 'G 상의',     true, 10500, 1, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (50, 'G 아우터',   true, 5800,  2, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (51, 'G 바지',     true, 3900,  3, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (52, 'G 스니커즈', true, 9000,  4, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (53, 'G 가방',     true, 2200,  5, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (54, 'G 모자',     true, 1700,  6, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (55, 'G 양말',     true, 2100,  7, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (56, 'G 액세서리', true, 2000,  8, 7, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 H (id:8)
    (57, 'H 상의',     true, 10800, 1, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (58, 'H 아우터',   true, 6300,  2, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (59, 'H 바지',     true, 3100,  3, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (60, 'H 스니커즈', true, 9700,  4, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (61, 'H 가방',     true, 2100,  5, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (62, 'H 모자',     true, 1600,  6, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (63, 'H 양말',     true, 2000,  7, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (64, 'H 액세서리', true, 2000,  8, 8, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    -- 브랜드 I (id:9)
    (65, 'I 상의',     true, 11400, 1, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (66, 'I 아우터',   true, 6700,  2, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (67, 'I 바지',     true, 3200,  3, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (68, 'I 스니커즈', true, 9500,  4, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (69, 'I 가방',     true, 2400,  5, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (70, 'I 모자',     true, 1700,  6, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (71, 'I 양말',     true, 1700,  7, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (72, 'I 액세서리', true, 2400,  8, 9, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
