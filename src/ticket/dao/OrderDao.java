package ticket.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import ticket.config.Message;
import ticket.model.Order;
import ticket.model.Plan;

@Repository
public class OrderDao {

	@Resource
	BaseDao baseDao;

	public Message makeOrder(Order order) {
		return baseDao.save(order);
	}

	public Message update(Order order) {
		return baseDao.save(order);
	}

	public Message delete(Order order) {
		return baseDao.delete(order);
	}

	public Message findOrderById(int id) {
		return baseDao.findById(Order.class, id);
	}

	public Message findOrderBySingle(String propertyname, Object value) {
		return baseDao.findByProperty(Order.class, propertyname, value);
	}

	public Message findOrderByDouble(String propname1, Object value1, String propname2, Object value2) {
		Session session = baseDao.getSession();
		List<Plan> list = new ArrayList<Plan>();
		try {
			Transaction tx = session.beginTransaction();
			String queryString = "from Order as model where model." + propname1 + " = ? and " + propname2 + " = ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value1);
			queryObject.setParameter(1, value2);
			list = queryObject.list();
			tx.commit();
			return new Message(true, list, "���ݻ�ȡ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
			return new Message(false, "���ݻ�ȡʧ��");
		} finally {
			session.close();
		}
	}

	public Message getAllOrders() {
		return baseDao.getAll(Order.class);
	}

	public Message getOrderNum() {
		Message message = baseDao.getAll(Order.class);
		if (message.getResult() == true) {
			List<Order> list = (List<Order>) message.getObject();
			long count = 0;
			for (Order order : list) {
				count++;
			}
			return new Message(true, count, "���ݻ�ȡ�ɹ�");
		} else {
			return new Message(false, "���ݻ�ȡʧ��");
		}
	}

	public Message getTotalConsumption() {
		Message message = baseDao.getAll(Order.class);
		if (message.getResult() == true) {
			List<Order> list = (List<Order>) message.getObject();
			double totalConsumption = 0.0;
			for (Order order : list) {
				totalConsumption += order.getTotalPrice();
			}
			return new Message(true, totalConsumption, "���ݻ�ȡ�ɹ�");
		} else {
			return new Message(false, "���ݻ�ȡʧ��");
		}
	}

	/**
	 * @return ����δ֧���Ķ���
	 */
	public Message getUnpaidOrders() {
		return baseDao.findByProperty(Order.class, "payState", 0);
	}

	/**
	 * @return ����δ��Ʊ�ɹ��Ķ���
	 */
	public Message getUnallocOrders() {
		return baseDao.findByProperty(Order.class, "allocState", 0);
	}

	/**
	 * @return ����δ������̼ҵĶ���
	 */
	public Message getUnbalancedOrders() {
		return baseDao.findByProperty(Order.class, "isSettled", 0);
	}

	/**
	 * @return �����˶��Ķ���
	 */
	public Message getCancelledOrders() {
		return baseDao.findByProperty(Order.class, "isCancelled", 0);
	}
}
