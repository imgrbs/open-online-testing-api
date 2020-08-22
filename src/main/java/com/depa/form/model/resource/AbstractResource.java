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
    
    private ResoucePrivilege otherPrivilege;
    
    private List<ResoucePrivilege> resourceGroupPrivilegeList;
    
    public List<ResoucePrivilege> getResourcePrivilegeList() {
        return resourceGroupPrivilegeList;
    }

    public void setResourcePrivilegeList(List<ResoucePrivilege> resourcePrivilegeList) {
        this.resourceGroupPrivilegeList = resourcePrivilegeList;
    }

    public ResoucePrivilege getOtherPrivilege() {
        return otherPrivilege;
    }

    public void setOtherPrivilege(ResoucePrivilege otherPrivilege) {
        this.otherPrivilege = otherPrivilege;
    }

    public List<ResoucePrivilege> getResourceGroupPrivilegeList() {
        return resourceGroupPrivilegeList;
    }

    public void setResourceGroupPrivilegeList(List<ResoucePrivilege> resourceGroupPrivilegeList) {
        this.resourceGroupPrivilegeList = resourceGroupPrivilegeList;
    }

    @Override
    public String toString() {
        return "AbstractResource{" + "otherPrivilege=" + otherPrivilege + ", resourceGroupPrivilegeList=" + resourceGroupPrivilegeList + '}';
    }
}
