package com.gp.simpleinsight.repository.impl;

import com.gp.simpleinsight.repository.ActivityRepository;
import com.gridpulse.simpleinsight.domain.Activity;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bogdan
 */
@Repository
public class ActivityRepositoryImpl extends AbstractRepository<Activity, Long> implements ActivityRepository {

}
