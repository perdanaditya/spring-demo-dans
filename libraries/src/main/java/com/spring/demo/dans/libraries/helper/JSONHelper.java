package com.spring.demo.dans.libraries.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Rizky Perdana
 */
@Slf4j
public class JSONHelper {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private JSONHelper() {
    }

    public static <T> T convertJsonInStringToObject(String jsonInString, Class<T> clazz) {
        try {
            return MAPPER.readValue(jsonInString, clazz);
        } catch (Exception e) {
            log.error("Error on read value, convertObjectToJsonInString.", e);
            return null;
        }
    }
}
