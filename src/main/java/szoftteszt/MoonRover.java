package szoftteszt;

import static szoftteszt.Direction.NORTH;

class MoonRover {

    private static final  int MAX_HEIGHT = 9;
    private static final  int MAX_WIDTH = 9;
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
                coordinate = move();
            }
            if (c == 'B') {
                coordinate = moveBackward();
}                                            
        }
       return coordinate.x() + ":" + coordinate.y() + ":" + direction.value();      
    }    
   
    private Coordinate move() {
    int x = coordinate.x();
    int y = coordinate.y();

    int ny = y;
    if (direction == Direction.NORTH) {
        ny = y + 1;
        if (ny > MAX_HEIGHT) {            // 9 fölé lépnénk -> 0-ra wrap + flip N->S
            ny = 0;
            direction = direction.opposite(); // N -> S
        } else if (ny == MAX_HEIGHT) {    // pont az északi pólusra értünk -> flip N->S
            direction = direction.opposite();
        }
    } else if (direction == Direction.SOUTH) {
        ny = y - 1;
        if (ny < 0) {                     // 0 alá lépnénk -> 9-re wrap + flip S->N
            ny = MAX_HEIGHT;
            direction = direction.opposite(); // S -> N
        } else if (ny == 0) {             // pont a déli pólusra értünk -> flip S->N
            direction = direction.opposite();
        }
    }

    if (direction == Direction.EAST) {
        x = (x + 1) % MAX_WIDTH;
    } 
     if (direction == Direction.WEST) {
        x = (x == 0) ? MAX_WIDTH - 1 : x - 1;
    } 

    return new Coordinate(x, ny);
}

private Coordinate moveBackward() {
    int x = coordinate.x();
    int y = coordinate.y();
    
    if (direction == Direction.NORTH) {
        if (y == 0) {            
            y = 1;
            direction = direction.opposite();
        } else {
            y = y - 1;
        }
    }  else if (direction == Direction.SOUTH) {       
        y = y + 1;        
    }

    return new Coordinate(x, y);
}

}