import java.util.function.BiFunction;

public class FunctionTest {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Double> add = (a, b)-> Double.valueOf(a+b);
        BiFunction<Integer,Integer,Double> sub = (a, b)-> Double.valueOf(a-b);
        BiFunction<Integer,Integer,Double> mul = (a, b)-> Double.valueOf(a*b);
        BiFunction<Integer,Integer,Double> div = (a, b)-> Double.valueOf(a/b);

        System.out.println(operation(5,6,add));
        System.out.println(operation(5,6,sub));
        System.out.println(operation(5,6,mul));
        System.out.println(operation(30,6,div));
    }

    private static Double operation(int a,int b,BiFunction<Integer,Integer,Double> func){
        return func.apply(a,b);
    }
}
