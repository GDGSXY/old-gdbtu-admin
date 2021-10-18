package cn.edu.gdbtu.admin.domain.user.repository;

import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.repository.dao.UserDao;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author Jover Zhang
 * @date 2021/10/19
 */
@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final UserDao dao;

    public boolean containsRole(long roleId) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getRoleId, roleId);
        return dao.selectCount(wrapper) > 0;
    }

}
