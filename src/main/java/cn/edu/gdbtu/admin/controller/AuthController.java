package cn.edu.gdbtu.admin.controller;

import cn.edu.gdbtu.admin.common.auth.JwtUtil;
import cn.edu.gdbtu.admin.common.web.R;
import cn.edu.gdbtu.admin.domain.LoginUserCMD;
import cn.edu.gdbtu.admin.domain.assembler.UserAssembler;
import cn.edu.gdbtu.admin.domain.entity.User;
import cn.edu.gdbtu.admin.domain.vo.LoginUserVO;
import cn.edu.gdbtu.admin.service.UserService;
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

    private final UserService userService;

    private final UserAssembler userAssembler;

    @PostMapping("/login")
    public R<LoginUserVO> login(@Valid @RequestBody LoginUserCMD cmd) {
        User user = userService.getByUsername(cmd.getUsername());
        if (user == null || !cmd.getPassword().equals(user.getPassword())) {
            return R.fail("用户名或密码不正确");
        }
        String token = JwtUtil.getSingleton().generateToken(user);
        return R.success(userAssembler.toLoginUserVO(user, token));
    }

}