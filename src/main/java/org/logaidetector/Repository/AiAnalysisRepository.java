package org.logaidetector.Repository;

import org.logaidetector.Model.AiAnalysisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AiAnalysisRepository extends JpaRepository<AiAnalysisEntity, Long> {

}

