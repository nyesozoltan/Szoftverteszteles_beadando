package  szoftteszt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class MoonRoverTest {

    private MoonRover moonrover;

    @BeforeEach
    public void initialise() {
        moonrover = new MoonRover();
    }

   @ParameterizedTest
    @CsvSource({
        "R, 0:0:E",
        "RR, 0:0:S",
        "RRR, 0:0:W",
        "RRRR, 0:0:N"
    }) 

    public void
    rotate_right(String commands, String position) {
         assertThat(moonrover.execute(commands), is(position));              
    }

   @ParameterizedTest
    @CsvSource({
        "L, 0:0:W",
        "LL, 0:0:S",
        "LLL, 0:0:E",        
    }) 

    public void
    rotate_left(String commands, String position) {
         assertThat(moonrover.execute(commands), is(position));              
    }
}