package com.gp.simpleinsight.services.impl;

import com.gp.simpleinsight.repository.ProductLineRepository;
import com.gp.simpleinsight.services.ProductLineService;
import com.gridpulse.simpleinsight.domain.ProductLine;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author bogdan
 */
@Service("productLineService")
public class ProductLineServiceImpl implements ProductLineService {

    @Resource()
    private ProductLineRepository productLineRepository;
    
    public List<ProductLine> findAll() {
        return productLineRepository.findAll();
    }

    public ProductLine save(ProductLine entity) {
        return productLineRepository.save(entity);
    }

    public ProductLine findById(Long entityId) {
        return productLineRepository.findOne(entityId);
    }
    
}
