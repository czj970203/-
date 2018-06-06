package ticket.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		return baseDao.update(order);
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
			String queryString = "from Order as model where model." + propname1 + " = ? and model." + propname2 + " = ?";
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
	public Message findOrderByTrouble(String propname1, Object value1, String propname2, Object value2, String propname3, Object value3) {
		Session session = baseDao.getSession();
		List<Plan> list = new ArrayList<Plan>();
		try {
			Transaction tx = session.beginTransaction();
			String queryString = "from Order as model where model." + propname1 + " = ? and model." + propname2 + " = ? and model." + propname3 + " = ?";
			Query queryObject = session.createQuery(queryString);
			queryObject.setParameter(0, value1);
			queryObject.setParameter(1, value2);
			queryObject.setParameter(2, value3);
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
		return findOrderByDouble("payState",0,"isCancelled",1);
	}

	/**
	 * @return ����δ��Ʊ�ɹ��Ķ���
	 */
	public Message getUnallocOrders() {
		return findOrderByDouble("payState",1,"allocState",0);
	}

	/**
	 * @return ����δ������̼ҵĶ���
	 */
//	public Message getUnbalancedOrders() {
//		Message message = baseDao.findByProperty(Order.class, "isSettled", 0);
//		List<Order> list1 = (List<Order>)message.getObject();
//		List<Order> result = new ArrayList<Order>();
//		for(Order order:list1) {
//			String showdate = order.getShowDate();
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date showDate = null;
//			try {
//				showDate = dateFormat.parse(showdate);
//			} catch (ParseException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Date nowDate = new Date();
//			long timetemp = showDate.getTime() - nowDate.getTime();
//			if(timetemp<0) {
//				result.add(order);
//			}
//		}
//		return new Message(true,result,"��ȡδ���㶩���ɹ�");
//	}

	/**
	 * @return �����˶��Ķ���
	 */
	public Message getCancelledOrders() {
		return baseDao.findByProperty(Order.class, "isCancelled", 0);
	}
	
	public Message searchOrder(int orderid) {
		Session session = baseDao.getSession();
		List<Plan> list = new ArrayList<Plan>();
		try {
			Transaction tx = session.beginTransaction();
			String queryString = "from Order as model where model.orderid like '%"+orderid+"%'";
			Query queryObject = session.createQuery(queryString);
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
}
