package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Order;

public class OrderResource extends ResourceBase<Order> {
    private static OrderResource INSTANCE = new OrderResource();

    public static OrderResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderResource();
        }
        return INSTANCE;
    }

    private OrderResource() {
        super();
    }
}
