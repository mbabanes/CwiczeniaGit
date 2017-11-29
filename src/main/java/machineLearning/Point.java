package machineLearning;

import java.util.Random;

public class Point
{
    private final static Random RAND = new Random();

    float x;
    float y;
    int label;

    public Point()
    {
        x = RAND.nextFloat();
        y = RAND.nextFloat();

        if (y > x)
            label = 1;
        else
            label = -1;
    }

    @Override
    public String toString()
    {
        return "{" +
                "x=" + x +
                ", y=" + y +
                ", label=" + label +
                '}';
    }
}
