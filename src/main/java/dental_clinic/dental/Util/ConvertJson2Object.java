package dental_clinic.dental.Util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJson2Object {
    public static <T> T json2Java(String json, Class<T> classType){

        T t = null;


        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            t=mapper.readValue(json, classType);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
}
