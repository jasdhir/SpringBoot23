-- Inserting data for table `users`
--

INSERT INTO `tbl_users` 
VALUES 
('john','test123',1),
('mary','test123',1),
('susan','test123',1);

--
-- Inserting data for table `authorities`
--

INSERT INTO `tbl_authorities` 
VALUES 
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_ADMIN');

-- ('john','{noop}test123',1),
--('mary','{noop}test123',1),
-- ('susan','{noop}test123',1);
