package com.jawbone.upplatformsdk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/14/15.
 */
public class UpPlatformSdkUtils {

    public static HashMap<String, Object> toMultiPartMap(Class obj) {
        return null;
    }

    public static String toJson(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
