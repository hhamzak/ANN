package blog.hasanhamza;

public class Neuron {

    double[] weights;
    double threshold;
    double learningRate;

    public Neuron(double[] weights, double threshold, double learningRate){
        this.weights = weights;
        // random ya da normal set et
        this.threshold = threshold;
        this.learningRate = learningRate;
    }

    public int getOutput(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i]*weights[i];
        }

        // activation function
        if (sum >= threshold) {
            return 1;
        }
        return 0;
    }

    public double getWeight(int i) {
        return weights[i];
    }

    public void updateWeights(int direction, double[] inputs){
        // direction variable determines whether learning will occur by increasing or decreasing the weights

        if (weights.length != inputs.length){
            System.err.println("Weights and inputs length are different!");
            return;
        }
        for (int i = 0; i < weights.length; i++) {
            System.out.print("    Weight " + i + " was: " + weights[i]);
            weights[i] = weights[i] + direction*learningRate*inputs[i];
            System.out.println(" - new value is: " + weights[i]);
        }
    }
}
