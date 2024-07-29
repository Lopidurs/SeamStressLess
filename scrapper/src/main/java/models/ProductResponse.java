package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ProductResponse {
    private long id;
    private String url;
    private String xpathPrice;
    private Category category;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter @Setter
    public static class Category {
        private String name;
        private long id;
    }
}
