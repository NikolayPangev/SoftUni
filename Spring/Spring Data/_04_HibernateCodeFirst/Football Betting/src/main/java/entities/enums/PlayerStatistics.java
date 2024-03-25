package entities.enums;

import entities.Game;
import entities.Player;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table
public class PlayerStatistics implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn
    private Game game;

    @ManyToOne
    @JoinColumn
    private Player player;

    @Column
    private Short playerAssists;

    @Column
    private Short scoredGoals;

    @Column
    private Short playedMinutes;

}
