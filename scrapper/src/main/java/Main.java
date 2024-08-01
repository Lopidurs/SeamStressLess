import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import models.ProductResponse;
import models.ScrappedData;
import websites.Scrapper;

public class Main {
    public static void main(String[] args) {
        try {
            List<ScrappedData> scrappedData = fetchProducts().stream().map(product -> new Scrapper(product).scrap()).toList();
            postScrappedData(scrappedData);
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
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(response.body(), new TypeReference<>() {
        });
    }

    private static void postScrappedData(List<ScrappedData> scrappedData) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/price-records"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(mapper.writeValueAsString(scrappedData)))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
