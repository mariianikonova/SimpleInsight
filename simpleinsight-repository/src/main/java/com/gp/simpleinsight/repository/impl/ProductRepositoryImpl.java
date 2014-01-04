package com.gp.simpleinsight.repository.impl;

import com.gp.simpleinsight.repository.ProductRepository;
import com.gridpulse.simpleinsight.domain.Product;
import org.springframework.stereotype.Repository;

/**
 *
 * @author bogdan
 */
@Repository
public class ProductRepositoryImpl extends AbstractRepository<Product, Long> implements ProductRepository {

}
