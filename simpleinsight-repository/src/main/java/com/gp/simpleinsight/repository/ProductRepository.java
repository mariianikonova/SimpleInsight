package com.gp.simpleinsight.repository;

import com.gridpulse.simpleinsight.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bogdan
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
