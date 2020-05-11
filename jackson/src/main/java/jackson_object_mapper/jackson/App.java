package jackson_object_mapper.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    private static final Logger log = LogManager.getLogger(App.class);
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        log.error("We've just greeted the user!");

    }
    ObjectMapper objectMapper = new ObjectMapper();
}
