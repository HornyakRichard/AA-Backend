INSERT INTO USER_DATA (id, username, name, password, active, deleted_flag, NEXT_LOGIN_CHANGE_PWD, PASSWORD_EXPIRED, SETTLEMENT_ID, TEMP_PASSWORD_EXPIRED, UPDATED)
VALUES (10, 'admin', 'Peter', '$2a$10$RNoDPn2taMNx5pA7WKnc0.4yplVvlKuceGqpPj6E9zS7J2k8qlUlK', true, false, false, false, 10, false, false);
INSERT INTO USER_DATA (id, username, name, password, active, deleted_flag, NEXT_LOGIN_CHANGE_PWD, PASSWORD_EXPIRED, SETTLEMENT_ID, TEMP_PASSWORD_EXPIRED, UPDATED)
VALUES (11, 'public', 'Sandor','$2a$10$RNoDPn2taMNx5pA7WKnc0.4yplVvlKuceGqpPj6E9zS7J2k8qlUlK', true, false, false, false, 10, false, false);

INSERT INTO USER_DATA (id, username, name, password, active, deleted_flag, NEXT_LOGIN_CHANGE_PWD, PASSWORD_EXPIRED, SETTLEMENT_ID, TEMP_PASSWORD_EXPIRED, UPDATED)
VALUES (12, 'user9', 'Erzsi', '$2a$10$RNoDPn2taMNx5pA7WKnc0.4yplVvlKuceGqpPj6E9zS7J2k8qlUlK', true, false, false, false, 10, false, false);

INSERT INTO USER_DATA (id, username, name, password, active, deleted_flag, NEXT_LOGIN_CHANGE_PWD, PASSWORD_EXPIRED, SETTLEMENT_ID, TEMP_PASSWORD_EXPIRED, UPDATED)
VALUES (23, 'user44', 'Ilona', '$2a$10$RNoDPn2taMNx5pA7WKnc0.4yplVvlKuceGqpPj6E9zS7J2k8qlUlK', true, false, false, false, 10, false, false);

INSERT INTO ROLE_DATA (id, role, user_id)
VALUES (4, 0, 10);

INSERT INTO ROLE_DATA (id, role, user_id)
VALUES (5, 1, 11);

INSERT INTO ROLE_DATA (id, role, user_id)
VALUES (6, 0, 12);

INSERT INTO ROLE_DATA (id, role, user_id)
VALUES (7, 0, 23);
