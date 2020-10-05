package online.testing.exam.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import online.testing.exam.dto.QuestionDTO;
import online.testing.exam.dto.impl.CategoryDTOImpl;
import online.testing.exam.dto.impl.QuestionDTOImpl;
import online.testing.exam.model.question.Question;
import online.testing.exam.model.question.SubjectiveQuestion;
import online.testing.exam.service.CategoryService;
import online.testing.exam.service.QuestionService;
import online.testing.user.dto.UserPrincipal;
import online.testing.user.model.user.User;

class QuestionControllerTest {
	private final Mockery mockery = new JUnit4Mockery();

	private QuestionController underTest;
	private QuestionService mockQuestionService;
	private CategoryService mockCategoryService;

	@BeforeEach
	void setUp() {
		underTest = new QuestionController();
		mockQuestionService = mockery.mock(QuestionService.class);
		underTest.setQuestionService(mockQuestionService);
		mockCategoryService = mockery.mock(CategoryService.class);
		underTest.setCategoryService(mockCategoryService);
	}

	@Test
	void testGetQuestionsShouldReturnListOfQuestionModel() {
		User user = createUser();
		UserPrincipal principal = UserPrincipal.create(user, new HashMap<>());
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal, null);
		SubjectiveQuestion expectedQuestion = SubjectiveQuestion.create("1 + 1 = ?", null, new ArrayList<>());
		QuestionDTO expectedQuestionDTO = new QuestionDTOImpl(expectedQuestion);

		expectGetQuestions(principal, expectedQuestionDTO);

		ResponseEntity<List<QuestionDTO>> result = underTest.getQuestions(token);
		List<QuestionDTO> actualResult = result.getBody();

		Assert.assertThat(actualResult.size(), CoreMatchers.equalTo(1));
		Assert.assertThat(actualResult.get(0), CoreMatchers.equalTo(expectedQuestionDTO));
	}

	private void expectGetQuestions(UserPrincipal principal, QuestionDTO expectedQuestionDTO) {
		mockery.checking(new Expectations() {
			{
				oneOf(mockQuestionService).getQuestionsByUserId(principal.getId());
				will(returnValue(Arrays.asList(expectedQuestionDTO)));
			}
		});
	}

	private User createUser() {
		User user = mockery.mock(User.class);
		mockery.checking(new Expectations() {
			{
				oneOf(user).getId();
				will(returnValue("xxx"));
				oneOf(user).getEmail();
				will(returnValue("depa@gmail.com"));
				oneOf(user).getPassword();
				will(returnValue("xxx"));
				oneOf(user).getAttributes();
				will(returnValue(Map.of()));
			}
		});
		return user;
	}

	@Test
	void testCreateQuestion() {
		User user = createUser();
		UserPrincipal userPrincipal = UserPrincipal.create(user, new HashMap<>());
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userPrincipal, null);

		CategoryDTOImpl categoryDTO = createCategoryDTO();
		Question question = SubjectiveQuestion.create("1 + 1 = ?", null, Arrays.asList(categoryDTO));
		QuestionDTOImpl request = new QuestionDTOImpl(question);
		request.setOwnerId(userPrincipal.getId());

		mockery.checking(new Expectations() {
			{
				oneOf(mockQuestionService).createQuestion(request);
				will(returnValue(request));

				oneOf(mockCategoryService).createCategory(categoryDTO);
				will(returnValue(categoryDTO));
			}
		});

		ResponseEntity<QuestionDTO> result = underTest.createQuestion(token, request);

		mockery.assertIsSatisfied();
		Assert.assertThat(result.getStatusCode(), CoreMatchers.equalTo(HttpStatus.CREATED));
		Assert.assertThat(result.getBody(), CoreMatchers.equalTo(request));
	}

	private CategoryDTOImpl createCategoryDTO() {
		CategoryDTOImpl categoryDTO = new CategoryDTOImpl();
		categoryDTO.setLabel("history");
		categoryDTO.setBackgroundColor("#000000");
		categoryDTO.setColor("#ffffff");
		return categoryDTO;
	}
}
