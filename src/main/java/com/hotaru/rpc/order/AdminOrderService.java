package com.hotaru.rpc.order;

import com.hotaru.business.enums.OrderState;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Order;
import com.hotaru.database.resources.OrderResource;

import java.util.Date;
import java.util.List;

public class AdminOrderService extends UserOrderService {
    public List<Order> getList(Date from, Date to) {
        return OrderResource.getInstance().getByDateRange(from, to);
    }

    public void updateState(int id, OrderState newState) throws ValidationException {
        OrderResource resource = OrderResource.getInstance();
        Order order = resource.getById(id);
        if (newState == OrderState.New) {
            throw new ValidationException("Статус New может проставляться только при создании заказа");
        }
        OrderState currentState = order.getOrderState();
        if (currentState == OrderState.Done || currentState == OrderState.Refused) {
            throw new ValidationException("Нельзя менять статус исполненного или отменённого заказа");
        }
        order.setOrderState(newState);
        resource.saveOrUpdate(order);
    }
}
