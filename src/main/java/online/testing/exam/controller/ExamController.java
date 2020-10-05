package online.testing.exam.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import online.testing.exam.dto.ExamDTO;
import online.testing.exam.dto.impl.ExamDTOImpl;
import online.testing.exam.model.answer.ExamAnswer;
import online.testing.exam.model.answer.QuestionAnswer;
import online.testing.exam.service.CategoryService;
import online.testing.exam.service.ExamService;
import online.testing.user.dto.UserPrincipal;
import online.testing.user.model.user.User;
import online.testing.user.repository.UserRepository;

@Setter
@RestController
@CrossOrigin(origins = "*")
/**
 * /v2 is method that extend by son for safety migration
 */
public class ExamController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExamService examService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/exam")
    public ResponseEntity<ExamDTO> createExam(
            Principal principal,
            @RequestBody ExamDTOImpl exam
    ) {
        UserPrincipal userPrincipal = (UserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        exam.getQuestions().forEach(categoryDTO -> {
            categoryDTO.getCategories().forEach((category) -> {
                categoryService.createCategory(category);
            });
        });
        ExamDTO createdExam = examService.createExam(exam, userPrincipal.getId());
        return new ResponseEntity<>(createdExam, HttpStatus.CREATED);
    }

    @GetMapping("/exam/{uid}")
    public ResponseEntity<ExamDTO> getExamByObjectId(@PathVariable String uid) {
        ExamDTO exam = examService.getExamById(uid);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/exam/{uid}/questions")
    public ResponseEntity<ExamDTO> getExamDetailById(@PathVariable String uid) {
        ExamDTO exam = examService.generateExamination(uid);
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }

    @GetMapping("/exams")
    public ResponseEntity<List<ExamDTO>> getExams(Principal principal) {
        UserPrincipal userPrincipal = (UserPrincipal) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        List<ExamDTO> exams = examService.getExams(userPrincipal.getId());

        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @PostMapping("/exam/{examId}/answer/submit")
    public ResponseEntity submitExamAllAnswer(
            Authentication authentication,
            @RequestHeader(name = "Authorization", required = false) String jwt,
            @PathVariable String examId, @RequestBody List<QuestionAnswer> questionAnswer) {
        ExamAnswer examAnswer = new ExamAnswer();
        examAnswer.setQuestionAnswerList(questionAnswer);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        User user = (User) userRepository.findById(userPrincipal.getId()).get();
        ExamAnswer submitExamAllAnswer = examService.submitExamAllAnswer(examId, examAnswer);
        return new ResponseEntity<>(submitExamAllAnswer, HttpStatus.CREATED);
    }

    @PostMapping("/grading/exam/{examId}/static")
    public ResponseEntity<ExamDTO> staticGrading(@PathVariable String examId) {
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }
}
