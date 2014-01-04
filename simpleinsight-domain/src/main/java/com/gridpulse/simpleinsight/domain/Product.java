package com.gridpulse.simpleinsight.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author bogdan
 */
@Entity
public class Product extends MultiTennantDomainObject implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private ProductLine productLine;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductLine getProductLine() {
        return productLine;
    }

    public void setProductLine(ProductLine productLine) {
        this.productLine = productLine;
    }
    
    
}
