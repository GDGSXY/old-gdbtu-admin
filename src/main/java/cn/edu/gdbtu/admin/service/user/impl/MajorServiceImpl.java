package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.domain.user.entity.Major;
import cn.edu.gdbtu.admin.domain.user.repository.dao.MajorDao;
import cn.edu.gdbtu.admin.service.user.MajorService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
public class MajorServiceImpl extends ServiceImpl<MajorDao, Major> implements MajorService {

    @Override
    public List<Major> getListByCondition(long academyId) {
        LambdaQueryWrapper<Major> wrapper = new LambdaQueryWrapper<Major>()
                .eq(Major::getAcademyId, academyId);
        return getBaseMapper().selectList(wrapper);
    }

}
