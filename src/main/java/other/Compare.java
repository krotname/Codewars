package other;

import lombok.Builder;
import lombok.Value;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Compare {

    /**
     * Класс Compar представляет собой объект с двумя целочисленными полями a и b.
     * Реализует интерфейс Comparable для естественной сортировки по a, затем по b.
     */
    @Value
    @Builder
    public static class Compar implements Comparable<Compar> {
        int a;
        int b;

        @Override
        public int compareTo(Compar o) {
            return Comparator.comparingInt(Compar::getA)
                    .thenComparingInt(Compar::getB)
                    .compare(this, o);
        }
    }

    /**
     * Класс ComparComparator реализует Comparator для объектов Compar,
     * определяя порядок сортировки сначала по b, затем по a.
     */
    @Builder
    public static class ComparComparator implements Comparator<Compar> {

        @Override
        public int compare(Compar o1, Compar o2) {
            return Comparator.comparingInt(Compar::getB)
                    .thenComparingInt(Compar::getA)
                    .compare(o1, o2);
        }
    }

    @Test
    @DisplayName("ComparComparator должен корректно сравнивать объекты по полю b, затем по a")
    public void testCompare() {
        ComparComparator comparComparator = new ComparComparator();

        Compar obj1 = Compar.builder().a(10).b(20).build();
        Compar obj2 = Compar.builder().a(10).b(30).build();
        Compar obj3 = Compar.builder().a(15).b(5).build();

        // obj1.b = 20 < obj2.b = 30
        assertTrue(comparComparator.compare(obj1, obj2) < 0,
                "comparComparator.compare(obj1, obj2) должно быть отрицательным");
        // obj2.b = 30 > obj1.b = 20
        assertTrue(comparComparator.compare(obj2, obj1) > 0,
                "comparComparator.compare(obj2, obj1) должно быть положительным");
        // obj1.b = 20 > obj3.b = 5
        assertTrue(comparComparator.compare(obj1, obj3) > 0,
                "comparComparator.compare(obj1, obj3) должно быть положительным");
        // obj3.b = 5 < obj1.b = 20
        assertTrue(comparComparator.compare(obj3, obj1) < 0,
                "comparComparator.compare(obj3, obj1) должно быть отрицательным");
        // obj1.b = 20 == obj1.b = 20
        assertEquals(0, comparComparator.compare(obj1, obj1),
                "comparComparator.compare(obj1, obj1) должно быть равно 0");
    }

    @Test
    @DisplayName("Метод compareTo должен корректно сравнивать объекты сначала по a, затем по b")
    public void testComparComparator() {
        Compar obj1 = Compar.builder().a(10).b(20).build();
        Compar obj2 = Compar.builder().a(10).b(30).build();
        Compar obj3 = Compar.builder().a(15).b(5).build();

        // obj1.a = 10 < obj2.a = 10 (a равны), сравниваем b: 20 < 30
        assertTrue(obj1.compareTo(obj2) < 0, "obj1 должно быть меньше obj2");
        // obj2.a = 10 < obj1.a = 10 (a равны), сравниваем b: 30 > 20
        assertTrue(obj2.compareTo(obj1) > 0, "obj2 должно быть больше obj1");
        // obj1.a = 10 < obj3.a = 15
        assertTrue(obj1.compareTo(obj3) < 0, "obj1 должно быть меньше obj3");
        // obj3.a = 15 > obj1.a = 10
        assertTrue(obj3.compareTo(obj1) > 0, "obj3 должно быть больше obj1");
        // obj1 сравнивается с самим собой
        assertEquals(0, obj1.compareTo(obj1), "obj1 должно быть равно obj1");
    }
}
