package jackson_de_serialisation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MainWithSerialization {

    public static void main(String[] args)
            throws JsonParseException, JsonMappingException, IOException {
        String jsonString = "{\"name\":\"chicago\", \"number\":\"22\"}"; // "{\"name\":\"Henry\",
                                                                         // \"number\":10}";

        ObjectMapper objectMapper = new ObjectMapper();
        VolleyBallPlayer player = objectMapper.readValue(jsonString, VolleyBallPlayer.class);
        System.out.println(player.getName());
        System.out.println(player.getNumber());
        readValueWithFile(objectMapper);
        readValueFromList(objectMapper);
        serializeMap(objectMapper);
    }

    private static void readValueFromList(ObjectMapper objectMapper)
            throws JsonProcessingException {
        // Write all the elements of the list but not in key/value pair
        List<String> nameOfFruits = new ArrayList<String>();
        nameOfFruits.add("oranges");
        nameOfFruits.add("Mangoes");
        nameOfFruits.add("Apples");

        String writeValueAsString = objectMapper.writeValueAsString(nameOfFruits);
        System.out.println(writeValueAsString);
    }

    private static void readValueWithFile(ObjectMapper mapper)
            throws JsonParseException, JsonMappingException, IOException {
        // Reads the value from the file
        String path = "C:\\Users\\zarrar\\git\\jackson-object-mapper\\jackson\\Resources\\outfile.json";
        VolleyBallPlayer player2 = mapper.readValue(new File(path), VolleyBallPlayer.class);
        System.out.println(player2.getName());
        System.out.println(player2.getNumber());
    }
    
    private static void serializeMap(ObjectMapper objectMapper) throws JsonProcessingException {
        // Maps are serialized in key value pairs
        Map<String, String> capitalCities = new HashMap<String, String>();
        capitalCities.put("London", "UnitedKingdom");
        capitalCities.put("Paris", "France");
        capitalCities.put("Manilla", "Philipines");
        String writeValueAsString = objectMapper.writeValueAsString(capitalCities);
        System.out.println(writeValueAsString);      
    }
}