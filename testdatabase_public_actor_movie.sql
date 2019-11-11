create table actor_movie
(
    actor_id integer,
    movie_id integer
);

alter table actor_movie
    owner to postgres;

INSERT INTO public.actor_movie (actor_id, movie_id) VALUES (1, 27);
INSERT INTO public.actor_movie (actor_id, movie_id) VALUES (2, 30);