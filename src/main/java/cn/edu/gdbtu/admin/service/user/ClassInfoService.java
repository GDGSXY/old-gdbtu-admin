package cn.edu.gdbtu.admin.service.user;

import cn.edu.gdbtu.admin.domain.user.entity.ClassInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
public interface ClassInfoService extends IService<ClassInfo> {

    List<ClassInfo> getListByCondition(long majorId);

}
