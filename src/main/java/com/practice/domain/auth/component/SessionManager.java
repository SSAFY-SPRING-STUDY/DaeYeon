package com.practice.domain.auth.component;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
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

    public Optional<Long> getMemberId(String token){
        if(sessionStore.get(token) == null)
            return Optional.empty();
        return Optional.of(sessionStore.get(token));
    }

    public void removeSession(String token){
        sessionStore.remove(token);
    }




}
