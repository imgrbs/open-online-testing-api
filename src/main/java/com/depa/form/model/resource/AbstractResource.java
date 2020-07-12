/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.model.resource;

import com.depa.form.model.acl.ResoucePrivilege;
import java.util.List;

/**
 *
 * @author Test
 */
public abstract class AbstractResource {
    
    private List<ResoucePrivilege> resourcePrivilegeList;
    
    public List<ResoucePrivilege> getResourcePrivilegeList() {
        return resourcePrivilegeList;
    }

    public void setResourcePrivilegeList(List<ResoucePrivilege> resourcePrivilegeList) {
        this.resourcePrivilegeList = resourcePrivilegeList;
    }

    @Override
    public String toString() {
        return "AbstractResource{" + "resourcePrivilegeList=" + resourcePrivilegeList + '}';
    }
    
}
