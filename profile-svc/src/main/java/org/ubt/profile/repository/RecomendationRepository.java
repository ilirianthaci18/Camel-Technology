package org.ubt.profile.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.ubt.profile.model.Recommendation;

@Repository
public interface RecomendationRepository extends CrudRepository<Recommendation,Long> {
    @Query("SELECT recommendation from Recommendation recommendation where recommendation.email=:email")
    Recommendation getRecommendationByEmail(@Param("email") String email);
}
