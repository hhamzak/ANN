package blog.hasanhamza;

public class App 
{
    public static void main( String[] args )
    {
        double[] weights =  new double[] {1,2};
        double threshold = 1;
        double learningRate = 0.5;

        double[][] learningInputSet = {{1,0},{0,1}};
        int[] learningOutputSet =  {1,0};
        Perceptron p = new Perceptron(
                learningInputSet,
                learningOutputSet,
                weights,
                threshold,
                learningRate
        );

        p.Learn();

        // p.Predict();
    }
}
