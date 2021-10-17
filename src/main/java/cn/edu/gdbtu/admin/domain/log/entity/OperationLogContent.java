package cn.edu.gdbtu.admin.domain.log.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import com.google.common.collect.Maps;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@Data
@Accessors(chain = true)
public class OperationLogContent {

    private Type type;

    private Object before;

    private Object after;

    public static OperationLogContent createForCreate(long id) {
        return new OperationLogContent()
                .setType(Type.CREATE)
                .setAfter(Collections.singletonMap("id", id));
    }

    @SneakyThrows
    public static OperationLogContent createForUpdate(BaseEntity before, BaseEntity after) {
        Assert.isTrue(before.getClass() == after.getClass(), "类型必须相同");
        Assert.isTrue(Objects.equals(before.getId(), after.getId()), "id 必须相同");
        Map<String, Object> beforeMap = Maps.newHashMap();
        Map<String, Object> afterMap = Maps.newHashMap();
        beforeMap.put("id", before.getId());
        afterMap.put("id", after.getId());

        for (PropertyDescriptor descriptor : BeanUtils.getPropertyDescriptors(before.getClass())) {
            Method readMethod = descriptor.getReadMethod();
            if (readMethod != null) {
                Object beforeData = readMethod.invoke(before);
                Object afterData = readMethod.invoke(after);
                if (!Objects.equals(beforeData, afterData)) {
                    beforeMap.put(descriptor.getName(), beforeData);
                    afterMap.put(descriptor.getName(), afterData);
                }
            }
        }

        return new OperationLogContent()
                .setType(Type.UPDATE)
                .setBefore(beforeMap)
                .setAfter(afterMap);
    }

    public static OperationLogContent createForRemove(long id) {
        return new OperationLogContent()
                .setType(Type.REMOVE)
                .setBefore(Collections.singletonMap("id", id));
    }

    public enum Type {
        /**
         * 创建
         */
        CREATE,
        /**
         * 修改
         */
        UPDATE,
        /**
         * 删除
         */
        REMOVE,
    }

}
