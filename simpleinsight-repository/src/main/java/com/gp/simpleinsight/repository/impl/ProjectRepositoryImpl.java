/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gp.simpleinsight.repository.impl;

import com.gp.simpleinsight.repository.ProjectRepository;
import com.gridpulse.simpleinsight.domain.Project;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bogdan
 */
@Repository
public class ProjectRepositoryImpl extends AbstractRepository<Project, Long> implements ProjectRepository {

}
