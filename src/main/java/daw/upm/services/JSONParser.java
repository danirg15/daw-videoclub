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
    public static HashMap<String, Object> parseJson(String json, HashMap<String, String> fieldMapping) {
        try {
            //JSON parsing
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<HashMap<String,Object>> typeRef
                    = new TypeReference<HashMap<String,Object>>() {};
            HashMap<String,Object> jsonMap = mapper.readValue(json, typeRef);


            //Mapping
            HashMap<String, Object> result = new HashMap<String, Object>();

            if (fieldMapping == null || fieldMapping.isEmpty()) {
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


