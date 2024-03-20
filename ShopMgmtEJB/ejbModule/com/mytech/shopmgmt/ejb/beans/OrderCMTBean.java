package com.mytech.shopmgmt.ejb.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.entities.Customer;
import com.mytech.shopmgmt.ejb.entities.Order;
import com.mytech.shopmgmt.ejb.entities.OrderItem;
import com.mytech.shopmgmt.ejb.facades.AbstractFacade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class OrderCMTBean
 */
@Stateless
@LocalBean
public class OrderCMTBean extends AbstractFacade<Order> implements Serializable {

	private static final long serialVersionUID = -1524600932192692206L;

	@PersistenceContext(unitName = "ShopMgmtEJB")
	private EntityManager em;

	public OrderCMTBean() {
		super(Order.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Order createOrderUsingSupport(Customer customer, List<Book> listBooks) {
		// Kiem tra trong persistence context co load customer chua?
		if (!em.contains(customer)) {
			em.merge(customer);
		}
		final Order order = new Order("NEW", customer);
		// customer.addOrder(order);

		Date date = new Date();

		for (Book book : listBooks) {
			OrderItem item = new OrderItem();
			item.setOrder(order);
			item.setOrderDate(date);
			item.setPrice(book.getPrice());
			item.setQuantity(1);
			item.setShipDate(date);
			item.setStatus("To Packing");
			order.addOrderItem(item);
		}

		create(order);

		return order;
	}
}
