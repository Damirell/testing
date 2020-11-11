create table if not exists purchase
(
    id        serial primary key,
    msisdn    integer not null,
    timestamp bigint  not null
);

create table if not exists subscription
(
    id        serial primary key,
    msisdn    integer not null,
    timestamp bigint  not null
);