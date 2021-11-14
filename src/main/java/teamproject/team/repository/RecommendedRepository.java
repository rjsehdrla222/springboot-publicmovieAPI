package teamproject.team.repository;

import org.springframework.stereotype.Repository;
import teamproject.team.domain.Recommended;

import java.util.List;

@Repository
public interface RecommendedRepository {

    Recommended findRecommended(Recommended recommended);

    void insertRecommended(Recommended recommended);


}
