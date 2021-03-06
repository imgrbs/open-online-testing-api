package online.testing.exam.service;

import java.util.List;

import online.testing.exam.dto.ExamDTO;
import online.testing.exam.dto.impl.ExamExcludeQuestionDTOImpl;
import online.testing.exam.model.answer.ExamAnswer;
import online.testing.exam.model.exam.Exam;
import online.testing.exam.repository.ExamRepository;

public interface ExamService {
    void setExamRepository(ExamRepository mockExamRepository);

    ExamDTO createExam(ExamDTO exam, String ownerId);

    List<ExamDTO> getExams(String ownerId);
    
    ExamDTO generateExamination(String id);

    ExamDTO getExamById(String id);

    ExamDTO toExamDTO(Exam exam);

    public ExamAnswer submitExamAllAnswer(String examId,ExamAnswer examAnswer);

    public ExamExcludeQuestionDTOImpl getExamTopicByExamId(String uid);
    
    
}
