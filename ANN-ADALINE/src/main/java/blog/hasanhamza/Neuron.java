package blog.hasanhamza;

import javax.sound.midi.Soundbank;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Neuron {

    double[] weights;
    double threshold;
    double learningRate;

    public Neuron(double[] weights, double threshold, double learningRate){
        this.weights = weights;
        this.threshold = threshold;
        this.learningRate = learningRate;
    }

    public int getOutput(double[] inputs) {
        double sum = 0;
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i]*weights[i];
        }
        sum += threshold;
        System.out.println("    Sum: " + sum);

        if (sum >= 0) {
            return 1;
        }
        return -1;
    }

    public double getWeight(int i) {
        return weights[i];
    }

    public void updateWeights(int e, double[] inputs){
        // e = ExpectedValue - ActualValue
        if (weights.length != inputs.length){
            System.err.println("Weights and inputs length are different!");
            return;
        }
        for (int i = 0; i < weights.length; i++) {
            System.out.println("    Weight " + i + ":               " + weights[i]);
            weights[i] = weights[i] + e * learningRate * inputs[i];
            System.out.println("    Weight " + i + " changed as:    " + weights[i]);
        }

        // update threshold
        System.out.print("    Old threshold: " + threshold);
        threshold = threshold + learningRate * e;

        BigDecimal bd = new BigDecimal(threshold).setScale(2, RoundingMode.HALF_UP);
        threshold = bd.doubleValue();
        System.out.println("  - updated as: " + threshold);
    }
}
