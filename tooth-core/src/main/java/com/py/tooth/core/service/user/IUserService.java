package com.py.tooth.core.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.py.tooth.core.entity.user.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czt
 * @since 2022-06-28
 */
public interface IUserService extends IService<User> {

    void login(String code, String signature, String encryptedData, String iv);
}
