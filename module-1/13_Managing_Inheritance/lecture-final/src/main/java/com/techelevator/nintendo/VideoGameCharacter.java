package com.techelevator.nintendo;

public class VideoGameCharacter implements Runnable {

    private int points;
    private int life;
    private String name;

    public VideoGameCharacter(String name) {
        this.name = name;
        points = 0;
        life = 100;
    }

    public void run() {
        System.out.println("I'm running!");
    }

    public void jump() {
        System.out.println("Jump!");
    }

    public void shootFireball() {
        System.out.println("Fire!");
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    protected void doSecretMove() {
        System.out.println("Secret move!");
    }

}
