/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.model.resource;

/**
 *
 * @author Test
 */
public class Problem extends AbstractResource{
    
    private String problemId;
    
    private String problemName;

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    @Override
    public String toString() {
        return "Problem{" + "problemId=" + problemId + ", problemName=" + problemName + '}';
    }
    
}
