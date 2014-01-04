package com.gp.simpleinsight.controllers;

import com.gp.simpleinsight.services.impl.ActivityServiceImpl;
import com.gridpulse.simpleinsight.domain.Activity;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bogdan
 */
@Controller
@RequestMapping("/data/activity")
public class ActivityController extends CrudController<Activity> {

    @Resource()
    ActivityServiceImpl service;

    public ActivityServiceImpl getService() {
        return service;
    }

}
