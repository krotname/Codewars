package other;

public class Car {
    public static int nubmerWhell;
    public String color;
    public String name;

    public static int getNubmerWhell() {
        return nubmerWhell;
    }

    public static void setNubmerWhell(int nubmerWhell) {
        Car.nubmerWhell = nubmerWhell;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
