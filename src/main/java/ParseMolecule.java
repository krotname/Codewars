import java.util.HashMap;
import java.util.Map;

public class ParseMolecule {
    public static void main(String[] args) {
        String water = "H2O";
        ParseMolecule.getAtoms(water); // return [H: 2, O: 1]

        String magnesiumHydroxide = "Mg(OH)2";
        ParseMolecule.getAtoms(magnesiumHydroxide); // return ["Mg": 1, "O": 2, "H": 2]

        String fremySalt = "K4[ON(SO3)2]2";
        ParseMolecule.getAtoms(fremySalt); // return ["K": 4, "O": 14, "N": 2, "S": 4]

        ParseMolecule.getAtoms("pie"); // throw an IllegalArgumentException

    }
    public static Map<String,Integer> getAtoms(String molecule) {
        Map<String,Integer> result = new HashMap<>();

        return result;

    }
}
