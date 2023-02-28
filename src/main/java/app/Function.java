package app;

public interface Function {
    public double getIntegral(double a, double b, Function function);
    public default double functionDefault(double a) {
        return Math.pow(a, 2);
    }
}
