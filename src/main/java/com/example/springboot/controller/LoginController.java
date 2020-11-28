package com.example.springboot.controller;

import com.example.springboot.annotation.Log;
import com.example.springboot.common.ResponseBo;
import com.example.springboot.entities.SysUser;
import com.example.springboot.service.SysMenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.example.springboot.common.ResponseBo.error;
import static com.example.springboot.common.ResponseBo.ok;
import static com.example.springboot.constant.Constant.*;
import static com.example.springboot.constant.WebForwardConstant.FWD_INDEX;
import static com.example.springboot.constant.WebURIConstant.*;
import static com.example.springboot.utils.JsonUtil.object2Json;

@Controller
@Slf4j
public class LoginController extends BaseController {
    @Autowired
    private SysMenuService sysMenuService;

    @PostMapping(LOGIN)
    @ResponseBody
    public ResponseBo login(String username, String password, Boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            login(token);
            return ok();
        } catch (AuthenticationException e) {
            return error(NUM_FIVE_HUNDRED, e.getMessage());
        }
	}


    @GetMapping(INDEX)
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        SysUser user = getPrincipal();
        model.addAttribute(USER, user);
        //当前id角色下对应的菜单列表
        model.addAttribute(CERTIFIED_MENU_LIST, object2Json(sysMenuService.queryMenuList(user.getId())));
        return FWD_INDEX;
    }

    @GetMapping(LOGOUT)
    @Log("用户退出")
    public void logout() {
        //用户退出后，shiro实现自动跳转到登陆页面
        userLogout();
    }
}
