import java.util.LinkedList;
import java.util.List;

/**
 * Class of data sets
 */

public class DataSet {


    private List<double[]> inputValues=new LinkedList<>();;
    private List<double[]> outputValues=new LinkedList<>();;

    private int inputSize;
    private int outputSize;

    public DataSet(int inputSize,int outputSize) {
        this.inputSize=inputSize;
        this.outputSize=outputSize;
    }

    public void add(double[] input, double[] output){
        inputValues.add(input);
        outputValues.add(output);
    }

    public int getInputSize() {
        return inputSize;
    }

    public int getOutputSize() {
        return outputSize;
    }

    public List<double[]> getInputValues() {
        return inputValues;
    }

    public List<double[]> getOutputValues() {
        return outputValues;
    }

    public int getSize(){
        return inputValues.size();
    }
}
