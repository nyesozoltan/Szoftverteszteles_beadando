package szoftteszt;

class MoonRover {

    String direction = "N";

    String execute(String commands) {
        for (char c : commands.toCharArray()) {
            direction = rotateRight(direction);                     
        }
       return "0:0:" + direction;       
    }

    private String rotateRight(String direction) {
        return switch (direction) {
            case "N" -> "E";
            case "E" -> "S";
            case "S" -> "W";
            case "W" -> "N";
            default -> direction;
        };
    }
}