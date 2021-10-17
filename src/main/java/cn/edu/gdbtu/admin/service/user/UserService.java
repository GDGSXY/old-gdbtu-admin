package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.User;
import cn.edu.gdbtu.admin.domain.user.enums.RoleLevelEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
public interface UserService extends IService<User> {

    /**
     * 通过 username 获取 User
     *
     * @param username 用户名称
     * @return User
     */
    User getByUsername(String username);

    /**
     * 通过条件搜索 User
     *
     * @param query 条件
     * @return Page of User
     */
    IPage<User> searchByCondition(SearchPagingQuery query);

    /**
     * 创建 User
     *
     * @param pinyinName 拼音名称 (用于作为登录名称，不可重复)
     * @return User
     */
    User create(String pinyinName);

    List<User> getAllByRoleLevel(RoleLevelEnum roleLevel);

}
