package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.domain.user.entity.Role;
import cn.edu.gdbtu.admin.domain.user.repository.dao.RoleDao;
import cn.edu.gdbtu.admin.service.user.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {
}
