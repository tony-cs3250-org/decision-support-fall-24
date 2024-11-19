/*
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {

    private Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testUserInput() {
        //mocking what user input should look like
        String input = "Choose a career path\nEngineer\nArtist\nTeacher\ndone\nSalary 0.5\nJob Security 0.3\nPersonal Fulfillment 0.2\ndone\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //call userInput and capture the Decision object
        Decision result = Main.userInput();

        //verify that result is a valid Decision object
        assertNotNull(result);
        assertEquals("Choose a career path", result.getProblemStatement());
        assertEquals(List.of("Engineer", "Artist", "Teacher"), result.getAlternatives());
        assertEquals(Map.of("Salary", 0.5, "Job Security", 0.3, "Personal Fulfillment", 0.2), result.getFactors());
    }
}*/

