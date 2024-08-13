package models;

import java.time.LocalDateTime;

public record ScrappedData( Long supplyId, double price, LocalDateTime priceAt) {
}
