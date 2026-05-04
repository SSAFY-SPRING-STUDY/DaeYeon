package com.practice.domain.auth.component;

import com.practice.global.exception.CustomException;
import com.practice.global.exception.error.ErrorCode;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SessionManager {
    private final Map<String, Long> sessionStore = new ConcurrentHashMap<>();

    public String createSession(Long memberId){
        String token = UUID.randomUUID().toString();
        sessionStore.put(token, memberId);
        return token;
    }

    public Long getMemberId(String token){
        Long memberId = sessionStore.get(token);
        if(memberId == null) {
            throw new CustomException(ErrorCode.INVALID_TOKEN);
        }
        return memberId;
    }

    public void removeSession(String token){
        sessionStore.remove(token);
    }




}
