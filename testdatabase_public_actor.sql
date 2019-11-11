create table actor
(
    id        serial not null
        constraint actor_pkey
            primary key,
    name      varchar(255),
    rating    integer,
    timestamp timestamp
);

alter table actor
    owner to postgres;

INSERT INTO public.actor (id, name, rating, timestamp) VALUES (1, 'Vadim', 1, '2019-11-11 02:51:22.115000');
INSERT INTO public.actor (id, name, rating, timestamp) VALUES (2, 'Johnson', 2, '2019-11-11 02:51:27.010000');
INSERT INTO public.actor (id, name, rating, timestamp) VALUES (3, 'Alexander', 1, '2019-11-11 02:51:28.835000');
INSERT INTO public.actor (id, name, rating, timestamp) VALUES (5, 'Artyom', 0, '2019-11-11 03:09:30.675000');
INSERT INTO public.actor (id, name, rating, timestamp) VALUES (4, 'Igor', 1, '2019-11-11 04:16:54.025000');