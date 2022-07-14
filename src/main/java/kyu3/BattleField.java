package kyu3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BattleField {

    // 3 https://www.codewars.com/kata/52bb6539a4cf1b12d90005b7

    private static final int[][] battleField =
            {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    private static final int[][] badBattleField =
            {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                    {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                    {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {1, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                    {1, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                    {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    @Test
    public void testGood() {
        assertTrue(fieldValidator(battleField));
    }

    @Test
    public void testBad() {
        assertFalse(fieldValidator(badBattleField));
    }

    public static boolean fieldValidator(int[][] field) {
        int battleshipCount = 0;
        int cruisersCount = 0;
        int destroyersCount = 0;
        int submarinesCount = 0;
        boolean result = false;
        int[][] fieldWithEdges = fieldWithEdges(field);

        for (int i = 1; i < fieldWithEdges.length - 1; i++) {
            for (int j = 1; j < fieldWithEdges[0].length - 1; j++) {
                if (fieldWithEdges[i][j] == 1 &&
                        fieldWithEdges[i - 1][j - 1] == 0 &&
                        fieldWithEdges[i - 1][j] == 0 &&
                        fieldWithEdges[i - 1][j + 1] == 0 &&
                        fieldWithEdges[i][j + 1] == 0 &&
                        fieldWithEdges[i + 1][j + 1] == 0 &&
                        fieldWithEdges[i + 1][j] == 0 &&
                        fieldWithEdges[i + 1][j - 1] == 0 &&
                        fieldWithEdges[i][j - 1] == 0
                ) {
                    submarinesCount++;
                }

                if (fieldWithEdges[i][j] == 1 && fieldWithEdges[i][j + 1] == 1 &&
                        fieldWithEdges[i - 1][j - 1] == 0 &&
                        fieldWithEdges[i - 1][j] == 0 &&
                        fieldWithEdges[i - 1][j + 2] == 0 &&
                        fieldWithEdges[i][j + 2] == 0 &&
                        fieldWithEdges[i + 1][j + 2] == 0 &&
                        fieldWithEdges[i + 1][j] == 0 &&
                        fieldWithEdges[i + 1][j - 1] == 0 &&
                        fieldWithEdges[i][j - 1] == 0
                ) {
                    destroyersCount++;
                }

                if (fieldWithEdges[i][j] == 1 && fieldWithEdges[i + 1][j] == 1 &&
                        fieldWithEdges[i - 1][j - 1] == 0 &&
                        fieldWithEdges[i - 1][j] == 0 &&
                        fieldWithEdges[i - 1][j + 1] == 0 &&
                        fieldWithEdges[i][j + 1] == 0 &&
                        fieldWithEdges[i + 2][j + 1] == 0 &&
                        fieldWithEdges[i + 2][j] == 0 &&
                        fieldWithEdges[i + 2][j - 1] == 0 &&
                        fieldWithEdges[i][j - 1] == 0
                ) {
                    destroyersCount++;
                }

                if (fieldWithEdges[i][j] == 1 && fieldWithEdges[i][j + 1] == 1 && fieldWithEdges[i][j + 2] == 1 &&
                        fieldWithEdges[i - 1][j - 1] == 0 &&
                        fieldWithEdges[i - 1][j] == 0 &&
                        fieldWithEdges[i - 1][j + 3] == 0 &&
                        fieldWithEdges[i][j + 3] == 0 &&
                        fieldWithEdges[i + 1][j + 3] == 0 &&
                        fieldWithEdges[i + 1][j] == 0 &&
                        fieldWithEdges[i + 1][j - 1] == 0 &&
                        fieldWithEdges[i][j - 1] == 0
                ) {
                    cruisersCount++;
                }

                if (fieldWithEdges[i][j] == 1 && fieldWithEdges[i + 1][j] == 1 && fieldWithEdges[i + 2][j] == 1 &&
                        fieldWithEdges[i - 1][j - 1] == 0 &&
                        fieldWithEdges[i - 1][j] == 0 &&
                        fieldWithEdges[i - 1][j + 1] == 0 &&
                        fieldWithEdges[i][j + 1] == 0 &&
                        fieldWithEdges[i + 3][j + 1] == 0 &&
                        fieldWithEdges[i + 3][j] == 0 &&
                        fieldWithEdges[i + 3][j - 1] == 0 &&
                        fieldWithEdges[i][j - 1] == 0
                ) {
                    cruisersCount++;
                }
                if (fieldWithEdges[i][j] == 1 && fieldWithEdges[i][j + 1] == 1 && fieldWithEdges[i][j + 2] == 1 && fieldWithEdges[i][j + 3] == 1 &&
                        fieldWithEdges[i - 1][j - 1] == 0 &&
                        fieldWithEdges[i - 1][j] == 0 &&
                        fieldWithEdges[i - 1][j + 4] == 0 &&
                        fieldWithEdges[i][j + 4] == 0 &&
                        fieldWithEdges[i + 1][j + 4] == 0 &&
                        fieldWithEdges[i + 1][j] == 0 &&
                        fieldWithEdges[i + 1][j - 1] == 0 &&
                        fieldWithEdges[i][j - 1] == 0
                ) {
                    battleshipCount++;
                }
                if (fieldWithEdges[i][j] == 1 && fieldWithEdges[i + 1][j] == 1 && fieldWithEdges[i + 2][j] == 1 && fieldWithEdges[i + 3][j] == 1 &&
                        fieldWithEdges[i - 1][j - 1] == 0 &&
                        fieldWithEdges[i - 1][j] == 0 &&
                        fieldWithEdges[i - 1][j + 1] == 0 &&
                        fieldWithEdges[i][j + 1] == 0 &&
                        fieldWithEdges[i + 4][j + 1] == 0 &&
                        fieldWithEdges[i + 4][j] == 0 &&
                        fieldWithEdges[i + 4][j - 1] == 0 &&
                        fieldWithEdges[i][j - 1] == 0
                ) {
                    battleshipCount++;
                }
            }
        }

        if (battleshipCount == 1 && cruisersCount == 2 && destroyersCount == 3 && submarinesCount == 4) {
            result = true;
        }
        return result;
    }

    public static int[][] fieldWithEdges(int[][] field) {
        int[][] fieldWithEdges = new int[field.length + 2][field[0].length + 2];
        for (int i = 0; i < fieldWithEdges.length; i++)
            for (int j = 0; j < fieldWithEdges[i].length; j++)
                if (i == 0 || j == 0) fieldWithEdges[i][j] = 0;

        for (int i = 1; i < fieldWithEdges.length - 1; i++)
            for (int j = 1; j < fieldWithEdges[i].length - 1; j++)
                fieldWithEdges[i][j] = field[i - 1][j - 1];
        return fieldWithEdges;
    }
}
