package com.hanyang.chatgpt;

import com.hanyang.chatgpt.domain.security.service.JwtUtil;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    @Test
    public void test_jwt() {
        JwtUtil util = new JwtUtil("rkl", SignatureAlgorithm.HS256);
        // 以tom作为秘钥，以HS256加密
        Map<String, Object> map = new HashMap<>();
        map.put("username", "rkl");
        map.put("password", "123");
        map.put("age", 100);

        String jwtToken = util.encode("rkl", 30000, map);

        util.decode(jwtToken).forEach((key, value) -> System.out.println(key + ": " + value));
    }

}
