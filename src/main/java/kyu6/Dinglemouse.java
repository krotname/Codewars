package kyu6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Dinglemouse {
    String name;
    int age;
    char sex;
    ArrayList<String> order = new ArrayList<>();

    public Dinglemouse() {
    }

    public Dinglemouse setAge(int age) {
        this.age = age;
        order.add("age");
        return this;
    }

    public Dinglemouse setSex(char sex) {
        this.sex = sex;
        order.add("sex");
        return this;
    }

    public Dinglemouse setName(String name) {
        this.name = name;
        order.add("name");
        return this;
    }

    public String hello() {
        String sexString = sex == 'M' ? "male" : "female";
        StringBuilder stringBuilder = new StringBuilder().append("Hello. ");
        order.forEach(o -> {
            if (o.equals("name")){
                stringBuilder.append("My name is " + name + ". ");
            }
            if (o.equals("sex")){
                stringBuilder.append("I am " + sexString + ". ");
            }
            if (o.equals("age")){
                stringBuilder.append("I am " + age + ". ");
            }
        });
        return stringBuilder.toString().strip();
    }

    @Test
    public void testBob27Male() {
        Dinglemouse dm = new Dinglemouse().setName("Bob").setAge(27).setSex('M');
        String expected = "Hello. My name is Bob. I am 27. I am male.";
        assertEquals(expected, dm.hello());
    }

    @Test
    public void test27MaleBob() {
        Dinglemouse dm = new Dinglemouse().setAge(27).setSex('M').setName("Bob");
        String expected = "Hello. I am 27. I am male. My name is Bob.";
        assertEquals(expected, dm.hello());
    }

    @Test
    public void testAliceFemale() {
        Dinglemouse dm = new Dinglemouse().setName("Alice").setSex('F');
        String expected = "Hello. My name is Alice. I am female.";
        assertEquals(expected, dm.hello());
    }

    @Test
    public void testBatman() {
        Dinglemouse dm = new Dinglemouse().setName("Batman");
        String expected = "Hello. My name is Batman.";
        assertEquals(expected, dm.hello());
    }
}
