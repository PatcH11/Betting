CREATE TABLE users
(
    user_id    serial       NOT NULL,
    picture_id integer,
    username   varchar(100) NOT NULL,
    password   varchar(100) NOT NULL,
    email      varchar(100) NOT NULL,
    first_name varchar(100) NOT NULL,
    last_name  varchar(100) NOT NULL,
    CONSTRAINT users_pk PRIMARY KEY (user_id)
);



CREATE TABLE pictures
(
    picture_id serial NOT NULL,
    name       varchar(100),
    type       varchar(100),
    data       bytea  NOT NULL,
    CONSTRAINT pictures_pk PRIMARY KEY (picture_id)
);



CREATE TABLE sport_games
(
    sport_game_id serial       NOT NULL,
    name          varchar(100) NOT NULL,
    CONSTRAINT sport_games_pk PRIMARY KEY (sport_game_id)
);



CREATE TABLE matches
(
    match_id      serial  NOT NULL,
    sport_game_id integer NOT NULL,
    team_home_id  integer NOT NULL,
    team_away_id  integer NOT NULL,
    CONSTRAINT matches_pk PRIMARY KEY (match_id)
);



CREATE TABLE teams
(
    team_id    serial       NOT NULL,
    name       varchar(100) NOT NULL,
    CONSTRAINT teams_pk PRIMARY KEY (team_id)
);



CREATE TABLE bets
(
    bet_id   serial  NOT NULL,
    user_id  integer NOT NULL,
    match_id integer NOT NULL,
    winner   integer NOT NULL,
    CONSTRAINT bets_pk PRIMARY KEY (bet_id)
);



ALTER TABLE users
    ADD CONSTRAINT users_fk0 FOREIGN KEY (picture_id) REFERENCES pictures (picture_id);

ALTER TABLE matches
    ADD CONSTRAINT matches_fk0 FOREIGN KEY (sport_game_id) REFERENCES sport_games (sport_game_id);
ALTER TABLE matches
    ADD CONSTRAINT matches_fk1 FOREIGN KEY (team_home_id) REFERENCES teams (team_id);
ALTER TABLE matches
    ADD CONSTRAINT matches_fk2 FOREIGN KEY (team_away_id) REFERENCES teams (team_id);

ALTER TABLE bets
    ADD CONSTRAINT bets_fk0 FOREIGN KEY (user_id) REFERENCES users (user_id);
ALTER TABLE bets
    ADD CONSTRAINT bets_fk1 FOREIGN KEY (match_id) REFERENCES matches (match_id);
ALTER TABLE bets
    ADD CONSTRAINT bets_fk2 FOREIGN KEY (winner) REFERENCES teams (team_id);
