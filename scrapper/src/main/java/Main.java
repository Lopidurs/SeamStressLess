import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.ProductResponse;
import websites.Scrapper;

public class Main {
    public static void main(String[] args) {
        try {
            List<ProductResponse> products = fetchProducts();
            for (ProductResponse product : products) {
                System.out.println(new Scrapper(product).scrap());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static List<ProductResponse> fetchProducts() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/products"))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<ProductResponse>>() {});
    }
}
