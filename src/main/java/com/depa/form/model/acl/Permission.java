/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.model.acl;

/**
 *
 * @author Test
 */
public class Permission {
    
    private boolean read;
    
    private boolean write;
    
    private boolean delete;

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Permission{" + "read=" + read + ", write=" + write + ", delete=" + delete + '}';
    }
    
}
