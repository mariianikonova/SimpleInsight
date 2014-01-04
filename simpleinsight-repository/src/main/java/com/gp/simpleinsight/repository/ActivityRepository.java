package com.gp.simpleinsight.repository;

import com.gridpulse.simpleinsight.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bogdan
 */
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
