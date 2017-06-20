import com.continuum.JsonUtil;
import com.google.gson.Gson;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class JsonUtilTest {
    @Test
    public void shouldTestTheToJSonMethodForObjects(){
        Object testObject = "{'name': 'value'}";

        String expectedOutput = new Gson().toJson(testObject);
        String output = JsonUtil.toJson(testObject);

        assertEquals(output, expectedOutput);
    }

    @Test
    public void shouldTestTheToJSonMethodForObjectsIsNotTheSameForDifferentObjects(){
        Object testObject = "{'name': 'value'}";
        Object anotherTestObject = "{'name': 'value1'}";

        String expectedOutput = new Gson().toJson(anotherTestObject);
        String output = JsonUtil.toJson(testObject);

        assertThat(output, is(not(equalTo(expectedOutput))));
    }

}
