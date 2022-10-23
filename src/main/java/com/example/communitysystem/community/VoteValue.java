package com.example.communitysystem.community;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
class VoteValue {

    @Id
    private UUID ValueId;
    private Integer value;
    public static Integer SCORE_MAX = 1000;
    public static Integer SCORE_MIN = 100;

    public void incrementValue() throws Exception {
        if(this.value > SCORE_MAX) throw new Exception("TODO");

        this.value++;
    }

    public void decrementValue() throws Exception {
        if(this.value < SCORE_MIN) throw new Exception("TODO");

        this.value--;
    }
}
