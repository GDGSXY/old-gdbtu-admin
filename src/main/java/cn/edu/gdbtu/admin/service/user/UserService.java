package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.domain.user.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
public interface UserService extends IService<User> {

    User getByUsername(String username);

}
