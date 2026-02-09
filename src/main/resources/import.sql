INSERT INTO "permissions" (id, permission_name) VALUES
  (1, 'READ'),
  (2, 'CREATE'),
  (3, 'UPDATE');

INSERT INTO "roles" (id, role_name) VALUES
  (1, 'ADMIN'),
  (2, 'USER');

INSERT INTO role_permissions (role_id, permission_id) VALUES
  (1, 1), -- ADMIN -> READ
  (1, 2), -- ADMIN -> CREATE
  (1, 3), -- ADMIN -> UPDATE
  (2, 1); -- USER -> READ

INSERT INTO "users" (id, name, password, email, is_enable, account_no_expired, account_no_locked, credentials_no_expired) VALUES
  (
      100001,
   'Tomas',
   '$2a$10$FEZurEdJ9R8VmdPR7qyFvebJaVlNByHEdxWXxlw6SWBCDUTZn5gb2',
   'admin@example.com',
   true,
   true,
   true,
   true
  ), -- password: admin
  (
      100002,
   'Usuario 1',
   '$2a$10$uqE9z6UPiebEKuWOtJDss.Lacy2DFC3b7kmtrsCjjYnYGV4WNil7.',
   'user@example.com',
   true,
   true,
   true,
   true
  ); -- password: user

INSERT INTO user_roles (user_id, role_id) VALUES
  (100001, 1),
  (100002, 2);