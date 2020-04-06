/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.model.field;

/**
 *
 * @author Test
 */
public class FieldDataSize extends FieldData{
    
    private int rows;
    
    private int cols;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    @Override
    public String toString() {
        return "FieldDataSize{" + "rows=" + rows + ", cols=" + cols + '}';
    }
    
    
    
}
