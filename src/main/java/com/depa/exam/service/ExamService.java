package com.depa.exam.service;

import com.depa.exam.dto.ExamAnswerDTO;
import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamAnswerDTOImpl;
import com.depa.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.repository.ExamRepository;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExamService {
    void setExamRepository(ExamRepository mockExamRepository);

    ExamDTO createExam(ExamDTO exam);

    List<ExamDTO> getExams();
    
    ExamDTO generateExamination(String id);

    ExamDTO getExamById(String id);

    ExamDTO toExamDTO(Exam exam);

    public void submitExamAllAnswer(ObjectId examId,List<ExamAnswerDTOImpl> examAnswer);

    public ExamExcludeQuestionDTOImpl getExamTopicByExamId(String uid);
    
    
}
