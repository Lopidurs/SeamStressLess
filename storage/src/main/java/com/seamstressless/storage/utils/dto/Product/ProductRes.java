package com.seamstressless.storage.utils.dto.Product;

import com.seamstressless.storage.utils.dto.ProductCategory.ProductCategoryRes;

public interface ProductRes {
    Long getId();
    String getURL();
    String getXPathPrice();
    ProductCategoryRes getCategory();

}
