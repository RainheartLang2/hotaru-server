package com.hotaru.rpc.order;

import com.hotaru.business.enums.DeliveryType;
import com.hotaru.business.enums.OrderState;
import com.hotaru.business.logic.objects.Price;
import com.hotaru.business.managers.SettingsManager;
import com.hotaru.core.exceptions.ValidationException;
import com.hotaru.core.util.container.CustomContainer;
import com.hotaru.database.entities.Order;
import com.hotaru.database.resources.OrderResource;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class UserOrderService {

    private List<Price> getDeliveryPrcies(SettingsManager settingsManager, DeliveryType deliveryType) throws IOException {
        if (deliveryType == DeliveryType.LocalDelivery) {
            return settingsManager.getLocalDeliveryPrices();
        }

        if (deliveryType == DeliveryType.RegionDelivery) {
            return settingsManager.getRegionDeliveryPrices();
        }

        return null;
    }

    public int add(Order order) throws ValidationException, IOException {
        if (order.getId() != 0) {
            throw new ValidationException();
        }
        SettingsManager settingsManager = SettingsManager.getInstance();
        int price = settingsManager.getUnitPrice();

        order.setPrice(price);
        order.setDeliveryPrices(new CustomContainer<Price>(getDeliveryPrcies(settingsManager, order.getDeliveryType())));
        order.setCreationDate(new Date());
        order.setOrderState(OrderState.New);
        OrderResource.getInstance().saveOrUpdate(order);
        return  order.getId();
    }
}
