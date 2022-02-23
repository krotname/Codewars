package kyu5;

public class PigLatin {

    //5

    /**
     * Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
     * <p>
     * Examples
     * pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
     * pigIt('Hello world !');     // elloHay orldway !
     */

    public static void main(String[] args) {

        System.out.println(PigLatin.pigIt("Pig latin is cool")); // igPay atinlay siay oolcay
        System.out.println(PigLatin.pigIt("This is my string")); // hisTay siay ymay tringsay
        System.out.println(PigLatin.pigIt("Hello world !")); // // elloHay orldway !3
        //<O[ay emporatay oay ]oresmay !>
        //O[ emporatay o] oresmay !
    }

    public static String pigIt(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = str.split(" ");
        for (String w : words
        ) {
            if (!w.matches("\\W")) {
                stringBuilder.append(w.substring(1)).append(w.charAt(0)).append("ay ");
            } else {
                stringBuilder.append(w).append(" ");
            }
        }
        return stringBuilder.toString().trim();
    }
}
