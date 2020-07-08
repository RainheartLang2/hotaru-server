package com.hotaru.database.converters;

import com.hotaru.core.util.container.CustomContainer;

public class CustomContainerJsonConverter extends DataBaseJsonConverter<CustomContainer> {
    @Override
    protected Class<CustomContainer> getEntityClass() {
        return CustomContainer.class;
    }
}
