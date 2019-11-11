create table movie_genre
(
    movie_id integer not null
        constraint fkp6vjabv2e2435at1hnuxg64yv
            references movie,
    genres   varchar(255)
);

alter table movie_genre
    owner to postgres;

INSERT INTO public.movie_genre (movie_id, genres) VALUES (27, 'криминал');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (27, 'драма');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (30, 'драма');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (30, 'комедия');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (33, 'приключения');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (33, 'драма');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (43, 'аниме');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (43, 'мультфильм');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (43, 'фантастика');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (45, 'драма');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (45, 'криминал');
INSERT INTO public.movie_genre (movie_id, genres) VALUES (47, 'комедия');