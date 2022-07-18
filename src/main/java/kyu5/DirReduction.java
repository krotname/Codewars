package kyu5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DirReduction {

    //5

    /**
     * Once upon a time, on a way through the old wild mountainous west,…
     * … a man was given directions to go from one point to another. The directions were "NORTH", "SOUTH", "WEST", "EAST".
     * Clearly "NORTH" and "SOUTH" are opposite, "WEST" and "EAST" too.
     * <p>
     * Going to one direction and coming back the opposite direction right away is a needless effort.
     * Since this is the wild west, with dreadfull weather and not much water, it's important to save yourself
     * some energy, otherwise you might die of thirst!
     * <p>
     * How I crossed a mountainous desert the smart way.
     * The directions given to the man are, for example, the following (depending on the language):
     * <p>
     * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
     * or
     * { "NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
     * or
     * [North, South, South, East, West, North, West]
     * You can immediatly see that going "NORTH" and immediately "SOUTH" is not reasonable, better stay to the same place!
     * So the task is to give to the man a simplified version of the plan. A better plan in this case is simply:
     * <p>
     * ["WEST"]
     * or
     * { "WEST" }
     * or
     * [West]
     * Other examples:
     * In ["NORTH", "SOUTH", "EAST", "WEST"], the direction "NORTH" + "SOUTH" is going north and coming back right away.
     * <p>
     * The path becomes ["EAST", "WEST"], now "EAST" and "WEST" annihilate each other, therefore, the final result is [].
     * <p>
     * In ["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"], "NORTH" and "SOUTH" are not directly opposite but they
     * become directly opposite after the reduction of "EAST" and "WEST" so the whole path is reducible to ["WEST", "WEST"].
     * <p>
     * Task
     * Write a function dirReduc which will take an array of strings and returns an array of strings with the needless
     * directions removed (W<->E or S<->N side by side).
     * <p>
     * The Haskell version takes a list of directions with data Direction = North | East | West | South.
     * The Clojure version returns nil when the path is reduced to nothing.
     * The Rust version takes a slice of enum Direction {North, East, West, South}.
     */

    private static final String SOUTH = "SOUTH";
    private static final String EAST = "EAST";
    private static final String WEST = "WEST";
    private static final String NORTH = "NORTH";

    public static String[] dirReduce(String[] arr) {
        boolean edit = false;
        ArrayList<String> resultArray = new ArrayList<>();
        ArrayList<String> currentArray = new ArrayList<>();
        Collections.addAll(currentArray, arr);
        currentArray.add("");
        for (int i = 0; i < currentArray.size() - 1; i++) {
            if (currentArray.get(i).equalsIgnoreCase(NORTH) && currentArray.get(i + 1).equalsIgnoreCase(SOUTH) ||
                    currentArray.get(i).equalsIgnoreCase(SOUTH) && currentArray.get(i + 1).equalsIgnoreCase(NORTH) ||
                    currentArray.get(i).equalsIgnoreCase(EAST) && currentArray.get(i + 1).equalsIgnoreCase(WEST) ||
                    currentArray.get(i).equalsIgnoreCase(WEST) && currentArray.get(i + 1).equalsIgnoreCase(EAST)) {
                i++;
                edit = true;
            } else {
                resultArray.add(currentArray.get(i));
            }
        }
        String[] result = resultArray.toArray(new String[0]);

        if (!edit) {
            return result;
        }
        return dirReduce(result);
    }

    @Test
    public void test() {
        assertArrayEquals(new String[]{SOUTH, SOUTH, EAST}, dirReduce(new String[]{SOUTH, SOUTH, EAST}));
        assertArrayEquals(new String[]{WEST}, dirReduce(new String[]{NORTH, SOUTH, SOUTH, EAST, WEST, NORTH, WEST}));
        assertArrayEquals(new String[]{}, dirReduce(new String[]{NORTH, SOUTH, SOUTH, EAST, WEST, NORTH}));
    }
}
