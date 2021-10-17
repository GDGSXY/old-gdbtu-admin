package cn.edu.gdbtu.admin.common;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;

/**
 * @author Jover Zhang
 * @date 2021/10/17
 */
@Component
@RequiredArgsConstructor
public class SpringUtil implements ApplicationContextAware {

    private static @Setter(AccessLevel.PRIVATE) SpringUtil instance;

    private final ApplicationContext context;

    public static <T> T getBean(Class<T> clazz) {
        return instance.context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        setInstance(new SpringUtil(applicationContext));
    }

}
