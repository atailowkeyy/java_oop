package hus.oop.rootsolver;

public class NewtonRaphsonSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public NewtonRaphsonSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến sử dụng phương pháp Newton-Raphson.
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm.
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double x0 = (lower + upper) / 2;
        double epsilon = 1e-9;
        for(int i = 0; i < maxIterations; i++){
            double fx = function.evaluate(x0);
            double fxx = function.derivative(x0);
            if(Math.abs(fxx) < epsilon){
                break;
            }
            double x1 = x0 - fx/ fxx;
            if(Math.abs(x1 - x0) <= tolerance){
                return x1;
            }
            x0= x1;
        }
        throw new RuntimeException("không hội tụ");
    }
}
