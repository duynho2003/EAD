package com.mytech.shopmgmt.ejb.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.entities.Customer;
import com.mytech.shopmgmt.ejb.entities.Order;
import com.mytech.shopmgmt.ejb.entities.OrderItem;
import com.mytech.shopmgmt.ejb.facades.AbstractFacade;

import jakarta.annotation.Resource;
import jakarta.ejb.LocalBean;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Status;
import jakarta.transaction.SystemException;
import jakarta.transaction.UserTransaction;

/**
 * Session Bean implementation class OrderBMTBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
@LocalBean
public class OrderBMTBean extends AbstractFacade<Order> implements Serializable {

	private static final long serialVersionUID = 2144006955768756889L;

	@PersistenceContext(unitName = "ShopMgmtEJB")
	private EntityManager em;

	@Resource
	private SessionContext sessionContext;

	public OrderBMTBean() {
		super(Order.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public Order createOrderUsingRequired(Customer customer, List<Book> listBooks) {
		final UserTransaction userTransaction = sessionContext.getUserTransaction();

		try {
			if (userTransaction.getStatus() == Status.STATUS_NO_TRANSACTION) {
				userTransaction.begin();
				if (em.contains(customer)) {
					em.merge(customer);
				}
				Order order = new Order("NEW", customer);
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

				userTransaction.commit();
				
				return order;
			}
		} catch (Exception e) {
			System.out.println("BMTBean: " + e.toString());
			try {
				userTransaction.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		return null;
	}
}
