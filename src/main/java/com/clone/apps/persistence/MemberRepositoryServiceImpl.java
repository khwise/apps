package com.clone.apps.persistence;

import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.persistence.mapper.MemberMapper;
import com.clone.apps.persistence.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 27.
 * MemberRepository.class, MemberMapper.class 를 제어할 수 있는 Service Repository
 */

@Component
public class MemberRepositoryServiceImpl implements MemberRepositoryService {

    private final MemberRepository repository;

    private MemberMapper mapper;

    @Autowired
    public MemberRepositoryServiceImpl(MemberRepository repository, MemberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Member findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Member> findAll() {
        return repository.findAll();
    }

    @Override
    public Member save(Member member) {
        return repository.save(member);
    }

    @Override
    public Member update(Member member) {
        return repository.save(member);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Member findByMemberId(String id) {
        return repository.findByMemberId(id);
    }

    @Override
    public List<Member> getMembers() {
        return mapper.selectMembers();
    }
}
