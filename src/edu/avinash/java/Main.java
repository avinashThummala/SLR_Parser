package edu.avinash.java;

public class Main{
    public static void main(String[] args){
        Parser myParser = new Parser(args[0]);
        myParser.parse();
    }
}