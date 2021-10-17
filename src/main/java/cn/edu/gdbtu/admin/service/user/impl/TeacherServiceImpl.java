package cn.edu.gdbtu.admin.service.user.impl;

import cn.edu.gdbtu.admin.common.query.SearchPagingQuery;
import cn.edu.gdbtu.admin.domain.user.entity.Academy;
import cn.edu.gdbtu.admin.domain.user.entity.Teacher;
import cn.edu.gdbtu.admin.domain.user.repository.dao.TeacherDao;
import cn.edu.gdbtu.admin.service.user.AcademyService;
import cn.edu.gdbtu.admin.service.user.TeacherService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Jover Zhang
 * @date 2021/10/16
 */
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, Teacher> implements TeacherService {

    private final AcademyService academyService;

    @Override
    public IPage<Teacher> searchByConditions(SearchPagingQuery query, Long academyId) {
        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<Teacher>()
                .eq(academyId != null, Teacher::getAcademyId, academyId)
                .likeRight(query.getSearch() != null, Teacher::getName, query.getSearch());
        return getBaseMapper().selectPage(query.toPage(), wrapper);
    }

    @Override
    public void createTeacher(Teacher teacher) {
        Academy academy = academyService.getById(teacher.getAcademyId());
        Assert.notNull(academy, "学院不存在");

        getBaseMapper().insert(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        Academy academy = academyService.getById(teacher.getAcademyId());
        Assert.notNull(academy, "学院不存在");

        Assert.isTrue(updateById(teacher), "更新失败");
    }

}
