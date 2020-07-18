package com.depa.testing.system.exam.service;

import com.depa.testing.system.exam.dto.ExamDTO;
import com.depa.testing.system.exam.model.exam.Exam;
import com.depa.testing.system.exam.repository.ExamRepository;
import org.bson.types.ObjectId;

import java.util.List;

public interface ExamService {
    void setExamRepository(ExamRepository mockExamRepository);

    ExamDTO createExam(ExamDTO exam);

    List<ExamDTO> getExams();

    ExamDTO getExamById(ObjectId id);

    ExamDTO toExamDTO(Exam exam);
}
