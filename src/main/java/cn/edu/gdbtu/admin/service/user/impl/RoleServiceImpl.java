package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.enums.RoleLevelEnum;
import cn.edu.gdbtu.admin.domain.user.repository.UserRepository;
import cn.edu.gdbtu.admin.domain.user.repository.dao.RoleDao;
import cn.edu.gdbtu.admin.service.user.RoleService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

    private final UserRepository userRepository;

    @Override
    public IPage<Role> searchByCondition(SearchPagingQuery query) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<Role>()
                .likeRight(query.getSearch() != null, Role::getName, query.getSearch());
        return page(query.toPage(), wrapper);
    }

    @Override
    public List<Role> getAllByRoleLevel(RoleLevelEnum roleLevel) {
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<Role>()
                .eq(Role::getLevel, roleLevel);
        return list(wrapper);
    }

    @Override
    public void create(Role role) {
        save(role);
    }

    @Override
    public void updateRole(Role role) {
        Assert.isTrue(updateById(role), "更新失败");
    }

    @Override
    public void removeRoleById(long roleId) {
        Assert.isTrue(!userRepository.containsRole(roleId), "只允许删除不被用户绑定的角色");
        removeById(roleId);
    }

}
