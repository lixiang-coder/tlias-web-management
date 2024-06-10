package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    /**
     * 生成UUID
     */
    @Test
    public void testUUID() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }


    /**
     * 生成JWT令牌
     */
    @Test
    public void testJupiter() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "Tom");

        String jwt = Jwts.builder()
                .setClaims(claims)  //自定义内容(载荷)
                .signWith(SignatureAlgorithm.HS256, "itheima")   //签名算法
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) //有效期 1h
                .compact();

        System.out.println(jwt);
    }


    /**
     * 解析JWT令牌
     */
    @Test
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")//指定签名密钥（必须保证和生成令牌时使用相同的签名密钥）
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNzE4MTEzMTM0LCJ1c2VybmFtZSI6IlRvbSJ9.XASoN6hAA5WTeRYgsrwPoQbM4CB8BM7UGDC5AL8fNpU")
                .getBody();

        System.out.println(claims);
    }

}
