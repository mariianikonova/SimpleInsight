/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gp.simpleinsight.services.impl;

import com.gp.simpleinsight.repository.ActivityRepository;
import com.gp.simpleinsight.services.BaseService;
import com.gridpulse.simpleinsight.domain.Activity;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author bogdan
 */
@Service
public class ActivityServiceImpl implements BaseService<Activity> {

    @Resource()
    private ActivityRepository activityRepository;

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

}
