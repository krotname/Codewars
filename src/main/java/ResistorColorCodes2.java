public class ResistorColorCodes2 {
    public static void main(String[] args) {
        System.out.println(encodeResistorColors("10 ohms")); // "brown black black gold"
        System.out.println(encodeResistorColors("47 ohms")); // "yellow violet black gold"
        System.out.println(encodeResistorColors("100 ohms")); // "brown black brown gold"
        System.out.println(encodeResistorColors("220 ohms")); // "red red brown gold"
        System.out.println(encodeResistorColors("330 ohms")); // "orange orange brown gold"
        System.out.println(encodeResistorColors("470 ohms")); // "yellow violet brown gold"
        System.out.println(encodeResistorColors("680 ohms")); // "blue gray brown gold"
        System.out.println(encodeResistorColors("1k ohms")); // "brown black red gold"
        System.out.println(encodeResistorColors("4.7k ohms")); // "yellow violet red gold"
        System.out.println(encodeResistorColors("10k ohms")); // "brown black orange gold"
        System.out.println(encodeResistorColors("22k ohms")); // "red red orange gold"
        System.out.println(encodeResistorColors("47k ohms")); // "yellow violet orange gold"
        System.out.println(encodeResistorColors("100k ohms")); // "brown black yellow gold"
        System.out.println(encodeResistorColors("330k ohms")); // "orange orange yellow gold"
        System.out.println(encodeResistorColors("1M ohms")); // "brown black green gold"
        System.out.println(encodeResistorColors("2M ohms")); // "red black green gold"
    }

    public static String encodeResistorColors(String ohmsString) {
        if (ohmsString == null || ohmsString.isEmpty() || !ohmsString.endsWith(" ohms")) return "";
        int resistorOhms = encodeResistorOhms(ohmsString);
        int[] resistorOhmsArr = encodeResistorOhmsToArr(resistorOhms);
        return encodeResistorArrToColor(resistorOhmsArr);
    }

    public static int encodeResistorOhms(String ohmsString) {
        double tempValue;
        String[] tempArray = ohmsString.split("\\s");
        if (tempArray[0].endsWith("k"))
            tempValue = Double.parseDouble(tempArray[0].trim().substring(0, tempArray[0].length() - 1)) * 1_000;
        else if (tempArray[0].endsWith("M"))
            tempValue = Double.parseDouble(tempArray[0].trim().substring(0, tempArray[0].length() - 1)) * 1_000_000;
        else tempValue = Double.parseDouble(tempArray[0].trim());
        return (int) Math.round(tempValue);
    }

    public static String encodeResistorArrToColor(int[] resistorOhms) {
        return Colors(resistorOhms[0]) + " " + Colors(resistorOhms[1]) +
                " " + Colors(resistorOhms[2]) + " " + Colors(10);
    }

    public static int[] encodeResistorOhmsToArr(int resistorOhms) {
        int[] encodeResistorOhmsArr = new int[3];

        while (resistorOhms >= 100) {
            resistorOhms /= 10;
            encodeResistorOhmsArr[2]++;
        }
        encodeResistorOhmsArr[1] = resistorOhms % 10;
        encodeResistorOhmsArr[0] = resistorOhms / 10;
        return encodeResistorOhmsArr;
    }

    public static String Colors(int num) {
        switch (num) {
            case (0):
                return "black";
            case (1):
                return "brown";
            case (2):
                return "red";
            case (3):
                return "orange";
            case (4):
                return "yellow";
            case (5):
                return "green";
            case (6):
                return "blue";
            case (7):
                return "violet";
            case (8):
                return "gray";
            case (9):
                return "white";
            case (10):
                return "gold";
        }
        return "";
    }
}

enum Colors {
    BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GRAY, WHITE, GOLD;
}

