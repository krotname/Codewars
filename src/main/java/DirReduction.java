import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirReduction {
    //5
/*Once upon a time, on a way through the old wild mountainous west,…
            … a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.

    Going to one direction and coming back the opposite direction right away is a needless effort. Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself some energy, otherwise you might die of thirst!

    How I crossed a mountainous desert the smart way.
    The directions given to the man are, for example, the following (depending on the language):

            ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
    or
    { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
    or
[North, South, South, East, West, North, West]
    You can immediatly see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place! So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:

            ["WEST"]
    or
    { "WEST" }
    or
[West]
    Other examples:
    In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.

    The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [] (nil in Clojure).

    In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].

    Task
    Write a function dirReduc which will take an array of strings and returns an array of strings with the needless directions removed (W<->E or S<->N side by side).

    The Haskell version takes a list of directions with data Direction = North | East | West | South.
    The Clojure version returns nil when the path is reduced to nothing.
    The Rust version takes a slice of enum Direction {North, East, West, South}.
    */
    public static void main(String[] args) {

        System.out.println(Arrays.toString(dirReduc(new String[] {"SOUTH", "SOUTH", "EAST"})));
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"})));
    }


    public static String[] dirReduc(String[] arr) {
        boolean edit = false;
        ArrayList<String> s = new ArrayList<>();
        List<String> arrayList =  new ArrayList<>();;
        for (String t:arr
             ) {
            arrayList.add(t);
        }
        arrayList.add("");
        for (int i = 0; i < arrayList.size()-1 ; i++) {
            if (arrayList.get(i).equalsIgnoreCase("NORTH") && arrayList.get(i+1).equalsIgnoreCase("SOUTH") ||
                    arrayList.get(i).equalsIgnoreCase("SOUTH") && arrayList.get(i+1).equalsIgnoreCase("NORTH") ||
                    arrayList.get(i).equalsIgnoreCase("EAST") && arrayList.get(i+1).equalsIgnoreCase("WEST") ||
                    arrayList.get(i).equalsIgnoreCase("WEST") && arrayList.get(i+1).equalsIgnoreCase("EAST")) {
                i++;
                edit = true;
            } else {
                s.add(arrayList.get(i));
            }
        }
        s.trimToSize();
        Object[] objects = s.toArray();
        String[] result = new String[s.size()];
        for (int i = 0; i < s.size(); i++) {
            result[i] = (String) objects[i];
        }
        if (!edit){
            return result;
        }
        return dirReduc(result);
    }
}
