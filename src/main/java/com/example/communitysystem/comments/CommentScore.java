package com.example.communitysystem.comments;

import javax.persistence.*;

@Entity
public class CommentScore {

    private static final Integer ZERO = 0;
    private static final Integer HIDDEN_THRESHOLD_VALUE = -100;

    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    private Comment comment;

    private Integer scoreValue = ZERO;

    // most likely use SQL queries instead of version
    @Version
    private Long version;

    // field used to hide comment when the comment's score gets too low
    // (although clients can access it by clicking on them)
    private Boolean isHiddenByDefault;

    public void incrementScore() { scoreValue++; }
    public void decrementScore() { scoreValue--; }
    public boolean shouldBeHidden() { return this.scoreValue <= HIDDEN_THRESHOLD_VALUE; }
}
