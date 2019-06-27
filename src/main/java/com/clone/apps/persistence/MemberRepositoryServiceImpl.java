package com.clone.apps.persistence;

import com.clone.apps.persistence.entity.member.Member;
import com.clone.apps.persistence.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kh.jin on 2019. 6. 27.
 * DAO 레이어
 * 캐싱 등을 적용할 수 있다.
 *
 */

@Component
public class MemberRepositoryServiceImpl implements MemberRepositoryService {

    final private MemberRepository repository;

    @Autowired
    public MemberRepositoryServiceImpl(MemberRepository repository) {
        this.repository = repository;
    }

    @Override
    public Member getOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Member> getAll() {
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
}
