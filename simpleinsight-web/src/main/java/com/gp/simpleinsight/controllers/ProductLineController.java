package com.gp.simpleinsight.controllers;

import com.gp.simpleinsight.services.BaseService;
import com.gridpulse.simpleinsight.domain.ProductLine;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bogdan
 */
@Controller
@RequestMapping("/data/productLine")
public class ProductLineController extends CrudController<ProductLine> {

    @Resource(name="productLineService")
    private BaseService<ProductLine> service;

    @Override
    public BaseService<ProductLine> getService() {
        return service;
    }

}
