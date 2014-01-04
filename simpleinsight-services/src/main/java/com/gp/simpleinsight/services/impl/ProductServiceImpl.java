package com.gp.simpleinsight.services.impl;

import com.gp.simpleinsight.repository.ProductRepository;
import com.gp.simpleinsight.services.BaseService;
import com.gridpulse.simpleinsight.domain.Product;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author bogdan
 */
@Service("productService")
public class ProductServiceImpl implements BaseService<Product> {

    @Resource()
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Transactional
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    public Product findById(Long entityId) {
        return productRepository.findOne(entityId);
    }

}
