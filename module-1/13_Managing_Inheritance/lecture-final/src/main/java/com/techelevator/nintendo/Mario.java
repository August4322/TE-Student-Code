package com.techelevator.nintendo;

public class Mario extends VideoGameCharacter{

    private boolean flower;

    public Mario() {
        super("Mario");

    }

    public boolean hasFlower() {
        return flower;
    }

    public void setFlower(boolean flower) {
        this.flower = flower;
    }

    @Override
    public void shootFireball() {

        if(flower) {
            super.shootFireball();
        }
    }


    public void run(boolean useOriginal) {
        if(useOriginal) {
            super.run();
        } else {
            System.out.println("It's a me a mario and I'm a running!");
        }

    }

    public void genericRun() {
        super.run();
    }

    public int onDamage() {
        int life = getLife();
        life = life - 10;
        setLife(life);

        return life;
    }

    @Override
    public String toString() {
        return "It's a me a mario!";
    }

}
