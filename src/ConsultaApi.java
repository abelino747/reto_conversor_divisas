import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;

public class ConsultaApi {
    public Tasa buscaTasaEnAPi(String tasaInicio , String tasaCambio, Double cantidad) throws UnsupportedEncodingException {
        String tasaInicioEncoded = URLEncoder.encode(tasaInicio,"UTF-8");
        String tasaCambioEncoded = URLEncoder.encode(tasaCambio,"UTF-8");

        // se debe modificar la key por la que le genera exchangerate-api.com.
        String direction = "https://v6.exchangerate-api.com/v6/7de4bacaea764a6523d7539c/pair/" + tasaInicioEncoded + "/" + tasaCambioEncoded + "/"+cantidad;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direction))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new Gson();
            Tasa tasa = gson.fromJson(response.body(), Tasa.class);
            return tasa;
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Eleccion Invalida");
        } catch (Exception e){
            throw new RuntimeException("No encontre esa Moneda, Vuelve a intentarlo");
        }
    }

}
