import java.util.List;

/**
 * Input layer's class
 */
public class InputLayer implements Layer {

    private double[] output;

    public InputLayer(int size) {
        output=new double[size];
    }

    public void setInput(double[] values){
        if(values.length!=output.length)throw new IllegalArgumentException();
        output=values;
    }


    @Override
    public double[] getOutput() {
        return output;
    }

    @Override
    public void calculateReaction(double[] prevLayerOutput) {

    }

    @Override
    public int getSize() {
        return output.length;
    }

    @Override
    public List<Neuron> getNeurons() {
        return null;
    }

    @Override
    public double[] getErrors() {
        return null;
    }

}
