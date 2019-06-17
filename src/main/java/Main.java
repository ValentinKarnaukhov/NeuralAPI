import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {

    /**
     * Start program
     *
     * @param args
     */
    public static void main(String[] args) {

        List<Layer> layerList=new LinkedList<>();

        Layer inputLayer=new InputLayer(2);

        Layer outputLayer=new HiddenLayer(1);

        layerList.add(inputLayer);
        layerList.add(new HiddenLayer(4));
        layerList.add(new HiddenLayer(4));
        layerList.add(outputLayer);


        Network network=new Network(layerList);


        DataSet trainingSet=new DataSet(2,1);
        /*
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                trainingSet.add(new double[]{i,j},new double[]{i+j});
            }
        }
        */

        trainingSet.add(new double[]{0,0},new double[]{0});
        trainingSet.add(new double[]{0,1},new double[]{1});
        trainingSet.add(new double[]{1,0},new double[]{1});
        trainingSet.add(new double[]{1,1},new double[]{0});


        for(int i=0;i<1000000;i++){
            network.learn(trainingSet);
        }

        double[] testInput1=new double[]{0,0};
        double[] testInput2=new double[]{0,1};
        double[] testInput3=new double[]{1,0};
        double[] testInput4=new double[]{1,1};


        network.setInput(testInput1);
        network.calculate();
        System.out.println(Arrays.toString(network.getOutput()));

        network.setInput(testInput2);
        network.calculate();
        System.out.println(Arrays.toString(network.getOutput()));

        network.setInput(testInput3);
        network.calculate();
        System.out.println(Arrays.toString(network.getOutput()));

        network.setInput(testInput4);
        network.calculate();
        System.out.println(Arrays.toString(network.getOutput()));


    }


}
