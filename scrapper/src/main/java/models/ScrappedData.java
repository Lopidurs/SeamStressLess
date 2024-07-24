package models;

import java.time.LocalDateTime;

public record ScrappedData(String website, String product, double price, String url, LocalDateTime date) {
}
