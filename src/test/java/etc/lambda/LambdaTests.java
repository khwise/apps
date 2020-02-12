package etc.lambda;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by kh.jin on 2020. 2. 8.
 */
public class LambdaTests {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private Map<Integer,String> map;

    @Before
    public void setup() {

    }

    @Test
    public void _test_supplier() {
        // Given
        Supplier<Map> testMap = () -> this.add();
        String expect = "first";

        //When
        String act = testMap.get().get(1).toString();

        // Then
        MatcherAssert.assertThat(act, Is.is(expect));
    }

    private Map<Integer, String> add() {
        map = new HashMap<>();
        map.put(1, "first");
        map.put(2, "first");

        return map;
    }

    @Test
    public void _test_consumer() {
        // Given

    }
}
