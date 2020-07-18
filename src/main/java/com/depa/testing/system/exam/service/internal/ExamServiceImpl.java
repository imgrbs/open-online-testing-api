package com.depa.testing.system.exam.service.internal;

import com.depa.testing.system.exam.dto.ExamDTO;
import com.depa.testing.system.exam.dto.impl.ExamDTOImpl;
import com.depa.testing.system.exam.model.exam.Exam;
import com.depa.testing.system.exam.repository.ExamRepository;
import com.depa.testing.system.exam.service.ExamService;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Setter
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Override
    public ExamDTO createExam(ExamDTO examDTO) {
        Exam exam = examRepository.save(examDTO.toExam());
        return toExamDTO(exam);
    }

    @Override
    public List<ExamDTO> getExams() {
        List<Exam> queryExams = this.examRepository.findAll();

        ArrayList<ExamDTO> exams = new ArrayList<>();
        queryExams.forEach(exam -> exams.add(toExamDTO(exam)));
        return exams;
    }

    @Override
    public ExamDTO getExamById(ObjectId id) {
        return toExamDTO(examRepository.findById(id).get());
    }

    @Override
    public ExamDTO toExamDTO(Exam exam) {
        return new ExamDTOImpl(exam);
    }
}
