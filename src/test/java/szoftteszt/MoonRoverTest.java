package  szoftteszt;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MoonRoverTest {

    @Test 
    void rotate_right() {
        MoonRover moonrover = new MoonRover();
        assertThat(moonrover.execute("R"), is("0:0:E"));       
    }

}