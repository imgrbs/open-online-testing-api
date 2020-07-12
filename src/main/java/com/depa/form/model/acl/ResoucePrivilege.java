/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.model.acl;

import java.util.List;

/**
 *
 * @author Test
 */
public class ResoucePrivilege {

    private String resourceId;
    
    private List<PermissionEnum> permissionList;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public List<PermissionEnum> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<PermissionEnum> permissionList) {
        this.permissionList = permissionList;
    }

    @Override
    public String toString() {
        return "ResoucePrivilege{" + "resourceId=" + resourceId + ", permissionList=" + permissionList + '}';
    }
    
}
