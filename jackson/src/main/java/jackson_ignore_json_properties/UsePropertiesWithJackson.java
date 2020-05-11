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