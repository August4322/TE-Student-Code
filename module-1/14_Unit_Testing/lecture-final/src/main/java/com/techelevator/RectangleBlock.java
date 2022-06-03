package com.techelevator;

public class RectangleBlock extends Shape {

    private int width;
    private int height;
    private int depth;
    private String name;

    public RectangleBlock(String name){
        this.name = name;
    }

    public RectangleBlock(String name, int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int getDepth(){
        return depth;
    }

    public final int getVolume() {
        return width * height * depth ;
    }

    @Override
    public String toString() {
        return name;
    }
}
