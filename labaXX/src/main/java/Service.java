import Entities.House;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


public class Service {
    public static void serialization(House house, ObjectOutput out) throws IOException {
        out.writeObject(house);
        
    }

    public static House deserialization(ObjectInput in) throws IOException, ClassNotFoundException {
        return (House) in.readObject();

    }

    public static String jacksonSerialization(House house) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(house);

    }

    public static House jacksonDeserialization(String jString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jString, House.class);

    }
}
