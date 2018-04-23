/**
 * Sigmoid Function
 */
public class SigmoidFunction implements ActivationFunction{

    @Override
    public double getResult(double result) {
        return 1/(1+Math.exp(-result));
    }

    @Override
    public double getDerResult(double result) {
        return getResult(result)*(1-getResult(result));
    }
}
