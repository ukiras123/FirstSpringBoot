package com.kiran.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kiran.model.Question;
import com.kiran.model.Survey;

@Component
public class SurveyService {
    private static List<Survey> surveys = new ArrayList<>();
    static {
        Question question1 = new Question("Question1",
				"Who is CEO of OCEANX?", "George", Arrays.asList("Kiran", "George", "Barry", "Peter"));
        Question question2 = new Question("Question2",
				"Where is OceanX?", "El Segundo", Arrays.asList("El Segundo", "Santa Monica", "SFO", "China"));
        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
				question2));

		Survey survey = new Survey("Survey1", "OceanX Survey",
				"Lets see what u got?", questions);

        surveys.add(survey);
    }

    public List<Survey> retrieveAllSurveys() {
        return surveys;
    }

    public Survey retrieveSurvey(String surveyId) {
        for (Survey survey : surveys) {
            if (survey.getId().equals(surveyId)) {
                return survey;
            }
        }
        return null;
    }

    public List<Question> retrieveQuestions(String surveyId) {
        Survey survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        return survey.getQuestions();
    }

    public Question retrieveQuestion(String surveyId, String questionId) {
        Survey survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        for (Question question : survey.getQuestions()) {
            if (question.getId().equals(questionId)) {
                return question;
            }
        }

        return null;
    }

    private SecureRandom random = new SecureRandom();

    public Question addQuestion(String surveyId, Question question) {
        Survey survey = retrieveSurvey(surveyId);

        if (survey == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        question.setId(randomId);

        survey.getQuestions().add(question);

        return question;
    }
}