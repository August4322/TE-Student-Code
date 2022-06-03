package com.techelevator;

public class Scratch {

    public int countCats(String[] pets) {

        int counter = 0;

        //YOUR CODE HERE
        /*
        for(String pet : pets) {
            if(pet.toLowerCase().equals("cat")) {
                counter++;
            }
        } */

        for(int i=0; i < pets.length; i++) {
            if(pets[i].equals("cat")) {
                counter++;
            }
        }




        return counter;
    }

    public static void main(String[] args) {

        RectangleBlock block = new RectangleBlock("Rectangle",3,3,4);
        String myName = "Christopher";
        System.out.println(block);

     /*   RectangleBlock block = new RectangleBlock("Rectangle",3,3,4);
        Cube cube = new Cube(3);
        cube.getVolume();

        Scratch s = new Scratch();

        String[] pets = {"dog", "dog", "cat", "cat", "ferret", "cat"};
        int totalCats = s.countCats(pets);
        System.out.println("Total cats: " + totalCats); */

    }
}
