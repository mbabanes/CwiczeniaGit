package machineLearning;

import java.math.BigDecimal;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Perceptron perceptron = new Perceptron();


        Point [] leariningPoints = new Point[100000];
        for (int i = 0; i < leariningPoints.length; i++)
        {
            leariningPoints[i] = new Point();
        }



        Point[] points = new Point[1000];
        for (int i = 0; i < points.length; i++)
        {
            points[i] = new Point();
        }

        int positive = 0;
        int negative = 0;
        for(Point p : points)
        {
            float [] inputs = {p.x, p.y};
            int guess = perceptron.guess(inputs);
            if (guess == p.label)
                positive++;
            else
                negative++;

        }
        System.out.println("Przed uczeniem");
        System.out.println("Poprawnie: " + positive);
        System.out.println("Zle: " + negative);


        for(Point p : leariningPoints)
        {
            float [] inputs = {p.x, p.y};
            perceptron.train(inputs, p.label);
        }



        positive = 0;
        negative = 0;
        for(Point p : points)
        {
            float [] inputs = {p.x, p.y};
            int guess = perceptron.guess(inputs);
            if (guess == p.label)
                positive++;
            else
                negative++;

        }
        System.out.println("\nPo nauczeniu");
        System.out.println("Poprawnie: " + positive);
        System.out.println("Zle: " + negative);
    }
}
