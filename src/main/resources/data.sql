DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS sessions;
DROP TABLE IF EXISTS slots;

CREATE TABLE users (
  user_id VARCHAR(250) PRIMARY KEY,
  full_name VARCHAR(250) DEFAULT NULL,
  email VARCHAR(250) DEFAULT NULL,
  password VARCHAR(250) NOT NULL,
  created_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE sessions (
    user_id VARCHAR(250) PRIMARY KEY,
    access_key VARCHAR(250) NOT NULL,
    secret_key VARCHAR(250) NOT NULL,
    created_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE slots (
    slot_id VARCHAR(250) PRIMARY KEY,
    user_id VARCHAR(250) NOT NULL,
    for_date DATE NOT NULL,
    start_time INT NOT NULL,
    end_time INT,
    status INT DEFAULT 0,
    booked_by_user VARCHAR(250) DEFAULT NULL,
    created_on timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    booked_on timestamp DEFAULT NULL
);

select * from users;
select * from sessions;
select * from slots;