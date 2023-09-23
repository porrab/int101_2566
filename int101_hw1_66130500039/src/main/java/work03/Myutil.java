package work03;
import static int101.homework01.Int101Homework01.*;

public class Myutil{
    public static void calculateBMI(double weight,double height){
        double result = weight / (height*height);
        System.out.println("Bmi = "+ result);
    }
    public static void average(int v1,int v2,int v3){
        double result = (v1+v2+v3)/3;
        System.out.println(result);
    }

}