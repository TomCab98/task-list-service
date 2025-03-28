INSERT INTO permissions (id, permission_name) VALUES
  ('550e8400-e29b-41d4-a716-446655440001', 'READ'),
  ('550e8400-e29b-41d4-a716-446655440002', 'CREATE'),
  ('550e8400-e29b-41d4-a716-446655440003', 'UPDATE');

INSERT INTO roles (id, role_name) VALUES
  ('650e8400-e29b-41d4-a716-446655440004', 'ADMIN'),
  ('650e8400-e29b-41d4-a716-446655440005', 'USER');

INSERT INTO role_permissions (role_id, permission_id) VALUES
  ('650e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440001'), -- ADMIN -> READ
  ('650e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440002'), -- ADMIN -> CREATE
  ('650e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440003'), -- ADMIN -> UPDATE
  ('650e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440001'); -- USER -> READ

INSERT INTO users (id, name, password, email, is_enable, account_no_expired, account_no_locked, credentials_no_expired) VALUES
  ('750e8400-e29b-41d4-a716-446655440006', 'Tomas', '$2a$10$FEZurEdJ9R8VmdPR7qyFvebJaVlNByHEdxWXxlw6SWBCDUTZn5gb2', 'admin@example.com', true, true, true, true), -- password: admin
  ('750e8400-e29b-41d4-a716-446655440007', 'Usuario 1', '$2a$10$uqE9z6UPiebEKuWOtJDss.Lacy2DFC3b7kmtrsCjjYnYGV4WNil7.', 'user@example.com', true, true, true, true); -- password: user

INSERT INTO user_roles (user_id, role_id) VALUES
  ('750e8400-e29b-41d4-a716-446655440006', '650e8400-e29b-41d4-a716-446655440004'),
  ('750e8400-e29b-41d4-a716-446655440007', '650e8400-e29b-41d4-a716-446655440005');