package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import cn.edu.gdbtu.admin.domain.user.repository.dao.ClassInfoDao;
import cn.edu.gdbtu.admin.service.user.ClassInfoService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Service
public class ClassInfoServiceImpl extends ServiceImpl<ClassInfoDao, ClassInfo> implements ClassInfoService {

    @Override
    public List<ClassInfo> getListByCondition(long majorId) {
        LambdaQueryWrapper<ClassInfo> wrapper = new LambdaQueryWrapper<ClassInfo>()
                .eq(ClassInfo::getMajorId, majorId);
        return list(wrapper);
    }

}
