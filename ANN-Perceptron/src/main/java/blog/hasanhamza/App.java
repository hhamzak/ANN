package blog.hasanhamza;

public class App 
{
    public static void main( String[] args )
    {
        // initial weights
        double[] weights =  new double[] {1,2};

        // neuron variables: threshold and learning rate
        double threshold = -1;
        double learningRate = 0.5;

        // learning set, 2 dimensions
        double[][] learningInputSet = {{1,0},{0,1}};
        int[] learningOutputSet =  {1,0};

        // init algorithm
        Perceptron p = new Perceptron(
                learningInputSet,
                learningOutputSet,
                weights,
                threshold,
                learningRate
        );

        // learning stage
        p.Learn();

        // test inputs, 2 dimensions
        double[][] testInputSet = {{1,1}, {0,0}, {2,1}, {1,2}};

        // test stage
        for (double[] test: testInputSet) {
            System.out.println("Test input - X1: " + test[0] + " - X2: " + test[1]);
            System.out.println("Test output: " + p.Predict(test));
        }
    }
}
