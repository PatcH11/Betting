package ru.example.betting.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matches", schema = "public")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private Integer id;

    @ManyToOne(targetEntity = SportGame.class)
    @JoinColumn(name = "sport_game_id")
    private SportGame sportGame;

    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name = "team_home_id")
    private Team home;

    @ManyToOne(targetEntity = Team.class)
    @JoinColumn(name = "team_away_id")
    private Team away;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SportGame getSportGame() {
        return sportGame;
    }

    public void setSportGame(SportGame sportGame) {
        this.sportGame = sportGame;
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }
}
