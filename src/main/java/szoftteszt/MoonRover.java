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

    int dy = 0;
    if (direction == Direction.NORTH) {
        dy = 1;
    }
    else if (direction == Direction.SOUTH) {
        dy = -1;
    }

    int ny = y + dy;    
    if (ny > MAX_HEIGHT) {
        ny = 0;
    }
    if (ny < 0) {
    ny = MAX_HEIGHT;
    }    
    if (ny == 0 && (direction == Direction.NORTH || direction == Direction.SOUTH)) {
        direction = direction.opposite();
    }

    return new Coordinate(x, ny);
}

}