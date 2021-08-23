package unknown;

public class SpinWords {
    public static void main(String[] args) {
        System.out.println(spinWords("Welcome"));
        System.out.println(spinWords("Hey fellow warriors"));
    }
    public static String spinWords(String sentence) {
        String[] arrWords = sentence.split("\\s");
        StringBuilder resultSb = new StringBuilder();
        for (String curentWord:arrWords
             ) {
            if (curentWord.length() >= 5){
                StringBuilder curentSb = new StringBuilder(curentWord);
                resultSb.append(curentSb.reverse());
            }
            else{
                resultSb.append(curentWord);
            }
            resultSb.append(" ");
        }
        return resultSb.toString().trim();
    }
}
