package com.hotaru.rpc.order;

import com.hotaru.business.enums.OrderState;
import com.hotaru.business.managers.SettingsManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.database.entities.Order;
import com.hotaru.database.resources.OrderResource;

import java.util.Date;

public class UserOrderService {

    public int add(Order order) throws ValidationException {
        if (order.getId() != 0) {
            throw new ValidationException();
        }
        SettingsManager settingsManager = SettingsManager.getInstance();
        int price = settingsManager.getPrice();
        int deliveryPrice = settingsManager.getDeliveryPrice();
        int minimalDeliveryAmount = settingsManager.getMinimalDeliveryAmount();
        int minimalDeliveryCost = settingsManager.getMinimalDeliveryCost();

        order.setPrice(price);
        order.setDeliveryPrice(deliveryPrice);
        order.setMinimalDeliveryCost(minimalDeliveryCost);
        order.setMinimalDeliveryAmount(minimalDeliveryAmount);
        order.setCreationDate(new Date());
        order.setOrderState(OrderState.New);
        OrderResource.getInstance().saveOrUpdate(order);
        return  order.getId();
    }
}
