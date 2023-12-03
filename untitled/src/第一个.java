import java.awt.*;
import java.util.Scanner;

public class 第一个 {
    public static void main(String[] args){
        int a=1;
        double b=1.1;
        int c=(int)(a+b);
        double CC=a+b;
        double d=a+b;
        System.out.println(c);
        System.out.println(CC);
        System.out.println(c);
        int num=+10;
        int num2=num +4;
        String var ="num2=";
        System.out.println(var +num2);
        System.out.println("我的年龄是"+20);
        System.out.println(num/6);
        System.out.println(100.0/30);
        System.out.println(num/6);
        System.out.println(num/6.0);
        System.out.println(num%3);
        int m=10,n=100,s=10,k=1;
        k++;
        m=n++;//从左向右看先看到n所以值不变但n为101
        s=++n;
        System.out.println(k);
        System.out.println(m);
        System.out.println(n);
        System.out.println(s);
        int z=10,x=100,w=3;
        z=++x%w+x++%z;
        System.out.println("z="+z);
        System.out.println("x="+x);//字符串
        int q=10,e=1;
        q++;
        e=q;
        System.out.println(e);
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个整数");
        float g =sc.nextFloat();
        System.out.println(g);

    }
}
