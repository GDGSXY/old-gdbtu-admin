package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.JwtUtil;
import cn.edu.gdbtu.admin.common.auth.LoginUser;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.controller.cmd.LoginUserCMD;
import cn.edu.gdbtu.admin.controller.vo.LoginUserVO;
import cn.edu.gdbtu.admin.domain.user.assembler.UserAssembler;
import cn.edu.gdbtu.admin.service.user.AuthService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 用户认证 Controller
 *
 * @author Jover Zhang
 * @date 2021/10/13
 */
@RestController
@Api("用户认证 Controller")
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    private final UserAssembler userAssembler;

    @PostMapping("/login")
    public R<LoginUserVO> login(@Valid @RequestBody LoginUserCMD cmd) {
        LoginUser loginUser = service.login(cmd.getUsername(), cmd.getPassword());
        String token = JwtUtil.getSingleton().generateToken(loginUser);
        return R.success(userAssembler.toLoginUserVO(loginUser, token));
    }

}
