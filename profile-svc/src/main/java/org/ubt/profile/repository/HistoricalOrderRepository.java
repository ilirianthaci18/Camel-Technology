package org.ubt.profile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ubt.profile.model.HistoricalOrder;

@Repository
public interface HistoricalOrderRepository extends JpaRepository<HistoricalOrder, Integer> {

}
