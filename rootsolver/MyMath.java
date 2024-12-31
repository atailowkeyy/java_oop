package hus.oop.rootsolver;

public class MyMath {
    public static double sin(double x) {
        /* TODO */
        double sum = 0.0;
        double temp = 1.0;
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 1){
                temp =  temp * x/i;
                sum += temp;
            }else{
                temp = -1 * temp * x/i;
            }
        }
        return sum;
    }

    public static double cos(double x) {
        /* TODO */
        double sum = 1.0;
        double temp = 1.0;
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 0){
                temp = -1 *  temp * x/i;
                sum += temp;
            }else{
                temp = temp * x/i;
            }
        }
        return sum;
    }

    public double exp(double x) {
        /* TODO */
        double sum = 1.0;
        double temp = 1.0;
        for(int i = 1; i <= 100; i++){
            temp = temp * x/i;
            sum += temp;
        }
        return sum;
    }

    public double ln(double x) {
        /* TODO */
        double sum = 0.0;
        double temp = 1.0;
        for(int i = 1; i <= 100; i++){
            if(i % 2 == 1){
                temp = temp * x/i;
            }else{
                temp = -1 * temp * x/i;
            }
            sum += temp;
        }
        return sum;
    }
}
