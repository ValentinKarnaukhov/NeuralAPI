/**
 * neuron class
 */
public class StdNeuron implements Neuron{

    private double[] wights;

    private double error;

    private double inputValue=0;

    private double nonActivatedOutput=0;

    private double activatedOutput=0;

    private ActivationFunction activationFunction=new SigmoidFunction();

    public StdNeuron(int prevLaySize) {

        wights=new double[prevLaySize];
        for(int i=0;i<prevLaySize;i++){
            wights[i]=Math.random()/10;
        }

    }

    @Override
    public double getNonActivatedOutput() {
        return nonActivatedOutput;
    }

    @Override
    public double getActivatedOutput() {
        return activatedOutput;
    }

    @Override
    public void setError(double error) {
        this.error=error*activationFunction.getDerResult(inputValue);
    }

    @Override
    public double getError() {
        return error;
    }

    @Override
    public void calculateOutput(double[] prevOutputs) {
        nonActivatedOutput=0;
        for(int i=0;i<prevOutputs.length;i++){
            nonActivatedOutput+=wights[i]*prevOutputs[i];
        }
        inputValue=nonActivatedOutput;
        activatedOutput=activationFunction.getResult(nonActivatedOutput);
    }

    @Override
    public double[] getWeights() {
        return wights;
    }

    @Override
    public void setActivationFunction(ActivationFunction function) {
        this.activationFunction=function;
    }

    @Override
    public void setWeights(double[] weights) {
        this.wights=weights;
    }

    @Override
    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    @Override
    public double getInput() {
        return inputValue;
    }


}
