package com.aditya.files.medium;

import java.io.PipedOutputStream;
import java.util.LinkedList;

public class DesignSnakeGame_353 {

    class Position{
        int x;
        int y;


        public Position(int x, int y){
            this.x=x;
            this.y=y;
        }

        public boolean isEqual(Position p){
            return this.x==p.x && this.y == p.y ;
        }
    }

    int len;
    int height;
    int width;
    int[][] food;
    LinkedList<Position> snake;
    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame_353(int width, int height, int[][] food) {

        this.food=food;
        this.width=width;
        this.height=height;
        snake= new LinkedList<Position>();
        snake.add(new Position(0,0));

        len=0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        Position current = new Position(snake.get(0).x, snake.get(0).y);

        switch (direction){
            case "U":
                current.x--;
                break;
            case "L":
                current.y--;
                break;
            case "R":
                current.y++;
                break;
            case "D":
                current.x++;
                break;
        }

        //check if snake is out of bounds:
        if(current.x>=width || current.x<0 || current.y>=height || current.y<0){
            return -1;
        }

        //check if snake collides with itself:
        for(int i=1;i<snake.size();i++){
            Position next = snake.get(i);
            if(next.equals(current))    return -1;
        }
        snake.addFirst(current);
        if(len<food.length){
            Position p = new Position(food[len][0],food[len][1]);
            if(current.isEqual(p)){
                len++;
            }
        }
        while(snake.size()>len+1) snake.removeLast();

        return len;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */