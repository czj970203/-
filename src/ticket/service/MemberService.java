package ticket.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ticket.config.Message;
import ticket.dao.HallDao;
import ticket.dao.MemberDao;
import ticket.dao.OrderDao;
import ticket.dao.PayAccountDao;
import ticket.model.Hall;
import ticket.model.Member;
import ticket.model.Order;
import ticket.model.PayAccount;
import ticket.vo.MemberFinanceVo;
import ticket.vo.MemberUpdateVo;
import ticket.vo.OrderTicketVo;
import ticket.vo.ViewOrderVo;

@Service
public class MemberService {
	@Resource
	MemberDao memberDao;
	@Resource
	OrderDao orderDao;
	@Resource
	HallDao hallDao;
	@Resource
	PayAccountDao payAccountDao;

	public Message stopMember(String email) {
		Message message = memberDao.findMemberByEmail(email);
		if (message.getResult() == true) {
			List<Member> list = (List<Member>) message.getObject();
			Member member = list.get(0);
			member.setState(0);
			return memberDao.update(member);
		} else {
			return new Message(false, "ֹͣ��Ա�ʸ�ʧ��");
		}
	}

	// ���֧��֮����������ȼ�
	public Message updateLevel(String email) {
		Message message = memberDao.findMemberByEmail(email);
		if (message.getResult() == true) {
			List<Member> list = (List<Member>) message.getObject();
			Member member = list.get(0);
			double con = member.getConsumption();
			if (con < 100.0) {
				member.setLevel(0);
				member.setDiscount(1.0);
			} else if (con < 500.0) {
				member.setLevel(1);
				member.setDiscount(0.95);
			} else if (con < 1000.0) {
				member.setLevel(2);
				member.setDiscount(0.9);
			} else if (con < 2000.0) {
				member.setLevel(3);
				member.setDiscount(0.85);
			} else {
				member.setLevel(4);
				member.setDiscount(0.8);
			}
			return memberDao.update(member);
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	// ֧�����֮��������ӻ���(�÷���ֱ��д��֧���������ˣ�
	// public Message updatePoint(String email) {
	// Message message = memberDao.findMemberByEmail(email);
	// if (message.getResult() == true) {
	// Member member = (Member) message.getObject();
	// double con = member.getConsumption();
	// int point = (int) con;
	// member.setPoint(member.getPoint() + point);
	// return memberDao.update(member);
	// } else {
	// return new Message(false, "�û���Ϣ����");
	// }
	// }

	public Message updateMemberInfo(MemberUpdateVo vo) {
		Message message = memberDao.findMemberByEmail(vo.getEmail());
		if (message.getResult() == true) {
			List<Member> list = (List<Member>) message.getObject();
			Member member = list.get(0);
			member.setPassword(vo.getPassword());
			member.setTelephone(vo.getTelephone());
			member.setName(vo.getName());
			member.setSex(vo.getSex());
			return memberDao.update(member);
		} else {
			return new Message(false, "�û���Ϣ����ʧ��");
		}
	}

	public Message viewMemberOrderStatus(String email) {
		Message message = orderDao.findOrderBySingle("email", email);
		if (message.getResult() == true) {
			List<Order> list = (List<Order>) message.getObject();
			List<ViewOrderVo> result = new ArrayList<ViewOrderVo>();
			for (Order order : list) {
				ViewOrderVo vo = new ViewOrderVo(order.getOrderid(), email, order.getOrderMethod(), order.getToption(),
						order.getTicketNum(), order.getTicketType(), order.getTotalPrice(), order.getOrderDate(),
						order.getShowDate(), order.getPayState(), order.getAllocState(), order.getHallNo(),
						order.getHallName(), order.getShowType());
				result.add(vo);
			}
			return new Message(true, result, "��ȡ�û������У�������Ϣ�ɹ�");
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	public Message getUnpaidOrders(String email) {
		Message message = orderDao.findOrderByTrouble("email", email, "payState", 0, "isCancelled", 1);
		if (message.getResult() == true) {
			List<Order> list = (List<Order>) message.getObject();
			List<ViewOrderVo> result = new ArrayList<ViewOrderVo>();
			for (Order order : list) {
				ViewOrderVo vo = new ViewOrderVo(order.getOrderid(), email, order.getOrderMethod(), order.getToption(),
						order.getTicketNum(), order.getTicketType(), order.getTotalPrice(), order.getOrderDate(),
						order.getShowDate(), order.getPayState(), order.getAllocState(), order.getHallNo(),
						order.getHallName(), order.getShowType());
				result.add(vo);
			}
			return new Message(true, result, "��ȡ�û�δ֧��������Ϣ�ɹ�");
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	public Message getPaidOrders(String email) {
		Message message = orderDao.findOrderByTrouble("email", email, "payState", 1, "isCancelled", 1);
		if (message.getResult() == true) {
			List<Order> list = (List<Order>) message.getObject();
			List<ViewOrderVo> result = new ArrayList<ViewOrderVo>();
			for (Order order : list) {
				ViewOrderVo vo = new ViewOrderVo(order.getOrderid(), email, order.getOrderMethod(), order.getToption(),
						order.getTicketNum(), order.getTicketType(), order.getTotalPrice(), order.getOrderDate(),
						order.getShowDate(), order.getPayState(), order.getAllocState(), order.getHallNo(),
						order.getHallName(), order.getShowType());
				result.add(vo);
			}
			return new Message(true, result, "��ȡ�û���֧��������Ϣ�ɹ�");
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	public Message getCancelledOrders(String email) {
		Message message = orderDao.findOrderByDouble("email", email, "isCancelled", 0);
		if (message.getResult() == true) {
			List<Order> list = (List<Order>) message.getObject();
			List<ViewOrderVo> result = new ArrayList<ViewOrderVo>();
			for (Order order : list) {
				ViewOrderVo vo = new ViewOrderVo(order.getOrderid(), email, order.getOrderMethod(), order.getToption(),
						order.getTicketNum(), order.getTicketType(), order.getTotalPrice(), order.getOrderDate(),
						order.getShowDate(), order.getPayState(), order.getAllocState(), order.getHallNo(),
						order.getHallName(), order.getShowType());
				result.add(vo);
			}
			return new Message(true, result, "��ȡ�û���ȡ��������Ϣ�ɹ�");
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	public Message getMemberInfo(String email) {
		Message message = memberDao.findMemberByEmail(email);
		if (message.getResult() == true) {
			List<Member> list = (List<Member>) message.getObject();
			Member member = list.get(0);
			long totalNum = (long) memberDao.getOnlineNum(member.getEmail()).getObject();
			long paidNum = (long) memberDao.getPaidNum(member.getEmail()).getObject();
			long cancelledNum = (long) memberDao.getCancelledNum(member.getEmail()).getObject();
			MemberFinanceVo vo = new MemberFinanceVo(member.getEmail(), totalNum, paidNum, cancelledNum, member.getState(),
					member.getConsumption());
			return new Message(true, vo, "��ȡ�û�ͳ����Ϣ�ɹ�");
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	public Message getMember(String email) {
		return memberDao.findMemberByEmail(email);
	}

	public Message instantOrderTicket(OrderTicketVo vo) {
		Message hallMessage = hallDao.findHallById(vo.getHallNo());
		Message memberMessage = memberDao.findMemberByEmail(vo.getEmail());
		if (memberMessage.getResult() == true) {
			Hall hall = (Hall) hallMessage.getObject();
			List<Member> list = (List<Member>) memberMessage.getObject();
			Member member = list.get(0);
			Order order = new Order();
			order.setEmail(vo.getEmail());
			order.setOrderMethod(0);
			order.setToption(1);
			order.setTicketNum(vo.getTicketNum());
			order.setTicketType(vo.getTicketType());
			order.setTotalPrice(vo.getTotalPrice() * member.getDiscount());
			order.setOrderDate(vo.getOrderDate());
			order.setShowDate(vo.getShowDate());
			order.setPayState(0);
			order.setAllocState(0);
			// �����˶�
			order.setIsCancelled(1);
			order.setIsSettled(0);
			order.setHallNo(vo.getHallNo());
			order.setHallName(vo.getHallName());
			order.setShowType(vo.getShowType());
			order.setMinused(vo.getMinused());
			// Ҫ�����Ժ�������ӳ�������
			// hall.setIncome(hall.getIncome() + order.getTotalPrice());
			// Ҫ֧���Ժ���������û����Ѷ�
			// member.setConsumption(member.getConsumption() + order.getTotalPrice());
			// memberDao.update(member);
			// updateLevel(member.getEmail());

			// hallDao.updateHall(hall);
			Message result = orderDao.makeOrder(order);
			if (result.getResult() == true) {
				return new Message(true, order, "Ԥ���ɹ�");
			} else {
				return new Message(false, "Ԥ��ʧ��");
			}
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	public Message selectOrderTicket(OrderTicketVo vo) {
		Message hallMessage = hallDao.findHallById(vo.getHallNo());
		Message memberMessage = memberDao.findMemberByEmail(vo.getEmail());
		if (memberMessage.getResult() == true) {
			Hall hall = (Hall) hallMessage.getObject();
			List<Member> list = (List<Member>) memberMessage.getObject();
			Member member = list.get(0);
			Order order = new Order();
			order.setEmail(vo.getEmail());
			order.setOrderMethod(0);
			order.setToption(0);
			order.setTicketNum(vo.getTicketNum());
			order.setTicketType(vo.getTicketType());
			order.setTotalPrice(vo.getTotalPrice() * member.getDiscount());
			order.setOrderDate(vo.getOrderDate());
			order.setShowDate(vo.getShowDate());
			// δ֧��
			order.setPayState(0);
			// ѡ�������Ʊ
			order.setAllocState(1);
			// �����˶�
			order.setIsCancelled(1);
			// δ����
			order.setIsSettled(0);
			order.setHallNo(vo.getHallNo());
			order.setHallName(vo.getHallName());
			order.setShowType(vo.getShowType());
			order.setMinused(vo.getMinused());
			// Ҫ�����Ժ�������ӳ�������
			// hall.setIncome(hall.getIncome() + order.getTotalPrice());
			// Ҫ֧���Ժ���������û����Ѷ�
			// member.setConsumption(member.getConsumption() + order.getTotalPrice());
			// memberDao.update(member);
			// updateLevel(member.getEmail());

			// hallDao.updateHall(hall);
			Message result = orderDao.makeOrder(order);
			if (result.getResult() == true) {
				return new Message(true, order, "Ԥ���ɹ�");
			} else {
				return new Message(false, "Ԥ��ʧ��");
			}
		} else {
			return new Message(false, "�û���Ϣ����");
		}
	}

	public Message payOrder(double totalPrice, int orderid) {
		Message orderMessage = orderDao.findOrderById(orderid);
		Order order = (Order) orderMessage.getObject();

		Message memberMessage = memberDao.findMemberByEmail(order.getEmail());
		List<Member> list1 = (List<Member>) memberMessage.getObject();
		Member member = list1.get(0);

		Message accountMessage = payAccountDao.findByEmail(order.getEmail());
		List<PayAccount> list2 = (List<PayAccount>) accountMessage.getObject();
		PayAccount account = list2.get(0);
		if (account.getBalance() >= totalPrice) {

			order.setPayState(1);
			member.setConsumption(member.getConsumption() + order.getTotalPrice());
			member.setPoint((int) (member.getPoint() + order.getTotalPrice() * 10));
			account.setBalance(account.getBalance() - order.getTotalPrice());

			Message mes1 = orderDao.update(order);
			Message mes2 = memberDao.update(member);
			Message mes3 = payAccountDao.update(account);

			if (mes1.getResult() == true && mes2.getResult() == true && mes3.getResult() == true) {
				updateLevel(order.getEmail());
				return new Message(true, "֧���ɹ�");
			} else {
				return new Message(false, "֧��ʧ��");
			}
		} else {
			return new Message(false, "����");
		}
	}

}