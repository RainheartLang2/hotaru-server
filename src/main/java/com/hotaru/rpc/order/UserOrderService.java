package com.hotaru.rpc.order;

import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Order;
import com.hotaru.database.resources.OrderResource;

public class UserOrderService {
    public int add(Order order) throws ValidationException {
        if (order.getId() != 0) {
            throw new ValidationException();
        }
        OrderResource.getInstance().saveOrUpdate(order);
        return  order.getId();
    }
}
