create table products(
    id bigint NOT NULL,
    product_id varchar(100) NOT NULL,
    name text NOT NULL,
    description text NOT NULL,
    primary key (id),
    CONSTRAINT product_id_unq unique (product_id)
);
create sequence products_id_seq INCREMENT by 50;

create table ratings(
     id bigint NOT NULL,
     product_id varchar(100) NOT NULL,
     rating decimal NOT NULL,
     primary key (id),
     constraint product_id_f_key FOREIGN KEY (product_id) REFERENCES products (product_id)
);
create sequence ratings_id_seq INCREMENT by 50;
