package cn.edu.gdbtu.admin.domain.vo;

import cn.edu.gdbtu.admin.domain.enums.EducationLevelEnum;
import cn.edu.gdbtu.admin.domain.enums.PoliticalOutlookEnum;
import cn.edu.gdbtu.admin.domain.enums.StudentStatusEnum;
import cn.edu.gdbtu.admin.domain.enums.UserSexEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Jover Zhang
 * @date 2021/10/12
 */
@Data
@ApiModel("学生信息")
public class StudentVO {

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("用户 id")
    private Long userId;

    @ApiModelProperty("班级 id")
    private Long classId;

    @ApiModelProperty("学号")
    private String xh;

    @ApiModelProperty("性别")
    private UserSexEnum sex;

    @ApiModelProperty("姓名拼音")
    private String xmpy;

    @ApiModelProperty("准考证号")
    private String zkzh;

    @ApiModelProperty("出生日期")
    private String csrq;

    @ApiModelProperty("民族")
    private String mz;

    @ApiModelProperty("学院")
    private String xymc;

    @ApiModelProperty("二级学院代码")
    private String xydm;

    @ApiModelProperty("专业")
    private String zymc;

    @ApiModelProperty("专业代码")
    private String zydm;

    @ApiModelProperty("学制")
    private String xz;

    @ApiModelProperty("学籍状态")
    private StudentStatusEnum studentStatus;

    @ApiModelProperty("年级")
    private String nj;

    @ApiModelProperty("照片")
    private String image;

    @ApiModelProperty("入学日期")
    private String rxrq;

    @ApiModelProperty("考生类别")
    private String kslb;

    @ApiModelProperty("原毕业学校")
    private String xyxx;

    @ApiModelProperty("入学方式")
    private String rxfs;

    @ApiModelProperty("办学形式")
    private String bxxs;

    @ApiModelProperty("培养层次")
    private EducationLevelEnum educationLevel;

    @ApiModelProperty("生源所在地")
    private String syszd;

    @ApiModelProperty("籍贯")
    private String jg;

    @ApiModelProperty("出生地")
    private String csd;

    @ApiModelProperty("家庭地址")
    private String jtdz;

    @ApiModelProperty("邮政编码")
    private String yzbm;

    @ApiModelProperty("宅电")
    private String lxdh;

    @ApiModelProperty("个人电话")
    private String grdh;

    @ApiModelProperty("政治面貌")
    private PoliticalOutlookEnum politicalOutlook;

    @ApiModelProperty("健康状况")
    private String jkzk;

    @ApiModelProperty("特长")
    private String tc;

    @ApiModelProperty("身份证号")
    private String sfzh;

    @ApiModelProperty("宿舍号")
    private String ssh;

    @ApiModelProperty("学习年限")
    private String xxnx;

    @ApiModelProperty("入学总分")
    private String rxzf;

    @ApiModelProperty("备注")
    private String bz;

    @ApiModelProperty("学生类别")
    private String xslb;

    @ApiModelProperty("校区")
    private String xiaoq;

    @ApiModelProperty("e_mail")
    private String email;

    @ApiModelProperty("目的火车站")
    private String station;

    @ApiModelProperty("考生号")
    private String ksh;

    @ApiModelProperty("QQ号码")
    private String qq;

    @ApiModelProperty("入学年份")
    private String rxnf;

    @ApiModelProperty("学科大类")
    private String xkdl;

    @ApiModelProperty("学科")
    private String xk;

    @ApiModelProperty("国际专业代码")
    private String gjzydm;

    @ApiModelProperty("专业培养层次")
    private String zypycc;

    @ApiModelProperty("其他办学形式")
    private String qtbxxx;

    @ApiModelProperty("生源身份")
    private String sysf;

    @ApiModelProperty("毕业类别")
    private String bylb;

    @ApiModelProperty("联系人")
    private String lxr;

    @ApiModelProperty("入党团日期")
    private String rdrq;

    @ApiModelProperty("招生季节")
    private String zsjj;

    @ApiModelProperty("入学文化程度")
    private String rxwhcd;

    @ApiModelProperty("主修外语语种")
    private String zxwyyz;

    @ApiModelProperty("学习形式")
    private String xxxs;

    @ApiModelProperty("办学类型")
    private String bxlx;

    @ApiModelProperty("培养对象")
    private String pydx;

    @ApiModelProperty("录取专业")
    private String lqzy;

    @ApiModelProperty("学校代码")
    private String xxdm;

    @ApiModelProperty("是否报到")
    private String sfbd;

    @ApiModelProperty("联系电话")
    private String lxdh2;

}
