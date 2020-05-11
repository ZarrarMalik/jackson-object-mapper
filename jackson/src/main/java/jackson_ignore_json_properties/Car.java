package jackson_ignore_json_properties;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Car {
    @JsonAlias({ "brandName", "brand_name", "myBrandName" })
    private String brand;

    @JsonAlias({ "type" })
    private String model;

    @JsonAlias({ "carColor" })
    private String color;
}