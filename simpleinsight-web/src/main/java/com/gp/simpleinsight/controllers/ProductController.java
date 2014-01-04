package com.gp.simpleinsight.controllers;

import com.gp.simpleinsight.services.BaseService;
import com.gp.simpleinsight.services.impl.ProductServiceImpl;
import com.gridpulse.simpleinsight.domain.Product;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bogdan
 */
@Controller
@RequestMapping("/data/product")
public class ProductController extends CrudController<Product> {

    @Resource(name="productService")
    private BaseService<Product> service;

    @Override
    public BaseService<Product> getService() {
        return service;
    }

}
