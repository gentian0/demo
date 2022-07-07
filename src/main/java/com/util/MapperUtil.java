package com.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

/**
 * @Author: kong
 * @Date: 2022/7/6 15:04
 * @Description: 文件解析
 */

public class MapperUtil<T> implements java.io.Serializable {
    private static final long serialVersionUID = 2L;
    ObjectMapper objectMapper;


    T readValue;

    public T getReadValue(String pathName) {
        try {
            if (pathName.endsWith(".json")) {
                objectMapper = new ObjectMapper(new JsonFactory());
            } else if (pathName.endsWith(".csv")) {
                objectMapper = new ObjectMapper(new CsvFactory());
            } else if (pathName.endsWith(".yaml") || pathName.endsWith(".yml")) {
                objectMapper = new ObjectMapper(new YAMLFactory());
            }
            TypeReference<T> valueType = new TypeReference<T>() {
            };

            readValue = objectMapper.readValue(new File(pathName), valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readValue;
    }
}
