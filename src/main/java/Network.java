import java.util.List;

/**
 * network's class
 */
public class Network {

    private List<Layer> layers;

    private double speed=0.2;

    public Network(List<Layer> layers) {

        this.layers=layers;

        for(int i=1;i<layers.size();i++){
            for(int j=0;j<layers.get(i).getOutput().length;j++){
                layers.get(i).getNeurons().add(new StdNeuron(layers.get(i-1).getSize()));
            }
        }

    }


    public void setInput(double[] input){

        ((InputLayer)layers.get(0)).setInput(input);
    }


    public void calculate(){

        for(int i=1;i<layers.size();i++){
            layers.get(i).calculateReaction(layers.get(i-1).getOutput());
        }
    }

    public double[] getOutput(){

        return layers.get(layers.size()-1).getOutput();
    }

    public List<Layer> getLayers(){
        return layers;
    }


    public void learn(DataSet dataSet){

        if(dataSet.getInputSize()!=getLayers().get(0).getSize()||
                dataSet.getOutputSize()!=getLayers().get(layers.size()-1).getSize()) throw new IllegalArgumentException();



        for(int i=0;i<dataSet.getSize();i++){
            setInput(dataSet.getInputValues().get(i));
            calculate();

            double[] targetValues=dataSet.getOutputValues().get(i);
            double[] realValues=getOutput();

            for(int k=0;k<realValues.length;k++){
                Neuron currNeuron=layers.get(layers.size()-1).getNeurons().get(k);
                currNeuron.setError((targetValues[k]-realValues[k]));
            }



            for(int k=layers.size()-1;k>0;k--){
                if(k>1) ((HiddenLayer)layers.get(k-1)).setErrors(layers.get(k).getErrors());
                double[] outputPrevLay=layers.get(k-1).getOutput();
                for(Neuron n:layers.get(k).getNeurons()){
                    double[] newWights=new double[outputPrevLay.length];
                    for(int r=0;r<n.getWeights().length;r++){
                        newWights[r]=n.getWeights()[r]+n.getError()*speed*outputPrevLay[r];
                    }
                    n.setWeights(newWights);
                }
            }

        }

    }

    public void setSpeedLearn(double speed){
        this.speed=speed;
    }

    public double getSpeedLearn(){
        return speed;
    }




}
