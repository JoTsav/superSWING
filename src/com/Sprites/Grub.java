package com.Sprites;

import com.graphics.Animation;

/*
Creature moving slowly on the ground
 */
public class Grub extends Creature  {
    public Grub(Animation left, Animation right, Animation deadLeft, Animation deadRight) {
        super(left, right, deadLeft, deadRight);
    }
    public float getMaxSpeed() {
        return 0.05f;
    }
}
