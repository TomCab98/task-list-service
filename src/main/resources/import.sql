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

INSERT INTO users (id, username, password, email, is_enable, account_no_expired, account_no_locked, credentials_no_expired) VALUES
  ('750e8400-e29b-41d4-a716-446655440006', 'adminUser', '$2a$10$B7HafAPX15i8J2NidwsaC.V/Ta.pV/zQQHAcOqfnoIAUgZmUrWi0G', 'admin@example.com', true, true, true, true),
  ('750e8400-e29b-41d4-a716-446655440007', 'normalUser', '$2a$10$bG2ojsNTXd1m4iT32HZo2edPV4jatyuzERNJyEGAwXgUznX0UpGRq', 'user@example.com', true, true, true, true);

INSERT INTO user_roles (user_id, role_id) VALUES
  ('750e8400-e29b-41d4-a716-446655440006', '650e8400-e29b-41d4-a716-446655440004'),
  ('750e8400-e29b-41d4-a716-446655440007', '650e8400-e29b-41d4-a716-446655440005');