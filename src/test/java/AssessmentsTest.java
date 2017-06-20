import com.continuum.Assessment;
import com.continuum.Assessments;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class AssessmentsTest {

    Assessments assessments;
    String dateAssessed = "testDate";
    String portfolioName = "portfolioName";
    ArrayList<Assessment> assessmentArray;

    @Before
    public void setUp(){
        assessmentArray = new ArrayList<Assessment>();
        assessments = new Assessments(dateAssessed, portfolioName, assessmentArray);
    }

    @Test
    public void shouldKnowHowToDefineAssessments(){
        assertEquals(assessments.getClass(), Assessments.class);
    }

    @Test
    public void shouldKnowTwoAssessmentsWithSameValuesAreEqual(){
        Assessments anotherAssessments = new Assessments(dateAssessed, portfolioName, assessmentArray);
        assertThat(assessments, is(equalTo(anotherAssessments)));
    }

    @Test
    public void shouldKnowTwoAssessmentsWithDifferentDateAssessedValuesAreEqual(){
        String anotherDateAssessed = "anotherTestDate";
        Assessments anotherAssessments = new Assessments(anotherDateAssessed, portfolioName, assessmentArray);
        assertThat(assessments, is(not(equalTo(anotherAssessments))));
    }

    @Test
    public void shouldKnowTwoAssessmentsWithDifferentPortfolioNameValuesAreEqual(){
        String anotherPortfolioName = "anotherTestDate";
        Assessments anotherAssessments = new Assessments(dateAssessed, anotherPortfolioName, assessmentArray);
        assertThat(assessments, is(not(equalTo(anotherAssessments))));
    }

    @Test
    public void shouldKnowTwoAssessmentsWithDifferentAssessmentValuesAreEqual(){
        ArrayList<Assessment> anotherAssessmentsArray = new ArrayList<Assessment>();
        anotherAssessmentsArray.add(new Assessment());
        Assessments anotherAssessments = new Assessments(dateAssessed, portfolioName, anotherAssessmentsArray);
        assertThat(assessments, is(not(equalTo(anotherAssessments))));
    }

    @Test
    public void shouldKnowTwoAssessmentsWithSameAssessmentValuesAreEqual(){
        ArrayList<Assessment> anotherAssessmentsArray = new ArrayList<Assessment>();
        Assessment assessment = new Assessment();
        assessmentArray.add(assessment);
        anotherAssessmentsArray.add(assessment);

        assessments = new Assessments(dateAssessed, portfolioName, assessmentArray);
        Assessments anotherAssessments = new Assessments(dateAssessed, portfolioName, anotherAssessmentsArray);

        assertThat(assessments, is(equalTo(anotherAssessments)));
    }
}
