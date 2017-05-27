package daw.upm.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class JSONParser {

    //Ejemplo:
    //
    //    String json = "{\"title\":\"pi\"}";
    //
    //    HashMap<String, String> fieldMapping = new HashMap<String, String>();
    //    fieldMapping.put("title", "titulo");
    //
    //    System.out.println( MovieService.parseJson(json, fieldMapping) );
    //
    //    Output {titulo=pi}


    /**
     * Convierte un string json a HashMap con el mappping de claves especificado.
     * Si no se especifica el mapping mantiene las claves originales del json.
     * @param json
     * @param fieldMapping
     * @return
     */
    public static HashMap<String, String> parseJson(String json, HashMap<String, String> fieldMapping) {
        try {
            //JSON parsing
            HashMap<String, String> jsonMap = new HashMap<String, String>();
            ObjectMapper objectMapper = new ObjectMapper();
            jsonMap = objectMapper.readValue(json, new TypeReference<HashMap<String, String>>() {
            });

            //Mapping
            HashMap<String, String> result = new HashMap<String, String>();

            if (fieldMapping.isEmpty()) {
                result = jsonMap;
            }
            else {
                for (Map.Entry<String, String> entry : fieldMapping.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    result.put(value, jsonMap.get(key));
                }
            }

            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



}


