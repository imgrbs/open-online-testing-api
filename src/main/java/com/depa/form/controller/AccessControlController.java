/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.controller;

import com.depa.form.dto.UserViewExamDTO;
import com.depa.form.model.resource.Exam;
import com.depa.form.model.resource.Problem;
import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Test
 */
@RestController
public class AccessControlController {

    @PostMapping("/isHadPermission")
    public Object isHadPermission(@RequestBody UserViewExamDTO userViewExam) {
        System.out.println(userViewExam);
        HashMap<String, Object> response = new HashMap();
        Problem existingProblem1 = new Problem();
        existingProblem1.setProblemId("problem-1-dmsjf9q2");
        existingProblem1.setProblemName("Which are distribute tracing products (Select all correct answer from choice)");
        
        Problem existingProblem2 = new Problem();
        existingProblem2.setProblemId("problem-2-dmsjf9q2");
        existingProblem1.setProblemName("Describe characacteristic of good practice in keeping logs (In you opinion and the reason and theory behind your ideas)");
        
        Exam existingExam = new Exam();
        existingExam.setExamId("existing_543-to-d@y");
        existingExam.setExamName("Cloud Native: Distribute Tracing");

        response.put("isHadPermission", false);
        return response;
    }

}
