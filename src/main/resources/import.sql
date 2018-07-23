INSERT INTO users (id, active, email, full_name, role, username) VALUES (1, true, 'boskov@gmail.com','Olivera Boskov', 'admin', 'Olivera');
INSERT INTO users (id, active, email, full_name, role, username) VALUES (2, true, 'zivolic@gmail.com','Smiljana Zivolic', 'user', 'Smiljana');
INSERT INTO users (id, active, email, full_name, role, username) VALUES (3, true, 'dovicin@gmail.com','Nevena Dovicin', 'user', 'Nevena');
INSERT INTO team (id, active, description, name) VALUES (1, true, 'java', 'tim 1');
INSERT INTO team (id, active, description, name) VALUES (2, true, 'spring', 'tim 2');
INSERT INTO user_to_group(id, team_id, user_id) VALUES (1, 1, 1);
INSERT INTO user_to_group(id, team_id, user_id) VALUES (2, 1, 2);
INSERT INTO user_to_group(id, team_id, user_id) VALUES (3, 2, 1);
INSERT INTO user_to_group(id, team_id, user_id) VALUES (4, 2, 2);
INSERT INTO user_to_group(id, team_id, user_id) VALUES (5, 2, 3);




