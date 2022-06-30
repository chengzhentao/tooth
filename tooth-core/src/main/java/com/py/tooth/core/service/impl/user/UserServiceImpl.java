package com.py.tooth.core.service.impl.user;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.py.tooth.core.basic.Constant;
import com.py.tooth.core.basic.ErrorInfo;
import com.py.tooth.core.basic.Result;
import com.py.tooth.core.common.Wechat;
import com.py.tooth.core.entity.user.User;
import com.py.tooth.core.mapper.user.UserMapper;
import com.py.tooth.core.service.user.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czt
 * @since 2022-06-28
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    //@Override
    public Result login(String code) {
        //服务端登录微信
        String result = null;//HttpUtil.get(Wechat.getAuthUrl(code),CharsetUtil.CHARSET_UTF_8);
        JSONObject webcharResult = JSON.parseObject(result);
        Integer errcode = webcharResult.getInteger("errcode");
        if(ObjectUtil.isNull(errcode) || !errcode.equals(Constant.SUCCESS)){
            return Result.fail(ErrorInfo.WECHAR_LOGIN_ERROR);
        }
        String openid = webcharResult.getString("openid");
        String sessionKey = webcharResult.getString("session_key");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(User::getOpenid,openid);
        User user = this.getOne(queryWrapper,false);
        StpUtil.login(user.getId());
        return Result.success(StpUtil.getTokenValue());
    }

    @Override
    public void login(String code, String signature, String encryptedData, String iv) {

    }
}
