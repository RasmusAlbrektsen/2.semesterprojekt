/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.ICaseLogger;
import business.CaseLogger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect.Type;

/**
 *
 * @author Rasmus
 */
public class JSONDatabase {

    private final File fileCaseLogger = new File("caseLogger.json");

    public JSONDatabase() {
        loadDatabase();
    }

    private class CaseLoggerDeserializer implements JsonDeserializer<ICaseLogger> {

        @Override
        public ICaseLogger deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson g = new Gson();
            return (DataCaseLogger) g.fromJson(json, DataCaseLogger.class);
        }
    }

    public void saveCaseLogger(ICaseLogger cl) {
        saveData(cl, fileCaseLogger);
    }
    
    public ICaseLogger loadCaseLogger(){
        try (FileReader reader = new FileReader(fileCaseLogger)){
            JsonReader jsonReader = new JsonReader(reader);
            ICaseLogger caseLogger = new Gson().fromJson(jsonReader, DataCaseLogger.class);
            
            return caseLogger;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void saveData(ICaseLogger o, File file) {
        Gson gson = new GsonBuilder().create();
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(o, writer);
            System.out.println("save complete!");
        } catch (IOException e) {
        }
    }

    private void loadDatabase() {
        if (!fileCaseLogger.exists()) {
            try {
                fileCaseLogger.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
