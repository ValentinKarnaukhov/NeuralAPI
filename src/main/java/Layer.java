import java.util.List;

/**
 * Layer's interface
 */
public interface Layer {

    /**
     * @return reaction
     */
    double[] getOutput();

    /**
     * @param prevLayerOutput previous layer's outputs
     */
    void calculateReaction(double[] prevLayerOutput);

    /**
     * @return layer's size
     */
    int getSize();

    /**
     * @return nueron's list
      */
    List<Neuron> getNeurons();

    /**
     * @return errors
     */
    double[] getErrors();

}
