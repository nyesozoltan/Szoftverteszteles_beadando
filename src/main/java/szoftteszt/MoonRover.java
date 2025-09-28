package szoftteszt;

class MoonRover {

    String direction = "N";

    String execute(String commands) {
        for (char c : commands.toCharArray()) {
            direction = rotateRight();                     
        }
       return "0:0:" + direction;       
    }

    private String rotateRight() {
        if (direction == "N") {
            return "E";             
        } else {
            return "S";              
        }        
    }
}