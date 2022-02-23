package kyu5;

import java.util.*;

public class ParseMolecule {
    public static Map<String, Integer> getAtoms(String formula) {

        //5 - not work
        //https://www.codewars.com/kata/52f831fa9d332c6591000511


        /**For a given chemical formula represented by a string, count the number of atoms of each element contained in the molecule and return an object (associative array in PHP, Dictionary<string, int> in C#, Map<String,Integer> in Java).

         For example:

         String water = "H2O";
         parseMolecule.getAtoms(water); // return [H: 2, O: 1]

         String magnesiumHydroxide = "Mg(OH)2";
         parseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]

         String fremySalt = "K4[ON(SO3)2]2";
         parseMolecule.getAtoms(fremySalt); // return ["K": 4, "O": 14, "N": 2, "S": 4]

         parseMolecule.getAtoms("pie"); // throw an IllegalArgumentException
         As you can see, some formulas have brackets in them. The index outside the brackets tells you that you have to multiply count of each atom inside the bracket on this index. For example, in Fe(NO3)2 you have one iron atom, two nitrogen atoms and six oxygen atoms.

         Note that brackets may be round, square or curly and can also be nested. Index after the braces is optional..
         */

        if (!chekBracket(formula)) {
            throw new IllegalArgumentException();
        }
        HashMap<String, Integer> resultHashMap = new HashMap<>();

        ArrayList<String> elements = new ArrayList<>();
        elements.addAll(Arrays.asList("N", "Ac", "Al", "Am", "Ar", "At", "Ba", "Be", "Bk", "B", "Br", "V", "Bi", "H", "W", "Gd", "Ga", "Hn", "Hf", "He", "Ge", "Ho", "Ds", "Dy", "Db", "Eu", "Fe", "Jo", "Au", "In", "Ir", "Yb", "Y", "I", "Cd", "K", "Cf", "Ca", "O", "Co", "Si", "Kr", "Xe", "Cm", "La", "Li", "Lr", "Lu", "Mg", "Mt", "Mn", "Md", "As", "Cu", "Mo", "Na", "Nd", "Ne", "Np", "Ni", "Nb", "No", "Sn", "Os", "Pd", "Pt", "Pu", "Po", "Pr", "Pm", "Pa", "Ra", "Rn", "Rf", "Re", "Re", "Rh", "Hg", "Rb", "Ru", "Sm", "Pb", "Se", "Sg", "S", "Ag", "Sc", "Sr", "Sb", "Tl", "Ta", "Te", "Tb", "Tc", "Ti", "Th", "Tm", "C", "Uub", "Uuh", "Uuq", "Uuo", "Uup", "Uus", "Uut", "U", "Fm", "P", "Fr", "F", "Hs", "Cl", "Cr", "Cs", "Ce", "Zn", "Zr", "Es", "Er"));

        Character[] charObjectArray =
                formula.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        List<Character> characters = new ArrayList<>(Arrays.asList(charObjectArray));
        characters.add('*');
        characters.add('*');

        for (String element : elements
        ) {
            Integer multiply = 0;
            int count = count(formula, element);
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    Integer tempultiply = 1;

                    // TODO удаление посчитанных знаков из characters а не formula
                    char x = characters.get(formula.indexOf(element) + 1);

                    char x2 = characters.get(formula.indexOf(element) + 2);
                    if ((x >= 49 && x <= 57) && (x2 >= 49 && x2 <= 57)) {
                        Integer y = Integer.parseInt(String.valueOf(x) + x2);
                        tempultiply *= y;
                        formula = formula.replaceFirst(String.valueOf(y), "");
                    } else if (x >= 49 && x <= 57) {
                        tempultiply *= x - 48;
                        formula = formula.replaceFirst(String.valueOf(x), "");

                    }
                    if (formula.indexOf("(") < formula.indexOf(element) && formula.indexOf(")") > formula.indexOf(element)) {
                        char y = characters.get(formula.indexOf(")") + 1);
                        if (y >= 49 && y <= 57) {
                            tempultiply *= y - 48;
                        }
                    }
                    if (formula.indexOf("[") < formula.indexOf(element) && formula.indexOf("]") > formula.indexOf(element)) {
                        char y = characters.get(formula.indexOf("]") + 1);
                        if (y >= 49 && y <= 57) {
                            tempultiply *= y - 48;
                        }
                    }
                    if (formula.indexOf("{") < formula.indexOf(element) && formula.indexOf("}") > formula.indexOf(element)) {
                        char y = characters.get(formula.indexOf("}") + 1);
                        if (y >= 49 && y <= 57) {
                            tempultiply *= y - 48;
                        }
                    }

                    formula = formula.replaceFirst(element, "");
                    multiply += tempultiply;
                }
                resultHashMap.put(element, multiply);
            }

        }
        if (resultHashMap.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return resultHashMap;
    }

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    public static boolean chekBracket(String str) {

        Map<Character, Character> brk = new Hashtable<>();
        brk.put(']', '[');
        brk.put('}', '{');
        brk.put(')', '(');

        Stack<Character> stk = new Stack<>();

        for (char c : str.toCharArray()) {
            if (brk.containsValue(c)) {
                stk.push(c);
            } else {
                if (brk.containsKey(c)) {
                    if (stk.isEmpty() || !brk.get(c).equals(stk.pop())) {
                        return false;
                    }
                }
            }
        }

        return stk.isEmpty();
    }


    public static void main(String[] args) {

        String glucose = "C6H12O6";
        System.out.println(ParseMolecule.getAtoms(glucose)); // return {C=6, H=12, O=6}>

        String water2 = "{((H)2)[O]}";
        System.out.println(ParseMolecule.getAtoms(water2)); // return [H: 2, O: 1]

        String water = "H2O";
        System.out.println(ParseMolecule.getAtoms(water)); // return [H: 2, O: 1]


        String fremySalt = "K4[ON(SO3)2]2";
        System.out.println(ParseMolecule.getAtoms(fremySalt)); // return ["K": 4, "O": 14, "N": 2, "S": 4]

        String magnesiumHydroxide = "Mg(OH)2";
        System.out.println(ParseMolecule.getAtoms(magnesiumHydroxide)); // return ["Mg": 1, "O": 2, "H": 2]


        ParseMolecule.getAtoms("pie"); // throw an IllegalArgumentException
    }
}
