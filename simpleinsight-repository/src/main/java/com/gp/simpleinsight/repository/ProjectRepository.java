package com.gp.simpleinsight.repository;

import com.gridpulse.simpleinsight.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bogdan
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
