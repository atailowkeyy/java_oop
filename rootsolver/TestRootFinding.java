package hus.oop.rootsolver;

public class TestRootFinding {
    public static void main(String[] args) {
        /* TODO
        Chạy các hàm test để test chương trình.
        Lưu kết quả chạy chương trình vào file text có tên <TenSinhVien_MaSinhVien_RootSolver>.txt
        (ví dụ, NguyenVanA_123456_RootSolver.txt).
        Nén tất cả các file source code và file kết quả chạy chương trình vào file zip có tên
        <TenSinhVien_MaSinhVien_RootSolver>.zip (ví dụ, NguyenVanA_123456_RootSolver.txt), và nộp bài
        lên classroom.
        */
        testRootSolver();
    }

    public static void testRootSolver() {
        /* TODO
         - Viết chương trình tìm nghiệm của hàm (sin(x).x - 3) theo các phương pháp đã cho (Bisection, Newton-Raphson, Secant) sử dụng
           UnivariateRealRootFinding. Các phương pháp tìm nghiệm có thể thay đổi ở thời gian chạy chương trình.
         - In ra phương pháp sử dụng, hàm và nghiệm tìm được trong khoảng [a, b] đã cho.
         */
        AbstractFunction function = new UnivariateRealFunction();
        UnivariateRealRootFinding bisection = new UnivariateRealRootFinding(function, new BisectionSolver(1e-9, 100));
        UnivariateRealRootFinding newton = new UnivariateRealRootFinding(function, new NewtonRaphsonSolver(1e-9, 100));
        UnivariateRealRootFinding secant = new UnivariateRealRootFinding(function, new SecantSolver(1e-9, 100));
        System.out.println("Nghiệm của sin(x) * x - 3 trong [12,15] là: ");
        System.out.println("sử dụng phương pháp bisection: " + bisection.solve(12, 14));
        System.out.println("sử dụng phương pháp newton: " + newton.solve(12, 14));
        System.out.println("sử dụng phương pháp secant: " + secant.solve(12, 14));
    }
}
