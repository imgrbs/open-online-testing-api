/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.form.controller;

import com.depa.form.dto.UserViewExamDTO;
import com.depa.form.model.acl.ResoucePrivilege;
import com.depa.form.model.resource.Exam;
import com.depa.form.model.resource.Problem;
import com.depa.form.service.internal.AcessControlImpl;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private AcessControlImpl accessControlImpl;
            
    @PostMapping("/isHadPermission")
    public Object isHadPermission(@RequestBody UserViewExamDTO userViewExam) {
        System.out.println(userViewExam);
        accessControlImpl.isHadPermission();
        HashMap<String, Object> response = new HashMap();
        response.put("isHadPermission", false);
        return response;
    }

}
