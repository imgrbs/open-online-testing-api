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
public class Role {

    private String roleName;

    private List<ResoucePrivilege> resourcePrivilegeList;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<ResoucePrivilege> getResourcePrivilegeList() {
        return resourcePrivilegeList;
    }

    public void setResourcePrivilegeList(List<ResoucePrivilege> resourcePrivilegeList) {
        this.resourcePrivilegeList = resourcePrivilegeList;
    }

    @Override
    public String toString() {
        return "Role{" + "roleName=" + roleName + ", resourcePrivilegeList=" + resourcePrivilegeList + '}';
    }

}
