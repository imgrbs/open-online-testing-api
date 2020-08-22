/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.service.internal;

import com.depa.form.model.acl.ResoucePrivilege;
import com.depa.form.model.resource.Exam;
import com.depa.form.model.resource.Problem;
import com.depa.form.service.InterfaceAccessControl;
import org.springframework.stereotype.Service;

/**
 *
 * @author Test
 */
@Service
public class AcessControlImpl implements InterfaceAccessControl {

    @Override
    public boolean isHadPermission() {
        Problem existingProblem1 = new Problem();
        existingProblem1.setProblemId("problem-1-dmsjf9q2");
        existingProblem1.setProblemName("Which are distribute tracing products (Select all correct answer from choice)");

        Problem existingProblem2 = new Problem();
        existingProblem2.setProblemId("problem-2-dmsjf9q2");
        existingProblem2.setProblemName("Describe characacteristic of good practice in keeping logs (In you opinion and the reason and theory behind your ideas)");

        Exam existingExam = new Exam();
        existingExam.setExamId("existing_543-to-d@y");
        existingExam.setExamName("Cloud Native: Distribute Tracing");
        ResoucePrivilege resoucePrivilege = new ResoucePrivilege();
        existingExam.addResourceGroup(resoucePrivilege);
        return false;
    }

}
