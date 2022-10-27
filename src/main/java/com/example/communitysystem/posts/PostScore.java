package com.example.communitysystem.posts;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostScore {

    private static final Integer ZERO = 0;
    private static final Integer HIDDEN_THRESHOLD_VALUE = -100;

    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    private Post post;

    private Integer scoreValue = ZERO;

    // most likely use SQL queries instead of version
    @Version
    private Long version;

    // field used to hide posts when the post's score gets too low
    // (although clients can access them by clicking on them)
    private Boolean isHiddenByDefault;

    public void incrementScore() {
        scoreValue++;
    }

    public void decrementScore() {
        scoreValue--;
    }

    public boolean shouldBeHidden() {
        return this.scoreValue <= HIDDEN_THRESHOLD_VALUE;
    }

}
