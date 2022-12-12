package other;

import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestUseEntity {

    @Data
    @Builder
    public static class Entity {
        private String name;
        private String characteristic;
    }

    @Test
    public void test1() {
        Entity e1 = Entity.builder().name("4AAAA").characteristic("FX").build();
        Entity e2 = Entity.builder().name("4AAAA").characteristic("FOND").build();
        Entity e3 = Entity.builder().name("SAAAA").characteristic("FX").build();
        Entity e4 = Entity.builder().name("SAAAA").characteristic("FOND").build();
        List<Entity> entities = Arrays.asList(e1, e2, e3, e4);
        System.out.println(entities);

        Map<String, List<Entity>> collect = entities.stream().collect(Collectors.groupingBy(Entity::getName));
        System.out.println(collect);

    }
}
