package kyu3;


import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class ScreenLock {
    //3 https://www.codewars.com/kata/585894545a8a07255e0002f1/train/java

    private static final Map<Character, Integer> POINTS = Map.of(
            'A', 5,
            'B', 7,
            'C', 5,
            'D', 7,
            'E', 8,
            'F', 7,
            'G', 5,
            'H', 7,
            'I', 5
    );

    private static final Map<Character, List<Character>> NEIGHBORING_CELLS = Map.of(
            'A', List.of('B', 'D', 'E', 'F', 'H'),
            'B', List.of('A', 'E', 'C', 'D', 'F', 'G', 'I'),
            'C', List.of('B', 'D', 'E', 'F', 'H'),
            'D', List.of('A', 'B', 'C', 'E', 'G', 'H', 'I'),
            'E', List.of('A', 'B', 'C', 'D', 'F', 'G', 'H', 'I'),
            'F', List.of('A', 'B', 'C', 'E', 'G', 'H', 'I'),
            'G', List.of('B', 'D', 'E', 'F', 'H'),
            'H', List.of('A', 'C', 'D', 'F', 'G', 'E', 'I'),
            'I', List.of('B', 'D', 'E', 'F', 'H')
    );

    public static int calculateCombinations(char startPosition, int patternLength) {
        if (patternLength < 0 || patternLength > 8) return 0;
        if (patternLength == 1) return 1;
        if (patternLength == 2) return POINTS.get(startPosition);

//        MutableValueGraph<Character, Integer> weightedGraph = ValueGraphBuilder.directed().build();
//        weightedGraph.addNode( 'A');
//        weightedGraph.addNode( 'B');
//        weightedGraph.addNode( 'C');
//        weightedGraph.putEdgeValue('A', 'B' , 1);
//        weightedGraph.putEdgeValue('C', 'B' , 1);

        long numerator = 1;

        for (; patternLength > 1; patternLength--) {
            char currentPosition = startPosition;
            List<Character> currentNeighboring =  NEIGHBORING_CELLS.get(currentPosition);


            numerator = numerator * POINTS.get(startPosition) ;
        }

        return POINTS.get(startPosition) * patternLength;
    }
    private int recursiveCount(List<Character> characterList){
        if (characterList.isEmpty()) return 0;

        return recursiveCount(characterList);
    }

    private static long comb(int n, int m) {

        long numerator = 1;
        for (; n > 1; n--) {
            numerator = numerator * n * m;
        }
        return numerator;
    }

    @Test
    public void test() {
        System.out.println(comb(3, 3));
    }


    @Test
    public void bascis() {
        assertEquals(0, calculateCombinations('A', 10));
        assertEquals(0, calculateCombinations('A', 0));
        assertEquals(0, calculateCombinations('E', 14));
        assertEquals(1, calculateCombinations('B', 1));
        assertEquals(5, calculateCombinations('C', 2));
        assertEquals(8, calculateCombinations('E', 2));
        assertEquals(8, calculateCombinations('E', 3));
        assertEquals(256, calculateCombinations('E', 4));
    }
}
