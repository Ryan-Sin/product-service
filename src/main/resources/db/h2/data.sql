MERGE INTO category (name)
    KEY (name)
    VALUES ('상의'), ('아우터'), ('바지'), ('스니커즈'), ('가방'), ('모자'), ('양말'), ('액세서리');

MERGE INTO brand (name)
    KEY (name)
    VALUES ('A'), ('B'), ('C'), ('D'), ('E'), ('F'), ('G'), ('H'), ('I');