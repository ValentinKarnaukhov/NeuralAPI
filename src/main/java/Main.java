import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) {

        List<Layer> layerList=new LinkedList<>();

        Layer inputLayer=new InputLayer(1);

        Layer outputLayer=new HiddenLayer(1);

        layerList.add(inputLayer);
        layerList.add(new HiddenLayer(4));
        layerList.add(outputLayer);


        Network network=new Network(layerList);


        DataSet trainingSet=new DataSet(1,1);
        /*
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                trainingSet.add(new double[]{i,j},new double[]{i+j});
            }
        }
        */

        trainingSet.add(new double[]{0.1},new double[]{0.1});
        trainingSet.add(new double[]{0.2},new double[]{0.2});
        trainingSet.add(new double[]{0.3},new double[]{0.3});
        trainingSet.add(new double[]{0.4},new double[]{0.4});
        trainingSet.add(new double[]{0.5},new double[]{0.5});


        for(int i=0;i<1000000;i++){
            network.learn(trainingSet);
        }

        double[] testInput1=new double[]{0.15};
        double[] testInput2=new double[]{0.25};
        double[] testInput3=new double[]{0.35};
        double[] testInput4=new double[]{0.45};
        double[] testInput5=new double[]{0.55};
        double[] testInput6=new double[]{0.65};


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

        network.setInput(testInput5);
        network.calculate();
        System.out.println(Arrays.toString(network.getOutput()));

        network.setInput(testInput6);
        network.calculate();
        System.out.println(Arrays.toString(network.getOutput()));

    }


}
