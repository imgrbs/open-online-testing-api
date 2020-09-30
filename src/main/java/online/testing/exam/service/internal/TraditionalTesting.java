/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online.testing.exam.service.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.testing.exam.dto.ExamDTO;
import online.testing.exam.dto.impl.ExamAnswerDTOImpl;
import online.testing.exam.dto.impl.ExamDTOImpl;
import online.testing.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.model.question.Question;
import online.testing.exam.repository.ExamRepository;

/**
 *
 * @author Test
 */
@Service
public class TraditionalTesting implements ExaminationStrategy {

    @Autowired
    private ExamRepository examRepository;

    public ExamDTO generateExamination(ExamDTO examWithQuestion) {
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

    public ExamDTO getExamById(String id) {
        Optional<Exam> get = examRepository.findById(id);
        return toExamExcludeQuestionDTOImpl(examRepository.findById(id).get());
    }

    public ExamDTO toExamExcludeQuestionDTOImpl(Exam exam) {
        return new ExamExcludeQuestionDTOImpl(exam);
    }

    public void submitExamAllAnswer(String examId, List<ExamAnswerDTOImpl> examAnswer) {
        Exam examInDatabase = examRepository.findById(examId).get();
        if (examInDatabase != null) {
            List<Question> questions = examInDatabase.getQuestions();
        }
    }

}
