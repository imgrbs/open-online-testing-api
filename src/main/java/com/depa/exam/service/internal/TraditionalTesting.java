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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Test
 */
@Service
public class TraditionalTesting implements ExaminationStrategy {

    @Autowired
    private ExamRepository examRepository;

    public ExamDTO generateExamination(ExamDTO examWithQuestion) {
        System.out.println("=== Traditional Generated ===");
        Collections.shuffle(examWithQuestion.getQuestions());
        return examWithQuestion;
    }

    public ExamDTO toExamDTO(Exam exam) {
        return new ExamDTOImpl(exam);
    }

    public List<ExamDTO> getExams() {
        List<Exam> queryExams = this.examRepository.findAll();
        ArrayList<ExamDTO> exams = new ArrayList<>();
        queryExams.forEach(exam -> exams.add(toExamExcludeQuestionDTOImpl(exam)));
        return exams;
    }

    public ExamDTO getExamById(ObjectId id) {
        System.out.println("!! Repository is null");
        System.out.println(examRepository);
        Optional<Exam> get = examRepository.findById(id);
        System.out.println(get);
        return toExamExcludeQuestionDTOImpl(examRepository.findById(id).get());
    }

    public ExamDTO toExamExcludeQuestionDTOImpl(Exam exam) {
        return new ExamExcludeQuestionDTOImpl(exam);
    }

    public void submitExamAllAnswer(ObjectId examId, List<ExamAnswerDTOImpl> examAnswer) {
        System.out.println(examId);
        System.out.println("=============");
        System.out.println(examAnswer);
        System.out.println("submit override !!!");
        Exam examInDatabase = examRepository.findById(examId).get();
        if (examInDatabase != null) {
            List<Question> questions = examInDatabase.getQuestions();
        }
    }

}
