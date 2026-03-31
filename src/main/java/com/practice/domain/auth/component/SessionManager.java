package com.practice.domain.auth.component;

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
        Long id = sessionStore.get(token);
        if(id==null) {
            throw new RuntimeException("유효하지 않은 세션입니다.");
        }
        return id;
    }

    public void removeSession(String token){
        sessionStore.remove(token);
    }

    public boolean isSessionValid(String token){
        return sessionStore.containsKey(token);
    }



}
