package com.practice.domain.member.repository;

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

    public Optional<MemberEntity> findById(Long id) {
        if(memberStore.get(id) == null)
            return Optional.empty();
        return Optional.of(memberStore.get(id));
    }

    public Optional<MemberEntity> findByLoginId(String LoginId) {
        for(MemberEntity memberEntity : memberStore.values()) {
            if(LoginId.equals(memberEntity.getLoginId()))
                return Optional.of(memberEntity);
        }
        return Optional.empty();
    }
}
