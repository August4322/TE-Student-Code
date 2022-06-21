package com.techelevator;

public class Scratch {



    public int countCats(String[] pets) {

        int counter = 0;
        for(int i=0; i< pets.length; i++) {
            if(pets[i].equalsIgnoreCase("Cat")){
                counter++;
            }
        }

        return counter;
    }



    public static void main(String[] args) {

        Scratch test = new Scratch();
        String[] pets = {"Cat","Dog","Cat", "cat"};

        System.out.println(test.countCats(pets));

    }
}
