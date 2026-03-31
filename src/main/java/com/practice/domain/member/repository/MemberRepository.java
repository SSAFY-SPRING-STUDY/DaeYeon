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

    public Optional<MemberEntity> findByLoginId(String loginId) {
        for(MemberEntity member : memberStore.values()){
            if(member.getLoginId().equals(loginId))
                return Optional.of(member);
        }
        return Optional.empty();
    }
}
