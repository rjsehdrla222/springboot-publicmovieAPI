package teamproject.team.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import teamproject.team.domain.Recommended;
import teamproject.team.repository.RecommendedRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class RecommendedService {

    private final RecommendedRepository recommendedRepository;

    public Recommended findRecommended(Recommended recommended) { return recommendedRepository.findRecommended(recommended); };
    public void insertRecommended(Recommended recommended) { recommendedRepository.insertRecommended(recommended); }
}
