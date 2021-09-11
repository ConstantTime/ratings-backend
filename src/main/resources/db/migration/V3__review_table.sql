create table reviews(
    id bigint NOT NULL,
    product_id varchar(100) NOT NULL,
    review decimal NOT NULL,
    primary key (id),
    constraint product_id_f_key FOREIGN KEY (product_id) REFERENCES products (product_id)
);
create sequence reviews_id_seq INCREMENT by 50;