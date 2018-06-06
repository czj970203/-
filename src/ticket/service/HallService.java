package ticket.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ticket.config.Message;
import ticket.dao.HallDao;
import ticket.dao.MemberDao;
import ticket.dao.OrderDao;
import ticket.dao.RegistryDao;
import ticket.dao.UpdateDao;
import ticket.model.Hall;
import ticket.model.Member;
import ticket.model.Order;
import ticket.model.Update;
import ticket.vo.HallInfoVo;
import ticket.vo.HallListVo;
import ticket.vo.HallUpdateVo;
import ticket.vo.OrderTicketVo;
import ticket.vo.SettleOrderVo;

@Service
public class HallService {

	@Resource
	HallDao hallDao;
	@Resource
	MemberDao memberDao;
	@Resource
	OrderDao orderDao;
	@Resource
	RegistryDao registryDao;
	@Resource
	UpdateDao updateDao;
	@Resource
	MemberService memberService;

	// 线下只能选座购买
	public Message buyTicket(OrderTicketVo vo) {
		Message hallMessage = hallDao.findHallById(vo.getHallNo());
		Message memberMessage = memberDao.findMemberByEmail(vo.getEmail());
		if (memberMessage.getResult() == true) {
			Hall hall = (Hall) hallMessage.getObject();
			List<Member> list = (List<Member>) memberMessage.getObject();
			Member member = list.get(0);
			Order order = new Order();
			order.setEmail(vo.getEmail());
			order.setOrderMethod(1);
			order.setToption(0);
			order.setTicketNum(vo.getTicketNum());
			order.setTicketType(vo.getTicketType());
			order.setTotalPrice(vo.getTotalPrice() * member.getDiscount());
			order.setOrderDate(vo.getOrderDate());
			order.setShowDate(vo.getShowDate());
			order.setPayState(1);
			order.setAllocState(1);
			// 允许退订
			order.setIsCancelled(1);
			order.setIsSettled(1);
			order.setHallNo(vo.getHallNo());
			order.setHallName(vo.getHallName());
			order.setShowType(vo.getShowType());
			
			Message result = orderDao.makeOrder(order);
			if (result.getResult() == true) {
				return new Message(true, "预订成功");
			} else {
				return new Message(false, "预订失败");
			}
		} else {
			return new Message(false, "用户信息有误");
		}

	}

	public Message checkTicket(int orderid, String telephone) {
		Message orderMessage = orderDao.findOrderById(orderid);
		if (orderMessage.getObject() != null) {
			Order order = (Order) orderMessage.getObject();
			if(order.getIsChecked() == order.getTicketNum()) {
				return new Message(false,"该票已经被使用");
			}else {
				Message memberMessage = memberDao.findMemberByEmail(order.getEmail());
				List<Member> list = (List<Member>) memberMessage.getObject();
				Member member = list.get(0);
				if(member.getTelephone().equals(telephone)) {
					order.setIsChecked(order.getIsChecked() + 1);
					orderDao.update(order);
					return new Message(true,"检票成功");
				}else {
					return new Message(false,"票据信息不匹配");
				}
			}		
		} else {
			return new Message(false, "票务信息有误");
		}

	}

	public Message getHallInfo(int hallNo) {
		Message hallMessage = hallDao.findHallById(hallNo);
		if (hallMessage.getResult() == true) {
			Hall hall = (Hall) hallMessage.getObject();
			long totalOrder = (long) hallDao.getTotalOrderNum(hallNo).getObject();
			long onlineOrder = (long) hallDao.getOnlineNum(hallNo).getObject();
			long successOrder = (long) hallDao.getSuccessNum(hallNo).getObject();
			long cancelledOrder = (long) hallDao.getCancelledNum(hallNo).getObject();
			double offline_income = (double) hallDao.getOfflineIncome(hallNo).getObject();
			HallInfoVo vo = new HallInfoVo(hallNo, hall.getHallName(), totalOrder, onlineOrder, successOrder,
					cancelledOrder, hall.getIncome(), offline_income);
			return new Message(true, vo, "获取场馆信息成功");
		} else {
			return new Message(false, "获取场馆信息失败");
		}
	}

	public Message updateHall(HallUpdateVo vo) {
		int hallNo = vo.getHallNo();
		Message message = updateDao.findUpdateById(hallNo);
		if (message.getObject() == null) {
			Update up = new Update();
			up.setHallNo(vo.getHallNo());
			up.setPassword(vo.getPassword());
			up.setHallName(vo.getHallName());
			up.setAddress(vo.getAddress());
			up.setJuniorNum(vo.getJuniorNum());
			up.setSeniorNum(vo.getSeniorNum());
			up.setPercent(vo.getPercent());
			return updateDao.addUpdate(up);
		} else {
			Update up = (Update)message.getObject();
			up.setHallNo(vo.getHallNo());
			up.setPassword(vo.getPassword());
			up.setHallName(vo.getHallName());
			up.setAddress(vo.getAddress());
			up.setJuniorNum(vo.getJuniorNum());
			up.setSeniorNum(vo.getSeniorNum());
			up.setPercent(vo.getPercent());
			return updateDao.update(up);
		}
	}

	public Message getEachUnsettledOrders() {
		Message hallMessage = hallDao.getAllHall();
		List<Hall> list = (List<Hall>) hallMessage.getObject();
		List<SettleOrderVo> result = new ArrayList<SettleOrderVo>();
		for (Hall hall : list) {
			int unsettledNum = 0;
			Message message2 = hallDao.getUnsettledOrders(hall.getHallNo());
			List<Order> list2 = (List<Order>) message2.getObject();
			double totalPrice = 0.0;
			for (Order order : list2) {
				totalPrice += order.getTotalPrice();
				unsettledNum++;
			}
			if (unsettledNum > 0) {
				String hallName = hall.getHallName();
				SettleOrderVo vo = new SettleOrderVo(hall.getHallNo(), hallName, unsettledNum, totalPrice);
				result.add(vo);
			}
		}
		if (hallMessage.getResult() == true) {
			return new Message(true, result, "获取各场馆未结算订单成功！");
		} else {
			return new Message(false, "获取各场馆未结算订单失败！");
		}
	}

	public Message getAllHalls(String email) {
		Message message = hallDao.getAllHall();
		if (message.getResult() == true) {
			List<Hall> list = (List<Hall>) message.getObject();
			List<HallListVo> result = new ArrayList<HallListVo>();
			for (Hall hall : list) {
				HallListVo vo = new HallListVo(email, hall.getHallNo(), hall.getPassword(), hall.getHallName(),
						hall.getAddress(), hall.getJuniorNum(), hall.getSeniorNum(), hall.getIncome(),
						hall.getPercent());
				result.add(vo);
			}
			return new Message(true, result, "获取场馆列表成功");
		} else {
			return new Message(false, "获取场馆列表失败");
		}
	}

	public Message searchHall(int hallNo) {
		return hallDao.searchHall(hallNo);
	}

}
