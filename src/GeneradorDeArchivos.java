import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GeneradorDeArchivos {

    public void guardarJson(Object jsonArray) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("HistorialDeConversiones.json");
        escritura.write(gson.toJson(jsonArray));
        escritura.close();
    }

    public void AgregarDatosAJsonGlobal(ArrayList<String> jsonArray) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        FileWriter escritura = new FileWriter("HistorialDeRegistros.json");
        escritura.write(gson.toJson(jsonArray));
        escritura.close();

    }
}

