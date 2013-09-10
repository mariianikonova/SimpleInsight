package com.gridpulse.simpleinsight.domain;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 *
 * @author bogdan
 */
public class Organization implements Serializable {

    @Id private Long id;
    @Version private  Long version;
    
    private String code;
    private String name;
    
    protected Organization() {}

    Organization(String code, String name) {
        this.code = code;
        this.name = name;
    }

    Organization(Long id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
