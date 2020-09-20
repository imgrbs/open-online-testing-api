package com.depa.exam.service.internal;

import com.depa.exam.dto.ExamAnswerDTO;
import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamAnswerDTOImpl;
import com.depa.exam.dto.impl.ExamDTOImpl;
import com.depa.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.repository.ExamRepository;
import com.depa.exam.service.ExamService;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Projections;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.MongoTemplate;

@Setter
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;
    
    @Autowired
    private ExaminationContext examinationContext;

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

    public ExamDTO toExamExcludeQuestionDTOImpl(Exam exam) {
        return new ExamExcludeQuestionDTOImpl(exam);
    }

    @Override
    public ExamDTO generateExamination(ObjectId examId) {
        ExaminationStrategy context = (ExaminationStrategy) new TraditionalTesting();
        examinationContext.setExaminationContext(context);
        examinationContext.generateExaminationByExamId(examId);
        return null;
    }

    @Override
    public void submitExamAllAnswer(ObjectId examId, List<ExamAnswerDTOImpl> examAnswer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
