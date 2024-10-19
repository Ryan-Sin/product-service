MERGE INTO category (name)
    KEY (name)
    VALUES ('상의'), ('아우터'), ('바지'), ('스니커즈'), ('가방'), ('모자'), ('양말'), ('액세서리');

MERGE INTO brand (name)
    KEY (name)
    VALUES ('A'), ('B'), ('C'), ('D'), ('E'), ('F'), ('G'), ('H'), ('I');

TRUNCATE TABLE product;

-- 브랜드 A
SET @brand_id_A = (SELECT id FROM brand WHERE name = 'A');
SET @category_id_top_A = (SELECT id FROM category WHERE name = '상의');
SET @category_id_outer_A = (SELECT id FROM category WHERE name = '아우터');
SET @category_id_pants_A = (SELECT id FROM category WHERE name = '바지');
SET @category_id_sneakers_A = (SELECT id FROM category WHERE name = '스니커즈');
SET @category_id_bag_A = (SELECT id FROM category WHERE name = '가방');
SET @category_id_hat_A = (SELECT id FROM category WHERE name = '모자');
SET @category_id_socks_A = (SELECT id FROM category WHERE name = '양말');
SET @category_id_accessory_A = (SELECT id FROM category WHERE name = '액세서리');

INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 11200, @brand_id_A, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 5500, @brand_id_A, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 4200, @brand_id_A, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9000, @brand_id_A, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2000, @brand_id_A, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1700, @brand_id_A, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 1800, @brand_id_A, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2300, @brand_id_A, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 B
SET @brand_id_B = (SELECT id FROM brand WHERE name = 'B');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 10500, @brand_id_B, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 5900, @brand_id_B, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 3800, @brand_id_B, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9100, @brand_id_B, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2100, @brand_id_B, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 2000, @brand_id_B, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 2000, @brand_id_B, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2200, @brand_id_B, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 C
SET @brand_id_C = (SELECT id FROM brand WHERE name = 'C');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 10000, @brand_id_C, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 6200, @brand_id_C, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 3300, @brand_id_C, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9200, @brand_id_C, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2200, @brand_id_C, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1900, @brand_id_C, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 2200, @brand_id_C, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2100, @brand_id_C, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 D
SET @brand_id_D = (SELECT id FROM brand WHERE name = 'D');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 10100, @brand_id_D, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 5100, @brand_id_D, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 3000, @brand_id_D, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9500, @brand_id_D, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2500, @brand_id_D, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1500, @brand_id_D, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 2400, @brand_id_D, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2000, @brand_id_D, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 E
SET @brand_id_E = (SELECT id FROM brand WHERE name = 'E');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 10700, @brand_id_E, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 5000, @brand_id_E, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 3800, @brand_id_E, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9900, @brand_id_E, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2300, @brand_id_E, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1800, @brand_id_E, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 2100, @brand_id_E, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2100, @brand_id_E, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 F
SET @brand_id_F = (SELECT id FROM brand WHERE name = 'F');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 11200, @brand_id_F, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 7200, @brand_id_F, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 4000, @brand_id_F, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9300, @brand_id_F, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2100, @brand_id_F, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1600, @brand_id_F, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 2300, @brand_id_F, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 1900, @brand_id_F, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 G
SET @brand_id_G = (SELECT id FROM brand WHERE name = 'G');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 10500, @brand_id_G, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 5800, @brand_id_G, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 3900, @brand_id_G, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9000, @brand_id_G, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2200, @brand_id_G, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1700, @brand_id_G, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 2100, @brand_id_G, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2000, @brand_id_G, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 H
SET @brand_id_H = (SELECT id FROM brand WHERE name = 'H');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 10800, @brand_id_H, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 6300, @brand_id_H, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 3100, @brand_id_H, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9700, @brand_id_H, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2100, @brand_id_H, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1600, @brand_id_H, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 2000, @brand_id_H, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2000, @brand_id_H, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 브랜드 I
SET @brand_id_I = (SELECT id FROM brand WHERE name = 'I');
INSERT INTO product (name, price, brand_id, category_id, created_at, updated_at)
VALUES
    ('상의', 11400, @brand_id_I, @category_id_top_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('아우터', 6700, @brand_id_I, @category_id_outer_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('바지', 3200, @brand_id_I, @category_id_pants_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('스니커즈', 9500, @brand_id_I, @category_id_sneakers_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('가방', 2400, @brand_id_I, @category_id_bag_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('모자', 1700, @brand_id_I, @category_id_hat_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('양말', 1700, @brand_id_I, @category_id_socks_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('액세서리', 2400, @brand_id_I, @category_id_accessory_A, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
