package com.scaler.demo.project.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
public class JsonUtil {
    private static final ObjectMapper objectmapper = new ObjectMapper();

    public static ObjectMapper getObjectmapper(){
        return objectmapper;
    }

    @PostConstruct
    public void setUp(){
        objectmapper.registerModule(new JavaTimeModule());
        objectmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectmapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
    public static <T> List<T> convertListOfMapToListDTO(Collection<?> collection, Class<T> boClass) throws Exception {
       try {
           objectmapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS, true);
           return objectmapper.convertValue(collection,
                   objectmapper.getTypeFactory().constructCollectionType(List.class, boClass));
       }catch(Exception ex){
           log.error("Convert ListOfMap to List Dto failed", ex.getMessage());
           throw new RuntimeException("Conversion failed");
       }
       }
}
