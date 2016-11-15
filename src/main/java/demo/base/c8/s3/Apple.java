package demo.base.c8.s3;


public class Apple<T extends Number> {

    T col;

    public Apple(){}

    public Apple(T col){this.col=col;}

    public void getInfo(){
        System.out.println(col.getClass());
    }

    public static void main(String[] args) {
        Apple<Integer> ai = new Apple<>(9);
        Apple<Double> ad = new Apple<>(2D);
        ai.getInfo();
        ad.getInfo();

        // 下面代码将引起编译异常，下面代码试图把String类型传给T形参
        // 但String不是Number的子类型，所以引发编译错误
//        Apple<String> as = new Apple<>();        // ①
    }
}
