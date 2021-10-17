package cn.edu.gdbtu.admin.domain.log.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

class OperationLogContentTest extends Assertions {

    @Test
    void createForUpdate() {
        Child before = new Child()
                .setFirstName("A")
                .setLastName("B")
                .setAge(20);

        Child after = new Child()
                .setFirstName("A")
                .setLastName("C")
                .setAge(21);

        OperationLogContent content = OperationLogContent.createForUpdate(before, after);
        Map<?, ?> beforeMap = (Map<?, ?>) content.getBefore();
        Map<?, ?> afterMap = (Map<?, ?>) content.getAfter();
        assertEquals(2, beforeMap.size());
        assertEquals(2, afterMap.size());
        assertEquals("B", beforeMap.get("lastName"));
        assertEquals("C", afterMap.get("lastName"));
        assertEquals(20, beforeMap.get("age"));
        assertEquals(21, afterMap.get("age"));
    }

    @Data
    @Accessors(chain = true)
    @EqualsAndHashCode(callSuper = true)
    static class Child extends BaseEntity {

        private String firstName;

        private String lastName;

        private Integer age;

    }

}
