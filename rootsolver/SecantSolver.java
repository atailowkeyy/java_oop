package hus.oop.rootsolver;

public class SecantSolver implements RootSolver {
    private double tolerance;
    private int maxIterations;

    /**
     * Khởi tạo giá trị các tham số.
     * @param tolerance
     * @param maxIterations
     */
    public SecantSolver(double tolerance, int maxIterations) {
        /* TODO */
        this.tolerance = tolerance;
        this.maxIterations = maxIterations;
    }

    /**
     * Tìm nghiệm của hàm một biến theo phương pháp Secant
     * @param function
     * @param lower
     * @param upper
     * @return nghiệm của hàm trong đoạn [lower, upper]
     */
    @Override
    public double solve(AbstractFunction function, double lower, double upper) {
        /* TODO */
        double epsilon = 1e-9;
        for(int i = 0; i < maxIterations; i++){
            double x1 = function.evaluate(upper);
            double x0 = function.evaluate(lower);
            if(Math.abs(x1 - x0) < epsilon){
                throw new RuntimeException("khong the tiep tuc duoc nua vi mau so xap xi = 0");
            }
            double x = upper - x1 * (upper - lower) / (x1 - x0);
            if(Math.abs(x - upper) < tolerance){
                return x;
            }
            lower = upper;
            upper = x;
        }
        throw new RuntimeException("pt không hội tụ");
    }
}
