public class GetXO {
    public static void main(String[] args) {

        System.out.println(getXO("XxxooO"));
    }

    public static boolean getXO(String str) {

        int xCount = counterStr(str, "x");
        int yCount = counterStr(str, "o");
        return xCount == yCount;

    }
    public static int counterStr(String str, String target) {

        int result = 0;
        for (char element : str.toLowerCase().toCharArray()){
            if (element == target.toLowerCase().toCharArray()[0]) result++;
        }
        return result;
    }
}
