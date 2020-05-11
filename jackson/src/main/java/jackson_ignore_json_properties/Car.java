package jackson_ignore_json_properties;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Car {
    @JsonAlias({ "brandName", "brand_name", "myBrandName" })
    public String brand;

    @JsonAlias({ "type" })
    public String model;

    @JsonAlias({ "carColor" })
    public String color;
    
    @JsonIgnore
    public String engine;
}