package com.py.tooth.core.request.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author czt
 * @description TODO
 * @date 2022/6/27 6:38 PM
 */
@Data
public class LoginRequest implements Serializable {

    private String code;

    private String signature;

    private String encryptedData;

    private String iv;

    private String nickName;

    private String avatarUrl;

    private String province;

    private String city;

}
