package cn.edu.gdbtu.admin.service.impl;

import cn.edu.gdbtu.admin.domain.entity.User;
import cn.edu.gdbtu.admin.repository.dao.UserDao;
import cn.edu.gdbtu.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Override
    public User getByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getUsername, username);
        return getBaseMapper().selectOne(wrapper);
    }

}
