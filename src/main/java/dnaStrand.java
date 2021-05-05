package codewars;

public class dnaStrand {
    public static void main(String[] args) {
        System.out.println(makeComplement("AAAA"));
        System.out.println(makeComplement("ATTGC"));
        System.out.println(makeComplement("GTAT"));
    }

    public static String makeComplement(String dna) {

        String result = dna.replace("A", "*");
        result = result.replace("T", "A");
        result = result.replace("*", "T");

        result = result.replace("C", "*");
        result = result.replace("G", "C");
        result = result.replace("*", "G");
        return result;
    }
}