package jackson_ignore_json_properties;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UsePropertiesWithJackson {

    public static void main(String[] args) throws Exception, Exception, Exception {
        // brand_name in car class is refered to as brand
        // but jsonAlias can map the names defined in class
        String jsonString = "{\"brand_name\":\"Toyota\", \"type\":\"SUV\", \"carColor\":\"Green\" }";
        ObjectMapper mapper = new ObjectMapper();
        Car car = mapper.readValue(jsonString, Car.class);
        System.out.println(car.brand);
        System.out.println(car.model);
        System.out.println(car.color);
        ignoreCarProperty(mapper);
        ignoreCarPropertyWitDeSerialization(mapper);
    }

    private static void ignoreCarPropertyWitDeSerialization(ObjectMapper mapper)
            throws Exception, Exception, Exception {
        String jsonString = "{\"brand_name\":\"Toyota\", \"type\":\"SUV\", \"carColor\":\"Green\", \"engine\":\"old\" }";
        Car readValue = mapper.readValue(jsonString, Car.class);
        Car car = new Car();
        car.engine = "800cc";

        System.out.println(readValue.brand);
        System.out.println(readValue.model);
        System.out.println(readValue.color);
        // engine is null since its property is set to be jsonIgnore
        System.out.println(readValue.engine);

    }

    private static void ignoreCarProperty(ObjectMapper mapper) throws Exception {
        Car car = new Car();
        car.brand = "suzuki";
        car.model = "fx";
        car.color = "blue";
        car.engine = "800cc";

        // engine was not in the json string as it uses JsonIgnore property
        String writeValueAsString = mapper.writeValueAsString(car);
        System.out.println(writeValueAsString);
    }
}