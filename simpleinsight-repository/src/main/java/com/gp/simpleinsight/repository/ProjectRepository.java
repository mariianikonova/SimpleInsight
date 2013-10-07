/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gp.simpleinsight.repository;

import com.gridpulse.simpleinsight.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bogdan
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
