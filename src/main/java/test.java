import java.math.BigInteger;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        ArrayList<Character> characters = new ArrayList<>();
        characters.add('s');
        characters.get(2);
        BigInteger big = new BigInteger("0");
            BigInteger append = new BigInteger("1");
            while (big.toString().length() < 20){
                big = new BigInteger(big.toString() + append.toString());
                char c = append.toString().toCharArray()[append.toString().length()-1];
                int i = Integer.parseInt(String.valueOf(c))+1;
                append = new BigInteger(append.toString() + i);
            }
            System.out.println(big);


    }

}
