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
public class Group {
    
    private String groupId;
    
    private String groupName;
    
    private List<Role> roleList;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "Group{" + "groupId=" + groupId + ", groupName=" + groupName + ", roleList=" + roleList + '}';
    }
    
}
