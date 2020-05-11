package jackson_serialization_java_objects;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class BusApp {

    public static void main(String[] args)
            throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Bus bus = new Bus();
        bus.model = "Ford";
        bus.engine.cylinders = 8;
        bus.engine.horsePower = 100;
        String writeValueAsString = "";
        try {
            writeValueAsString = mapper.writeValueAsString(bus);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(writeValueAsString);
        deserializeBus(mapper);
    }

    private static void deserializeBus(ObjectMapper mapper)
            throws JsonParseException, JsonMappingException, IOException {
        String jsonString = "{\"model\":\"Ford\", "
                + "\"engine\":{\"cylinders\":\"8\", \"horsePower\":\"100\"}}";
        Bus readValue = mapper.readValue(jsonString, Bus.class);
        System.out.println(readValue.model);
        System.out.println(readValue.engine.cylinders);
        System.out.println(readValue.engine.horsePower);
    }
}