package cn.edu.gdbtu.admin.common.web;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Web Result
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class R<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> success() {
        return success(null);
    }

    public static <T> R<T> success(T data, String msg) {
        return new R<>(0, msg, data);
    }

    public static <T> R<T> success(T data) {
        return new R<>(0, "ok", data);
    }

    public static <T> R<T> fail(String msg) {
        return new R<>(500, msg, null);
    }

}
