package jackson_java_objects_to_json;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        FootBallPlayer footBallPlayer = new FootBallPlayer("Henry", 14);
        String jsonString = objectMapper.writeValueAsString(footBallPlayer);
        System.out.println(jsonString);
    }
}

class FootBallPlayer {

    public String name;
    public int number;

    public FootBallPlayer(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}