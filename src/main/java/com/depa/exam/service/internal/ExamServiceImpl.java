package com.depa.exam.service.internal;

import com.depa.exam.dto.ExamAnswerDTO;
import com.depa.exam.dto.ExamDTO;
import com.depa.exam.dto.impl.ExamAnswerDTOImpl;
import com.depa.exam.dto.impl.ExamDTOImpl;
import com.depa.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import com.depa.exam.model.answer.ExamAnswer;
import com.depa.exam.model.exam.Exam;
import com.depa.exam.model.exam.ExamType;
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
import org.springframework.web.bind.annotation.RequestHeader;

@Setter
@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ExaminationContext examinationContext;

    @Autowired
    private TraditionalTesting traditionalTesting;

    @Autowired
    private AdaptiveTesting adaptiveTesting;

    @Override
    public ExamDTO createExam(ExamDTO examDTO) {
        System.out.println("!!! Create Exam DTO !!!");
        System.out.println(examDTO.toExam().getQuestions().get(0).getId());
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
    public ExamDTO getExamById(String id) {
        return toExamDTO(examRepository.findById(id).get());
    }

    public ExamExcludeQuestionDTOImpl getExamTopicByExamId(String id) {
        System.out.println(" Get Exam by ID : " + id);
        return new ExamExcludeQuestionDTOImpl(examRepository.findById(id).get());
    }

    @Override
    public ExamDTO toExamDTO(Exam exam) {
        return new ExamDTOImpl(exam);
    }

    @Override
    public ExamDTO generateExamination(String examId) {
        System.out.println(examId);
        ExamDTO examFromDatabase = this.getExamById(examId);
        if (examFromDatabase.getType().equals(ExamType.TRADITIONAL)) {
            examinationContext.setExaminationContext(traditionalTesting);
        } else {
            examinationContext.setExaminationContext(adaptiveTesting);
        }
        ExamDTO generatedExamination = examinationContext.generateExamination(examFromDatabase);
        System.out.println(examFromDatabase);
        return examFromDatabase;
    }

    public void submitExamAllAnswer(
            String examId, List<ExamAnswer> examAnswer) {
        System.out.println(examAnswer);

    }

}
