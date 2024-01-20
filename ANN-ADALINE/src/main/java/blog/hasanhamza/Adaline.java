package blog.hasanhamza;

public class Adaline {
    private Neuron neuron;
    private double[][] learningSetInputs;
    private int[] learningSetOutputs;

    public Adaline(double[][] learningSetInput, int[] learningSetOutput, double[] weights, double threshold, double learningRate) {
        neuron = new Neuron(
                weights,
                threshold,
                learningRate
        );

        this.learningSetInputs = learningSetInput;
        this.learningSetOutputs = learningSetOutput;
    }

    public void Learn(){
        boolean isLearningEnd = false;
        int learningCounter = 0;
        int learningLimit = 15;
        boolean isWeightChanged = false;

        while (!isLearningEnd && learningCounter < learningLimit)
        {
            isWeightChanged = false;
            for (int i = 0; i < learningSetOutputs.length; i++) {
                System.out.println("Iteration: " + learningCounter + ", Sample: " + i +
                        " Inputs X1: " + learningSetInputs[i][0] +
                        " - Inputs X2: " + learningSetInputs[i][1]);
                int result = neuron.getOutput(learningSetInputs[i]);

                System.out.println("    Expected OutPut: " + learningSetOutputs[i] +
                        " - Neuron Output: " + result);

                int E = learningSetOutputs[i] - result;
                // learning rules
                if (E != 0) {
                    isWeightChanged = true;
                    neuron.updateWeights(E,learningSetInputs[i]);
                }
            }
            if (!isWeightChanged){
                isLearningEnd = true;
            }
            learningCounter++;
        }
    }

    public int Predict(double[] testInput) {
        return neuron.getOutput(testInput);
    }
}
