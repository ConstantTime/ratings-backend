alter table products add column created_at timestamp NOT NULL;
alter table products add column updated_at timestamp NOT NULL;

alter table ratings add column created_at timestamp NOT NULL;
alter table ratings add column updated_at timestamp NOT NULL;

alter table ratings add column rating_id varchar (100) NOT null;