package com.jobinterviewer;

import com.jobinterviewer.service.InterviewService;
import com.jobinterviewer.model.Question;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the InterviewService class.
 * Uses JUnit 5 (Jupiter) for assertions and test execution.
 */
public class InterviewerServiceTest {

    /**
     * Test to ensure that fetching questions
     * returns a non-null list (even if it may be empty).
     *
     * @throws Exception if the database interaction fails
     */
    @Test
    public void testFetchQuestionsReturnsList() throws Exception {
        InterviewService service = new InterviewService();

        // Act: fetch questions from the service
        List<Question> questions = service.fetchQuestions();

        // Assert: ensure the list is not null
        assertNotNull(questions, "Questions list should not be null");
    }

    /**
     * Test to ensure that registering a valid candidate
     * does not throw any exception.
     *
     * @throws Exception if the database interaction fails
     */
    @Test
    public void testRegisterCandidateValid() throws Exception {
        InterviewService service = new InterviewService();

        // Act & Assert: registering a candidate should not throw an error
        assertDoesNotThrow(() -> service.registerCandidate("Alice", "alice@example.com"),
                "Registering a valid candidate should not throw an exception");
    }
}
