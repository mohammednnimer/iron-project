
ALTER TABLE users_tbl ADD COLUMN active_token TEXT;



ALTER TABLE users_tbl ADD COLUMN user_status BOOLEAN DEFAULT FALSE;
update users_tbl set user_status =false




CREATE TABLE logs_tbl (
    id VARCHAR(30) PRIMARY KEY,
    ip VARCHAR(50),
    api VARCHAR(255),
    request_body TEXT,
    response_body TEXT,
    response_time DATE,
    status_code VARCHAR(10));


ALTER TABLE ironshapes_tbl RENAME COLUMN "IMG_IMAGE" TO img_image;






