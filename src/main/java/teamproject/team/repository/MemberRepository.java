package teamproject.team.repository;

import org.springframework.stereotype.Repository;
import teamproject.team.domain.Member;

@Repository
public interface MemberRepository {
    void joinUs(Member member);
    Member login(Member member);
    Member test(Member member);
}
