package machineLearning;

import java.util.Arrays;
import java.util.Random;

public class Perceptron
{
    private float[] weights = new float[2];
    private float learingRate = 0.1f;

    public Perceptron()
    {
        Random random = new Random();
        for (int i = 0; i < weights.length; i++)
        {
            weights[i] = random.nextFloat() * (random.nextBoolean() ? -1.0f : 1.0f);
        }
    }

    private int sign(double x)
    {
        return (x >= 0) ? 1 : -1;
    }

    private double activationFunction(double x)
    {
        return sigmoid(x);
    }

    private double sigmoid(double x)
    {
        return ( 1 / ( 1 + Math.pow(Math.E, x) ) );
    }

    public int guess(float[] inputs)
    {
        float sum = 0;
        for (int i = 0; i < inputs.length; i++)
        {
            sum += weights[i] * inputs[i];
        }

        return sign(sum);
    }

    public void train(float[] inputs, int target)
    {
        int guess = guess(inputs);
        int error = target - guess;

        for (int i = 0; i < weights.length; i++)
        {
            weights[i] += error * inputs[i] * learingRate;
        }
//        System.out.println("Weights: " + Arrays.toString(weights));
    }
}
