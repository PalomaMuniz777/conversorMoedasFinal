import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPIRequest {

    public static void main(String[] args) {
        String apiKey = ";
        String baseCurrency = "USD"; // Código da moeda base

        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                System.out.println("Resposta da API:");
                System.out.println(response.body());
            } else {
                System.out.println("Falha na solicitação. Código de status: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println("Erro ao fazer a solicitação: " + e.getMessage());
        }
    }
}
