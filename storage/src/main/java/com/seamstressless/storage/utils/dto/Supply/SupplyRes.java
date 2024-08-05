package com.seamstressless.storage.utils.dto.Supply;

import com.seamstressless.storage.utils.dto.SupplyCategory.SupplyCategoryRes;

public interface SupplyRes {
    Long getId();
    String getURL();
    String getXPathPrice();
    SupplyCategoryRes getCategory();

}
