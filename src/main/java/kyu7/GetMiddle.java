package kyu7;

public class GetMiddle {
    //7 https://www.codewars.com/kata/56747fd5cb988479af000028/train/java
    public static void main(String[] args) {
        System.out.println(getMiddle("test"));//es
        System.out.println(getMiddle("middle"));//dd
        System.out.println(getMiddle("midle"));//d
    }
    public static String getMiddle(String word) {
        int i = word.length() / 2;
        if (word.length()%2==0){
            return word.substring(i-1, i+1);
        }else{
            return word.substring(i, i+1);
        }
    }
}
