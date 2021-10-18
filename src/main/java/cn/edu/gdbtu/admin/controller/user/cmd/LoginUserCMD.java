package cn.edu.gdbtu.admin.controller.user.cmd;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Jover Zhang
 * @date 2021/10/13
 */
@Data
public class LoginUserCMD {

    @NotNull
    private String username;

    @NotNull
    private String password;

}
