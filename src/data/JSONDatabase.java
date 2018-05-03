/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Acq.IAdminLogger;
import Acq.IAppointment;
import Acq.ICase;
import Acq.ICaseLogger;
import Acq.IMedicine;
import Acq.IUser;
import business.Appointment;
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
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rasmus
 */
public class JSONDatabase {

    private final File fileCaseLogger = new File("caseLogger.json");
    private final File fileAdminLogger = new File("adminLogger.json");
    private final File fileMedicine = new File("medicine.json");
    private final File fileUser = new File("user.json");
    private final File fileCase = new File("case.json");
    private final File fileAppointment = new File("appointment.json");

    public JSONDatabase() {
        loadDatabase();
    }

    private static class CaseDeserializer implements JsonDeserializer<ICase> {

        public CaseDeserializer() {
        }

        @Override
        public ICase deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson g = new Gson();
            return (DataCase) g.fromJson(json, DataCase.class);
        }
    }

    private static class AppointmentDeserializer implements JsonDeserializer<IAppointment> {

        public AppointmentDeserializer() {
        }

        @Override
        public IAppointment deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson g = new Gson();
            return (DataAppointment) g.fromJson(json, DataAppointment.class);
        }
    }

    private class UserDeserializer implements JsonDeserializer<IUser> {

        @Override
        public IUser deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson g = new GsonBuilder()
                    .registerTypeHierarchyAdapter(ICase.class, new CaseDeserializer())
                    .registerTypeHierarchyAdapter(IAppointment.class, new AppointmentDeserializer())
                    .create();
            return (DataUser) g.fromJson(json, DataUser.class);
        }
    }

    private class MedicineDeserializer implements JsonDeserializer<IMedicine> {

        @Override
        public IMedicine deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson g = new Gson();
            return (DataMedicine) g.fromJson(json, DataMedicine.class);
        }
    }

    private class CaseLoggerDeserializer implements JsonDeserializer<ICaseLogger> {

        @Override
        public ICaseLogger deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson g = new Gson();
            return (DataCaseLogger) g.fromJson(json, DataCaseLogger.class);
        }
    }

    private class AdminLoggerDeserializer implements JsonDeserializer<IAdminLogger> {

        @Override
        public IAdminLogger deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            Gson g = new Gson();
            return (DataAdminLogger) g.fromJson(json, DataAdminLogger.class);
        }
    }

    public Map<String, IMedicine> getMedicine() {
        try (FileReader reader = new FileReader(fileMedicine)) {
            JsonReader jsonReader = new JsonReader(reader);
            Gson g = new GsonBuilder()
                    .registerTypeHierarchyAdapter(IMedicine.class, new MedicineDeserializer())
                    .create();
            Type type = new TypeToken<Map<String, IMedicine>>() {
            }.getType();

            Map<String, IMedicine> obj = g.fromJson(jsonReader, type);
            return obj;
        } catch (Exception e) {
        }
        return null;
    }

    public Map<String, IUser> getUsers() {
        try (FileReader reader = new FileReader(fileUser)) {
            JsonReader jsonReader = new JsonReader(reader);
            Gson g = new GsonBuilder()
                    .registerTypeHierarchyAdapter(IUser.class, new UserDeserializer())
                    .create();
            Type type = new TypeToken<Map<String, IUser>>() {
            }.getType();
            Map<String, IUser> obj = g.fromJson(jsonReader, type);
            return obj;
        } catch (Exception e) {
        }
        return null;
    }

    public List<ICase> getCases() {
        try (FileReader reader = new FileReader(fileCase)) {
            JsonReader jsonReader = new JsonReader(reader);
            Gson g = new GsonBuilder()
                    .registerTypeHierarchyAdapter(ICase.class, new CaseDeserializer())
                    .create();

            Type type = new TypeToken<List<ICase>>() {
            }.getType();
            List<ICase> obj = g.fromJson(jsonReader, type);
            return obj;
        } catch (Exception e) {
        }
        return null;
    }
    
    public List<IAppointment> getAppointments(){
        try (FileReader reader = new FileReader(fileAppointment)){
            JsonReader jsonReader = new JsonReader(reader);
            Gson g = new GsonBuilder()
                    .registerTypeHierarchyAdapter(IAppointment.class, new AppointmentDeserializer())
                    .create();
            Type type = new TypeToken<List<IAppointment>>(){}.getType();
            List<IAppointment> obj = g.fromJson(jsonReader, type);
            return  obj;
        } catch (Exception e) {
        }
        return null;
    }

    public void saveCaseLogger(ICaseLogger cl) {
        saveData(cl, fileCaseLogger);
    }

    public void saveAdminLogger(IAdminLogger al) {
        saveData(al, fileAdminLogger);
    }

    public void saveMedicine(Map<String, IMedicine> medMap) {
        saveData(medMap, fileMedicine);
    }

    public void saveUser(Map<String, IUser> uMap) {
        saveData(uMap, fileUser);
    }

    public void saveCase(List<ICase> cList) {
        saveData(cList, fileCase);
    }

    public void saveAppointment(List<IAppointment> aList) {
        saveData(aList, fileAppointment);
    }

    public ICaseLogger loadCaseLogger() {
        try (FileReader reader = new FileReader(fileCaseLogger)) {
            JsonReader jsonReader = new JsonReader(reader);
            ICaseLogger caseLogger = new Gson().fromJson(jsonReader, DataCaseLogger.class);

            return caseLogger;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public IAdminLogger loadAdminLogger() {
        try (FileReader reader = new FileReader(fileAdminLogger)) {
            JsonReader jsonReader = new JsonReader(reader);
            IAdminLogger adminLogger = new Gson().fromJson(jsonReader, DataAdminLogger.class);

            return adminLogger;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private <E> void saveData(E o, File file) {
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
        if (!fileAdminLogger.exists()) {
            try {
                fileAdminLogger.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
