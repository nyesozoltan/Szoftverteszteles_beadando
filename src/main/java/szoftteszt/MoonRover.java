package szoftteszt;

import static szoftteszt.Direction.NORTH;
class MoonRover {

    Direction direction = NORTH;
    Coordinate coordinate = new Coordinate(0, 0);

    String execute(String commands) {
        for (char c : commands.toCharArray()) {
            if (c == 'R') {
                direction = direction.right();
            }
            if (c == 'L') {
                direction = direction.left();
            }
            if (c == 'F') {
                coordinate = forward();
            }                                   
        }
       return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();      
    }
    
    private Coordinate forward() {
        int y = 0;
        if (direction == NORTH) {
            y += 1;
        }
        return new Coordinate(coordinate.x(), y);
    }
}