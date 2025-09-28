package szoftteszt;

class MoonRover {

    String direction = "N";

    String execute(String commands) {
        for (char c : commands.toCharArray()) {            
                if (direction == "E") {
                    direction = "S";                
                }
                if (direction == "N") {
                    direction = "E";                
                }            
        }
       return "0:0:" + direction;       
    }
}