create table products(
    id bigint NOT NULL,
    name text NOT NULL,
    description text NOT NULL,
    primary key (id)
);
create sequence products_id_seq INCREMENT by 50;

create table ratings(
     id bigint NOT NULL,
     product_id text NOT NULL,
     rating decimal NOT NULL,
     primary key (id)
);
create sequence ratings_id_seq INCREMENT by 50;
