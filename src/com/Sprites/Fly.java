package com.Sprites;

import com.graphics.Animation;
/*
Creature(enemy) flies through the air
 */
public class Fly extends Creature {
    public Fly(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
        super(left, right, deadLeft, deadRight);
    }
    public float getMaxSpeed() {
        return 0.2f;
    }
    public boolean isFlying() {
        return isAlive();
    }
}
