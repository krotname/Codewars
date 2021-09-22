package kyu7;

public class TriangleTester {
    //7 https://www.codewars.com/kata/56606694ec01347ce800001b/train/java
    public static void main(String[] args) {
        System.out.println(isTriangle(-5,-6,-2));
        System.out.println(isTriangle(5,6,2));
    }
    public static boolean isTriangle(int a, int b, int c){
        return  a>0 && b>0 && c>0 && a+b>c && a+c>b && b+c>a;
    }
}
