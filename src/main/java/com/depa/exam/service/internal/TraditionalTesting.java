/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.depa.exam.service.internal;

import com.depa.exam.dto.ExamAnswerDTO;
import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamAnswerDTOImpl;
import com.depa.exam.dto.impl.ExamDTOImpl;
import com.depa.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.model.question.Question;
import com.depa.exam.repository.ExamRepository;
import com.depa.exam.service.ExamStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Test
 */

public class TraditionalTesting extends ExamServiceImpl  implements ExamStrategy {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public ExamDTO generateExamination(ObjectId id) {
        ExamDTO examWithQuestion = super.getExamById(id);
        Collections.shuffle(examWithQuestion.getQuestions());
        return examWithQuestion;
    }

    @Override
    public List<ExamDTO> getExams() {
        List<Exam> queryExams = this.examRepository.findAll();
        ArrayList<ExamDTO> exams = new ArrayList<>();
        queryExams.forEach(exam -> exams.add(toExamExcludeQuestionDTOImpl(exam)));
        return exams;
    }

    @Override
    public ExamDTO getExamById(ObjectId id) {
        return toExamExcludeQuestionDTOImpl(examRepository.findById(id).get());
    }

    public ExamDTO toExamExcludeQuestionDTOImpl(Exam exam) {
        return new ExamExcludeQuestionDTOImpl(exam);
    }

    @Override
    public void submitExamAllAnswer(ObjectId examId, List<ExamAnswerDTOImpl> examAnswer) {
        System.out.println(examId);
        System.out.println("=============");
        System.out.println(examAnswer);
        System.out.println("submit override !!!");
        Exam examInDatabase = examRepository.findById(examId).get();
        if(examInDatabase !=null){
            List<Question> questions = examInDatabase.getQuestions();
        }
    }

}
