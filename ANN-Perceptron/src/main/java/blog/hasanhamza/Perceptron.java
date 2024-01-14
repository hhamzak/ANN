package blog.hasanhamza;

public class Perceptron {
    private Neuron neuron;
    private double[][] learningSetInputs;
    private int[] learningSetOutputs;
    public Perceptron(double[][] learningSetInput, int[] learningSetOutput, double[] weights, double threshold, double learningRate) {
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
                int result = neuron.getOutput(learningSetInputs[i]);

                System.out.println("Iteration: " + learningCounter + " - Sample: " + i +
                        " - Inputs X1: " + learningSetInputs[i][0] +
                        " - Inputs X2: " + learningSetInputs[i][1]  +
                        " - Expected OutPut: " + learningSetOutputs[i] +
                        " - Neuron Output: " + result);
                if (result != learningSetOutputs[i]) {
                    isWeightChanged = true;
                    int weightDirection = 1;
                    if (result > learningSetOutputs[i]){
                        weightDirection = -1;
                    }
                    neuron.updateWeights(weightDirection,learningSetInputs[i]);
                }
            }
            if (!isWeightChanged){
                isLearningEnd = true;
            }
            learningCounter++;
        }

    }

}
