package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import cn.edu.gdbtu.admin.domain.user.repository.dao.AcademyDao;
import cn.edu.gdbtu.admin.service.user.AcademyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
public class AcademyServiceImpl extends ServiceImpl<AcademyDao, Academy> implements AcademyService {
}
