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

        if (sum >= threshold) {
            return 1;
        }
        return 0;
    }

    public double getWeight(int i) {
        return weights[i];
    }

    public void updateWeights(int direction, double[] inputs){
        // up or down
        if (weights.length != inputs.length){
            System.err.println("Weights and inputs length are different!");
            return;
        }
        for (int i = 0; i < weights.length; i++) {
            System.out.println("Weight " + i + ":               " + weights[i]);
            weights[i] = weights[i] + direction*learningRate*inputs[i];
            System.out.println("Weight " + i + " changed as:    " + weights[i]);
        }
    }
}
