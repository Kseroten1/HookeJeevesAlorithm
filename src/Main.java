import java.util.Arrays;

public class Main {

    public static double function(double[] x){
        return Math.pow(x[0],5)+ Math.pow(x[1],3)*Math.pow(x[2],3) - Math.pow(x[3],2)*x[4];
    }
    static double e = 0.02;

    public static double[] stepTry(double[] x) {
        for(int i = 0; i < x.length; i++){
            double currentValue = function(x);
            double k = 1.75;
            while(k > e){
                x[i] += k;
                if(function(x) < currentValue){
                    break;
                }else {
                    x[i] -= k;
                    x[i] -= k;
                    if(function(x) < currentValue){
                        break;
                    }else{
                        x[i] += k;
                        k = k*0.8;
                    }
                }
            }
        }
        return x;
    }

    public static double[] stepNormal(double[] x){
        double v = 1.75;
        double firstValue = function(x);
        while(v < e) {
            for(int i = 0; i < 5; i++){
                x[i] *= v;
            }
            if(function(x) < firstValue){
                break;
            }else{
                for(int i = 0; i < 4; i++){
                    x[i] /= v;
                }
                v *= 0.8;
            }
        }
        return x;
    }

    public static double[] x = {1, 1, 1, 1, 1};

    public static void main(String[] args) {

        double[] x1 ;
        do {
            x1 = x;
            stepTry(x1);
            stepNormal(x1);
        } while (!Arrays.equals(x1, x));
        for(int i = 0; i < 5 ; i++){
            System.out.print(" ");
            System.out.print(x[i]);
            System.out.println("");
        }
        System.out.println(function(x));
    }
}