package com.gp.simpleinsight.controllers;

import com.gp.simpleinsight.services.BaseService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author bogdan
 */
public abstract class CrudController<T> {

    public abstract BaseService<T> getService();

    @RequestMapping(value = "/{entityId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public T get(@PathVariable("entityId") Long entityId) {
        T object = getService().findById(entityId);
        return object;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<T> list() {
        return getService().findAll();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public T create(@RequestBody T object) {
        object = getService().save(object);
        return object;
    }

    @RequestMapping(method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public T update(@RequestBody T object) {
        object = getService().save(object);
        return object;
    }

}
