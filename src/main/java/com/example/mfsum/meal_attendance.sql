CREATE TABLE User_consumer(
    user_id int PRIMARY KEY IDENTITY(1,1),
    name varchar(35) NOT NULL,
    password varchar(35) NOT NULL,
    monday_attendance bit,
    tuesday_attendance bit,
    wednesday_attendance bit,
    thursday_attendance bit,
    friday_attendance bit,
    vegetarian bit,
    non_vegetarian bit
);

ALTER TABLE User_consumer
    ADD e_mail VARCHAR(35);