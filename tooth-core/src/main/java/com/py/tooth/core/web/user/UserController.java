package com.py.tooth.core.web.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.py.tooth.core.basic.ErrorInfo;
import com.py.tooth.core.basic.Result;
import com.py.tooth.core.request.user.LoginRequest;
import com.py.tooth.core.service.user.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author czt
 * @description
 * @date 2022/6/27 20:36 PM
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/test")
    public Result login(){
        return Result.success(StpUtil.getTokenValue());
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        log.info("user login request ,param is {}" , JSON.toJSONString(loginRequest));
        if(StrUtil.isEmpty(loginRequest.getCode())){
            return Result.fail(ErrorInfo.WECHAR_CODE_ERROR);
        }
        userService.login(loginRequest.getCode(),loginRequest.getSignature(),loginRequest.getEncryptedData(),loginRequest.getIv());
        return Result.success();
    }
}
