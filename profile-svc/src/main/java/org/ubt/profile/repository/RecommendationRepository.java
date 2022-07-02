package org.ubt.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubt.profile.model.Recommendation;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {

}
