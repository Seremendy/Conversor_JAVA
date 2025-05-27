import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicoMoeda {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/9c2d01247e4eb74df7990f39/latest/";

    public TaxasDeCambio obterTaxas(String moedaBase) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + moedaBase))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        return gson.fromJson(response.body(), TaxasDeCambio.class);

    }
}
