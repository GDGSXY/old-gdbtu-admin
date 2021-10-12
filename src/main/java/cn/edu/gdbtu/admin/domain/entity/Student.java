package cn.edu.gdbtu.admin.domain.entity;

import cn.edu.gdbtu.admin.common.entity.BaseEntity;
import cn.edu.gdbtu.admin.domain.enums.EducationLevelEnum;
import cn.edu.gdbtu.admin.domain.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.enums.StudentStatusEnum;
import cn.edu.gdbtu.admin.domain.enums.UserSexEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 学生信息
 *
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity {

    /**
     * 用户 id
     *
     * @see User#getId()
     */
    private Long userId;

    /**
     * 班级 id
     *
     * @see ClassInfo#getId()
     */
    private Long classId;

    /**
     * 学号
     */
    private String xh;

    /**
     * 性别
     */
    private UserSexEnum sex;

    /**
     * 姓名拼音
     */
    private String xmpy;

    /**
     * 准考证号
     */
    private String zkzh;

    /**
     * 出生日期
     */
    private String csrq;

    /**
     * 民族
     */
    private String mz;

    /**
     * 学院
     */
    private String xymc;

    /**
     * 二级学院代码
     */
    private String xydm;

    /**
     * 专业
     */
    private String zymc;

    /**
     * 专业代码
     */
    private String zydm;

    /**
     * 学制
     */
    private String xz;

    /**
     * 学籍状态
     */
    private StudentStatusEnum studentStatus;

    /**
     * 年级
     */
    private String nj;

    /**
     * 照片
     */
    private String image;

    /**
     * 入学日期
     */
    private String rxrq;

    /**
     * 考生类别
     */
    private String kslb;

    /**
     * 原毕业学校
     */
    private String xyxx;

    /**
     * 入学方式
     */
    private String rxfs;

    /**
     * 办学形式
     */
    private String bxxs;

    /**
     * 培养层次
     */
    private EducationLevelEnum educationLevel;

    /**
     * 生源所在地
     */
    private String syszd;

    /**
     * 籍贯
     */
    private String jg;

    /**
     * 出生地
     */
    private String csd;

    /**
     * 家庭地址
     */
    private String jtdz;

    /**
     * 邮政编码
     */
    private String yzbm;

    /**
     * 宅电
     */
    private String lxdh;

    /**
     * 个人电话
     */
    private String grdh;

    /**
     * 政治面貌
     */
    private PoliticalOutlookEnum politicalOutlook;

    /**
     * 健康状况
     */
    private String jkzk;

    /**
     * 特长
     */
    private String tc;

    /**
     * 身份证号
     */
    private String sfzh;

    /**
     * 宿舍号
     */
    private String ssh;

    /**
     * 学习年限
     */
    private String xxnx;

    /**
     * 入学总分
     */
    private String rxzf;

    /**
     * 备注
     */
    private String bz;

    /**
     * 学生类别
     */
    private String xslb;

    /**
     * 校区
     */
    private String xiaoq;

    /**
     * e_mail
     */
    private String email;

    /**
     * 目的火车站
     */
    private String station;

    /**
     * 考生号
     */
    private String ksh;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 入学年份
     */
    private String rxnf;

    /**
     * 学科大类
     */
    private String xkdl;

    /**
     * 学科
     */
    private String xk;

    /**
     * 国际专业代码
     */
    private String gjzydm;

    /**
     * 专业培养层次
     */
    private String zypycc;

    /**
     * 其他办学形式
     */
    private String qtbxxx;

    /**
     * 生源身份
     */
    private String sysf;

    /**
     * 毕业类别
     */
    private String bylb;

    /**
     * 联系人
     */
    private String lxr;

    /**
     * 入党团日期
     */
    private String rdrq;

    /**
     * 招生季节
     */
    private String zsjj;

    /**
     * 入学文化程度
     */
    private String rxwhcd;

    /**
     * 主修外语语种
     */
    private String zxwyyz;

    /**
     * 学习形式
     */
    private String xxxs;

    /**
     * 办学类型
     */
    private String bxlx;

    /**
     * 培养对象
     */
    private String pydx;

    /**
     * 录取专业
     */
    private String lqzy;

    /**
     * 学校代码
     */
    private String xxdm;

    /**
     * 是否报到
     */
    private String sfbd;

    /**
     * 联系电话
     */
    private String lxdh2;

}
