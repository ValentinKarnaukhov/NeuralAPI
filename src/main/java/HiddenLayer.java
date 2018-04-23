import java.util.LinkedList;
import java.util.List;

/**
 * Class of hidden layer
 */
public class HiddenLayer implements Layer{

    private List<Neuron> neurons;

    private double[] reaction;

    private double[] nextErrors;

    public HiddenLayer(int size) {

        neurons=new LinkedList<>();

        reaction=new double[size];

    }

    public void setErrors(double[] errors){

        if(errors.length!=neurons.size())throw new IllegalArgumentException();

        for(int i=0;i<errors.length;i++){
            neurons.get(i).setError(errors[i]);
        }

    }

    @Override
    public double[] getOutput() {
        return reaction;
    }

    @Override
    public void calculateReaction(double[] prevLayerOutput) {

        for (Neuron neuron : neurons) {
            neuron.calculateOutput(prevLayerOutput);
        }

        for(int i=0;i<neurons.size();i++){
            reaction[i]=neurons.get(i).getActivatedOutput();
        }

    }

    @Override
    public int getSize() {
        return neurons.size();
    }

    @Override
    public List<Neuron> getNeurons() {
        return neurons;
    }

    @Override
    public double[] getErrors() {

        nextErrors=new double[neurons.get(0).getWeights().length];
        for(Neuron neuron:neurons){
            for(int i=0;i<nextErrors.length;i++){
                nextErrors[i]+=neuron.getWeights()[i]*neuron.getError();
            }
        }
        return nextErrors;

    }
}
