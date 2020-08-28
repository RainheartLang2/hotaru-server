package com.hotaru.rpc.order;

import com.hotaru.database.entities.Order;
import com.hotaru.database.resources.OrderResource;

import java.util.Date;
import java.util.List;

public class AdminOrderService {
    public List<Order> getList(Date from, Date to) {
        return OrderResource.getInstance().getByDateRange(from, to);
    }
}
