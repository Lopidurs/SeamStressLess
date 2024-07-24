package com.seamstressless.storage.dto.Product;

import com.seamstressless.storage.dto.ProductCategory.ProductCategoryRes;

public interface ProductRes {
    Long getId();
    String getURL();
    String getXPathPrice();
    ProductCategoryRes getCategory();

}
