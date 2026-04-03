package com.practice.domain.member.repository;

import com.practice.domain.auth.controller.dto.request.LoginRequest;
import com.practice.domain.member.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemberRepository {
    private static final Map<Long, MemberEntity> memberStore = new ConcurrentHashMap<>();

    public MemberEntity saveMember(MemberEntity memberEntity) {
        memberStore.put(memberEntity.getId(), memberEntity);
        return memberEntity;
    }

    public Optional<MemberEntity> findByLogin(LoginRequest request) {
        for(MemberEntity member : memberStore.values()){
            if(member.getLoginId().equals(request.loginId())
                    && member.getPassword().equals(request.password()))
                return Optional.of(member);
        }
        return Optional.empty();
    }

    public Optional<MemberEntity> findById(Long id) {
        if(memberStore.get(id) == null)
            return Optional.empty();
        return Optional.of(memberStore.get(id));
    }
}
