package cn.edu.gdbtu.admin.service;

import cn.edu.gdbtu.admin.domain.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
public interface UserService extends IService<User> {

    User getByUsername(String username);

}
