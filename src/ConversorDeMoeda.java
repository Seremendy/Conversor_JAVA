import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConversorDeMoeda {

    private String minhaChave = "9c2d01247e4eb74df7990f39";

    public double converter(String from, String to, double amount) {
        try {
            String urlStr = "https://v6.exchangerate-api.com/v6/" + minhaChave + "/pair/" + from + "/" + to;

            URL url = new URL(urlStr);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            int status = conexao.getResponseCode();
            if (status != 200) {
                throw new RuntimeException("Erro na requisição: " + status);
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            Gson gson = new Gson();
            JsonObject json = gson.fromJson(reader, JsonObject.class);
            reader.close();

            if (!json.get("result").getAsString().equals("success")) {
                throw new RuntimeException("Erro da API: resultado inválido");
            }

            double taxa = json.get("conversion_rate").getAsDouble();
            return taxa * amount;

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return 0;
        }
    }
}
