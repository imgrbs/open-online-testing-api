package online.testing.exam.service.internal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import online.testing.exam.dto.ExamDTO;
import online.testing.exam.dto.impl.ExamDTOImpl;
import online.testing.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import online.testing.exam.model.answer.ExamAnswer;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.model.exam.ExamType;
import online.testing.exam.repository.ExamAnswerRepository;
import online.testing.exam.repository.ExamRepository;
import online.testing.exam.service.ExamService;

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

    @Autowired
    private ExamAnswerRepository examAnswerRepository;

    @Override
    public ExamDTO createExam(ExamDTO examDTO, String ownerId) {
        Exam toExam = examDTO.toExam();
        toExam.setOwnerId(ownerId);
        Exam exam = examRepository.save(toExam);
        return toExamDTO(exam);
    }

    @Override
    public List<ExamDTO> getExams(String ownerId) {
        List<Exam> queryExams = this.examRepository.findByOwnerId(ownerId);
        ArrayList<ExamDTO> exams = new ArrayList<>();
        queryExams.forEach(exam -> exams.add(toExamDTO(exam)));
        return exams;
    }

    @Override
    public ExamDTO getExamById(String id) {
        return toExamDTO(examRepository.findById(id).get());
    }

    public ExamExcludeQuestionDTOImpl getExamTopicByExamId(String id) {
        return new ExamExcludeQuestionDTOImpl(examRepository.findById(id).get());
    }

    @Override
    public ExamDTO toExamDTO(Exam exam) {
        return new ExamDTOImpl(exam);
    }

    @Override
    public ExamDTO generateExamination(String examId) {
        ExamDTO examFromDatabase = this.getExamById(examId);
        if (examFromDatabase.getType().equals(ExamType.TRADITIONAL)) {
            examinationContext.setExaminationContext(traditionalTesting);
        } else {
            examinationContext.setExaminationContext(adaptiveTesting);
        }
        ExamDTO generatedExamination = examinationContext.generateExamination(examFromDatabase);
        return examFromDatabase;
    }

    @Override
    public ExamAnswer submitExamAllAnswer(String examId, ExamAnswer examAnswer) {
        ExamAnswer savedExamAnswer = examAnswerRepository.save(examAnswer);
        return savedExamAnswer;
    }

}
