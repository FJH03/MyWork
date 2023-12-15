package com.example.MyWork.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

/**
 * @Created with Intellij IDEA Ultimate 2022.02.03 正式旗舰版
 * @Author: 2113042621-冯佳和
 * @ClassName: JwtUtil
 * @Date: 2023/11/26
 * @Time: 18:12
 * @Description:添加自定义描述
 */
public class JwtUtil {
    /**
     * @Field: KEY  加密的秘钥
     */
    public final static String KEY = "FJH_03";

    /**
     * @param map
     * @return
     * @Method: getToken    根据传入的map封装成Token
     */
    public static String getToken(Map<String, String> map) {
        //创建JWT builder
        JWTCreator.Builder builder = JWT.create();
        //对需要封装的数据进行遍历并设置在JWT中
        map.forEach(builder::withClaim);
        //创建一个日期类并设置过期时间，设置了七天的过期时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE, 7);
        //设置过期时间并设置签名算法返回一个Token
        String token = builder.withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256(KEY));

        return token;
    }

    /**
     * @param token
     * @return
     * @Method: verifyToken    验证Token，并返回DecodedJWT对象
     */
    public static DecodedJWT verifyToken(String token) {
        //创建一个JWTVerifier对象并传入加密算法和秘钥
        return JWT.require(Algorithm.HMAC256(KEY)).build().verify(token);
    }

    /**
     * 用于直接获取数据
     *
     * @param token 传入token
     * @param KEY   从token中获取传入的KEY的值
     */
    public static String getDataByKey(String token, String KEY) {
        return verifyToken(token).getClaim(KEY).asString();
    }
}
