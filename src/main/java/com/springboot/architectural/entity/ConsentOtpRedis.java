package com.springboot.architectural.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("ConsentOtpRedis")
public class ConsentOtpRedis implements Serializable {
    private String username;
    private String email;
    private String password;
    @Id
    private String otp;
//    private LocalDateTime timestamp;

}