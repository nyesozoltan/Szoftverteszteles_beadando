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
        "LLLL, 0:0:N"        
    }) 

    public void
    rotate_left(String commands, String position) {
         assertThat(moonrover.execute(commands), is(position));              
    }

   @ParameterizedTest
    @CsvSource({
        "F, 0:1:N",
        "FFFFF, 0:5:N",
        "FFFFFFFFF, 0:9:S",
        "FFFFFFFFFF, 0:8:S",
        "FFFFFFFFFFFFFFFFFF, 0:0:N"                                                       
    }) 

    public void
    move_forward(String commands, String position) {
         assertThat(moonrover.execute(commands), is(position));              
    }

    @ParameterizedTest
     @CsvSource({
        "RF, 1:0:E",
        "RFFFFF, 5:0:E",
        "RFFFFFFFFF, 0:0:E",
        "RFFFFFFFFFFFFFF, 5:0:E"                                               
    }) 

    public void
    move_right(String commands, String position) {
         assertThat(moonrover.execute(commands), is(position));              
    }

    @ParameterizedTest
     @CsvSource({
        "LF, 8:0:W",
        "LFFFFF, 4:0:W",
        "LFFFFFFFFFF, 8:0:W",                                                       
    }) 

    public void
    move_left(String commands, String position) {
         assertThat(moonrover.execute(commands), is(position));              
    }

    @ParameterizedTest
     @CsvSource({
        "B, 0:1:S",
        "BB, 0:2:S",                                                              
    }) 

    public void
    move_backward_when_facing_north(String commands, String position) {
         assertThat(moonrover.execute(commands), is(position));              
    }

}
    