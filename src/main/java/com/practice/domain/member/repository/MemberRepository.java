package com.practice.domain.member.repository;

import com.practice.domain.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    public MemberEntity save(MemberEntity memberEntity);
    public Optional<MemberEntity> findById(Long memberId);
    public Optional<MemberEntity> findByLoginId(String username);
}
