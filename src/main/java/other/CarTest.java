package other;

import java.util.HashMap;

public class CarTest {
    public static void main(String[] args) {
        Car.nubmerWhell = 4;

        other.Car car1 = new Car();
        car1.setName("Машина Олега");
        car1.setColor("Красный");
        System.out.println(car1);
        System.out.println(car1.nubmerWhell);


        other.Car car2 = new Car();
        car2.setName("Машина Андрея");
        car2.setColor("Синий");
        System.out.println(car1);
        System.out.println(car1.nubmerWhell);


        car1.nubmerWhell = 3;

        System.out.println(car1);
        System.out.println(car1.nubmerWhell);

        System.out.println(car1);
        System.out.println(car1.nubmerWhell);


        System.out.println(" ------------ ");
        var carHashMap = new HashMap<Car, Integer>();
        carHashMap.put(car1, 11);
        carHashMap.put(car2, 22);
        System.out.println(carHashMap);
        System.out.println(carHashMap.get(car2));
        car2.setName("Машина Ивана");
        System.out.println(carHashMap);
        System.out.println(carHashMap.get(car2));

    }
}
