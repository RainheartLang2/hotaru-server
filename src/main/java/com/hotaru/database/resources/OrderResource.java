package com.hotaru.database.resources;

import com.hotaru.core.database.ResourceBase;
import com.hotaru.database.entities.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Date;
import java.util.List;

public class OrderResource extends ResourceBase<Order> {
    private static OrderResource INSTANCE = new OrderResource();

    public static OrderResource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderResource();
        }
        return INSTANCE;
    }

    public List<Order> getByDateRange(Date from, Date to) {
        return getSession().
                createCriteria(Order.class)
                .add(Restrictions.and(Restrictions.ge("creationDate", from),
                        Restrictions.le("creationDate", to)))
                .list();
    }

    private OrderResource() {
        super();
    }
}
