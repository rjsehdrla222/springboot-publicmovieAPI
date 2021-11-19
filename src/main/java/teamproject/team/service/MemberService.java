package teamproject.team.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import teamproject.team.domain.Member;
import teamproject.team.repository.MemberRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void joinUs(Member member) { memberRepository.joinUs(member); }

    public Member login(Member member) {
        return memberRepository.login(member);
    }

    public Member test(Member member) { return memberRepository.test(member); }

}
