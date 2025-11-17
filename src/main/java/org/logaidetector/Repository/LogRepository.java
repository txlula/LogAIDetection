package org.logaidetector.Repository;

import org.logaidetector.Model.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.logaidetector.Model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
        // You can add custom query methods here if needed
    }

