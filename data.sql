INSERT INTO demo.`role` (description,name) VALUES
	 ('admin user','ADMIN'),
	 ('user','USER'),
	 ('vip user','VIP_USER');

INSERT INTO demo.`user` (reg_time,user_name,email,nick_name,password,`role`,role_id) VALUES
	 ('2025-10-12 07:34:43','user1','user1@example.com','User One','$2a$10$wZhLh.3MjvbNZqe55Q64l.k3FARl8As8TNrgT8ce4pEr//mg7Dcbq','USER',2),
	 ('2025-10-12 07:34:43','user2','user2@example.com','User Two','$2a$10$wZhLh.3MjvbNZqe55Q64l.k3FARl8As8TNrgT8ce4pEr//mg7Dcbq','USER',2),
	 ('2025-10-12 07:34:43','user3','user3@example.com','User Three','$2a$10$wZhLh.3MjvbNZqe55Q64l.k3FARl8As8TNrgT8ce4pEr//mg7Dcbq','USER',2),
	 ('2025-10-12 07:34:43','admin1','admin1@example.com','Admin One','$2a$10$wZhLh.3MjvbNZqe55Q64l.k3FARl8As8TNrgT8ce4pEr//mg7Dcbq','ADMIN',1),
	 ('2025-10-12 07:34:43','admin2','admin2@example.com','Admin Two','$2a$10$wZhLh.3MjvbNZqe55Q64l.k3FARl8As8TNrgT8ce4pEr//mg7Dcbq','ADMIN',1),
	 ('2025-10-12 15:47:00.961894','user5','user5@example.com','User five','123456','USER',2),
	 ('2025-10-12 16:43:27.009515','user6','user6@example.com','User six','$2a$10$wZhLh.3MjvbNZqe55Q64l.k3FARl8As8TNrgT8ce4pEr//mg7Dcbq','USER',2);

INSERT INTO demo.product (name) VALUES
	 ('product1'),
	 ('product2');
