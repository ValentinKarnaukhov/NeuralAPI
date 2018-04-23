/**
 * Nueron's interface
 */
public interface Neuron {

    /**
     * @return nonActivated Output
     */
    double getNonActivatedOutput();

    /**
     * @return Activated Output
     */
    double getActivatedOutput();

    /**
     * set Error for backprop algorithm
     */
    void setError(double error);

    /**
     * @return Error for backprop algorithm
     */
    double getError();

    /**
     * @param prevOutputs previous layer's outputs
     */
    void calculateOutput(double [] prevOutputs);

    /**
     * @return weights to neuron
     */
    double[] getWeights();

    /**
     * @param function activation function
     */
    void setActivationFunction(ActivationFunction function);

    /**
     * @param weights new weights
     */
    void setWeights(double[] weights);

    /**
     * @return activation function
     */
    ActivationFunction getActivationFunction();

    /**
     * @return input value
     */
    double getInput();

}
