/**
 * Interface of Activation Functions
 */
public interface ActivationFunction {
    /** calculate result from value
     * @param result input value
     * @return activated result
     */
    double getResult(double result);

    /**
     * @param result value
     * @return derivatives value
     */
    double getDerResult(double result);

}
