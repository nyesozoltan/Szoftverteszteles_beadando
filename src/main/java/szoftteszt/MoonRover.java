package szoftteszt;

import static szoftteszt.Direction.NORTH;
class MoonRover {

    private static final  int MAX_HEIGHT = 8;
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
    int x = coordinate.x();
    int y = coordinate.y();

    if (direction == Direction.NORTH) {
        if (y == MAX_HEIGHT) {        
            y = 0;
            direction = Direction.SOUTH;
        } else {
            y += 1;
        }
    } else if (direction == Direction.SOUTH) {
        if (y == 0) {             
            y = MAX_HEIGHT;
            direction = Direction.NORTH;
        } else {
            y -= 1;
        }
    }    
    return new Coordinate(x, y);
}
}