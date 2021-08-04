import java.util.*;

public class VIN_Checker {
//6
/*
    In this Kata you should write a function to validate VINs, Vehicle Identification Numbers. Valid VINs are exactly 17 characters long, its composed of capital letters (except "I","O" and "Q") and digits. The 9th character is a MODULUS 11 check digit. Here is how it works:

            1. Letters are converted to numbers
    Following the table bellow, letters are converted to numbers. "I","O" and "Q" are invalid characters.

    A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
1 2 3 4 5 6 7 8   1 2 3 4 5   7   9 2 3 4 5 6 7 8 9
    Ex.: VIN 5YJ3E1EA7HF000337 becomes 58135151786000337.

            2. Each number is multiplied by a weight
    The weights are the following: [8,7,6,5,4,3,2,10,0,9,8,7,6,5,4,3,2].

    Ex.:
    VIN:     5   Y   J   3   E   1   E   A   7   H   F   0   0   0   3   3   7
    DECODED: 5   8   1   3   5   1   5   1   7   8   6   0   0   0   3   3   7
    WEIGHTS: 8   7   6   5   4   3   2   10  0   9   8   7   6   5   4   3   2
    PRODUCT: 40  56  6   15  20  3   10  10  0   72  48  0   0   0   12  9   14
            3. All products are summed up
    Ex.:
            40+56+6+15+20+3+10+10+0+72+48+0+0+0+12+9+14 = 315
            4. The modulus 11 of the sum is taken
    Ex.:
            315 mod 11 = 7
            5. Check 9th character
    If the 9th character matches the modulus 11, the VIN is valid.

    Ex.:
            5YJ3E1EA7HF000337 is a valid VIN, 9th character is 7
    Note
    If the modulus 11 of the sum is equal to 10, then the digit is "X".

    Ex.:
            5YJ3E1EAXHF000347 is a valid VIN.
            Input Validation
    Input validation is part of the Kata, VINs with lenghts different than 17 characters or containing invalid characters should return False as well.

*/

    public static void main(String[] args) {
        System.out.println(checkVin("3VN6WLZCXYF160649")); // false
        System.out.println(checkVin("5YJ3E1EA7HF000337")); // true
        System.out.println(checkVin("5YJ3E1EAXHF000347")); // true
        System.out.println(checkVin("5VGYMVUX7JV764512")); // true
        System.out.println(checkVin("7WDMMTDV9TG739741")); // false
        System.out.println(checkVin("7JTRH08L5EJ234829")); // false
        System.out.println(checkVin("7%^&H08L5EJ234829")); // false
    }

    public static boolean checkVin(String vin) {
        if (vin == null || vin.isEmpty() || vin.toUpperCase().contains("I") || vin.toUpperCase().contains("O")
                || vin.toUpperCase().contains("Q") || vin.length() != 17) return false;
        Map<Character, Integer> letters  = new HashMap<>();
        letters.put('A', 1);
        letters.put('B', 2);
        letters.put('C', 3);
        letters.put('D', 4);
        letters.put('E', 5);
        letters.put('F', 6);
        letters.put('G', 7);
        letters.put('H', 8);
        letters.put('J', 1);
        letters.put('K', 2);
        letters.put('L', 3);
        letters.put('M', 4);
        letters.put('N', 5);
        letters.put('P', 7);
        letters.put('R', 9);
        letters.put('S', 2);
        letters.put('T', 3);
        letters.put('U', 4);
        letters.put('V', 5);
        letters.put('W', 6);
        letters.put('X', 7);
        letters.put('Y', 8);
        letters.put('Z', 9);
        letters.put('1', 1);
        letters.put('2', 2);
        letters.put('3', 3);
        letters.put('4', 4);
        letters.put('5', 5);
        letters.put('6', 6);
        letters.put('7', 7);
        letters.put('8', 8);
        letters.put('9', 9);
        letters.put('0', 0);

        ArrayList<Integer> convertedToNumber = new ArrayList<>();
        char[] vinChars = vin.toUpperCase().toCharArray();
        for (Character c:vinChars
             ) {
            if (!letters.containsKey(c)) return false;
            convertedToNumber.add(letters.get(c));
        }
        List <Integer> multiplier =  Arrays.asList(8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2);

        ArrayList<Integer> product = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            product.add(convertedToNumber.get(i ) * multiplier.get(i));
        }
        int sumProduct = 0;

        for (Integer i:product
             ) {
            sumProduct +=i;
        }
        int sumProductMod = sumProduct%11;

        if (sumProductMod == 10 && vinChars[8] == 'X') return true;
        return String.valueOf(sumProductMod).equalsIgnoreCase(String.valueOf(vinChars[8]));
    }
}
