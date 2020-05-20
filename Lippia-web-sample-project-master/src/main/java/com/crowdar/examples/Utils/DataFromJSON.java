package com.crowdar.examples.Utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataFromJSON {

    public static List<DataDriver> GetFromFile(String path) throws Exception {
        File f = new File(path);
        if (f.exists()) {
            InputStream is = new FileInputStream(path);
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            Type listOfMyClassObject = new TypeToken<ArrayList<DataDriver>>() {
            }.getType();
            Gson gson = new Gson();
            List<DataDriver> outputList = gson.fromJson(jsonTxt, listOfMyClassObject);
            return outputList;
        } else {
            throw new Exception("No se encuentra el fichero en: " + path);
        }

    }

}

