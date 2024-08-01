package models;

import java.time.LocalDateTime;

public record ScrappedData( Long productId, double price, LocalDateTime priceAt) {
}
