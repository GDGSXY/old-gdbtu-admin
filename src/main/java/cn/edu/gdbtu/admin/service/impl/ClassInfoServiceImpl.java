package cn.edu.gdbtu.admin.service.impl;

import cn.edu.gdbtu.admin.domain.entity.ClassInfo;
import cn.edu.gdbtu.admin.repository.dao.ClassInfoDao;
import cn.edu.gdbtu.admin.service.ClassInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoDao, ClassInfo> implements ClassInfoService {
}
