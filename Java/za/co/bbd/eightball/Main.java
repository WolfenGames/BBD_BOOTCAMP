package za.co.bbd.eightball;

import java.util.Random;

public class Main {
    public static void main(String[] args) 
    {
        Options options = new Options();
        Random x = new Random();
        for (String var : args) {
            System.out.print(var);
            System.out.println(" response -> " + options.getString(x.nextInt(options.GetLength())));
        }
    }
}