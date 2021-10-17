package cn.edu.gdbtu.admin.domain.log.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collections;

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

    public static OperationLogContent createForUpdate(BaseEntity before, BaseEntity after) {
        return new OperationLogContent()
                .setType(Type.UPDATE)
                .setBefore(before)
                .setAfter(after);
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
