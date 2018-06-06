package ticket.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ticket.config.Message;
import ticket.dao.HallDao;
import ticket.dao.ManagerDao;
import ticket.dao.MemberDao;
import ticket.dao.OrderDao;
import ticket.dao.RegistryDao;
import ticket.dao.UpdateDao;
import ticket.model.Hall;
import ticket.model.Manager;
import ticket.model.Member;
import ticket.model.Order;
import ticket.model.Registry;
import ticket.model.Update;
import ticket.vo.HallFinanceVo;
import ticket.vo.HallInfoVo;
import ticket.vo.MemberFinanceVo;
import ticket.vo.SystemFinanceVo;

@Service
public class ManagerService {

	@Resource
	HallDao hallDao;
	@Resource
	OrderDao orderDao;
	@Resource
	MemberDao memberDao;
	@Resource
	RegistryDao registryDao;
	@Resource
	UpdateDao updateDao;
	@Resource
	ManagerDao managerDao;

	public Message allowRegister(int hallNo) {
		Message message = registryDao.findRegById(hallNo);
		if (message.getResult() == true) {
			Registry reg = (Registry) message.getObject();
			
			Hall hall = new Hall();
			hall.setHallNo(reg.getHallNo());
			hall.setPassword(reg.getPassword());
			hall.setHallName(reg.getHallName());
			hall.setAddress(reg.getAddress());
			hall.setJuniorNum(reg.getJuniorNum());
			hall.setSeniorNum(reg.getSeniorNum());
			hall.setPercent(reg.getPercent());
			hall.setIncome(reg.getIncome());
			hallDao.addHall(hall);
			reg.setIsViewed(1);
			registryDao.updateReg(reg);
			return new Message(true, "����ע����ͨ��");
		} else {
			return new Message(false, "����ע������ʧ��");
		}
	}

	public Message denyRegister(int hallNo) {
		Message message = registryDao.findRegById(hallNo);
		if (message.getResult() == true) {
			Registry reg = (Registry) message.getObject();
			reg.setIsViewed(1);
			registryDao.updateReg(reg);

			return new Message(true, "����ע���Ѿܾ�");
		} else {
			return new Message(false, "����ע������ʧ��");
		}
	}

	public Message allowUpdate(int hallNo) {
		Message message = updateDao.findUpdateById(hallNo);
		if (message.getResult() == true) {
			Update up = (Update) message.getObject();
			Hall hall = new Hall();
			hall.setHallNo(up.getHallNo());
			hall.setPassword(up.getPassword());
			hall.setHallName(up.getHallName());
			hall.setAddress(up.getAddress());
			hall.setJuniorNum(up.getJuniorNum());
			hall.setSeniorNum(up.getSeniorNum());
			hall.setIncome(up.getIncome());
			hallDao.updateHall(hall);
			updateDao.deleteUpdate(up);
			return new Message(true, "���ݸ�����ͨ��");
		} else {
			return new Message(false, "���ݸ�������ʧ��");
		}
	}

	public Message denyUpdate(int hallNo) {
		Message message = updateDao.findUpdateById(hallNo);
		if (message.getResult() == true) {
			Update up = (Update) message.getObject();
			updateDao.deleteUpdate(up);
			return new Message(true, "���ݸ����Ѿܾ�");
		} else {
			return new Message(false, "���ݸ�������ʧ��");
		}
	}

	public Message settleOrders(int hallNo) {
		Message hallMessage = hallDao.findHallById(hallNo);
		Message orderMessage = hallDao.getUnsettledOrders(hallNo);
		Message managerMessage = managerDao.findManager(1437);
		if (hallMessage.getResult() == true && orderMessage.getResult() == true) {
			Hall hall = (Hall) hallMessage.getObject();
			List<Order> orders = (List<Order>) orderMessage.getObject();
			Manager manager = (Manager) managerMessage.getObject();
			for (Order order : orders) {
				hall.setIncome(hall.getIncome() + order.getTotalPrice() * hall.getPercent());
				manager.setIncome(manager.getIncome() + order.getTotalPrice() * (1 - hall.getPercent()));
				order.setIsSettled(1);
				orderDao.update(order);
			}
			hallDao.updateHall(hall);
			managerDao.update(manager);
			return new Message(true, "���ݱ��" + hall.getHallNo() + "����ɹ�");
		} else {
			return new Message(false, "���ݽ���ʧ��");
		}
	}

	public Message getHallFinances() {
		Message hallMessage = hallDao.getAllHall();
		if (hallMessage.getResult() == true) {
			List<Hall> hallList = (List<Hall>) hallMessage.getObject();
			List<HallInfoVo> list = new ArrayList<HallInfoVo>();
			for (Hall hall : hallList) {
				long totalNum = (long) hallDao.getTotalOrderNum(hall.getHallNo()).getObject();
				long onlineNum = (long) hallDao.getOnlineNum(hall.getHallNo()).getObject();
				long successNum = (long) hallDao.getSuccessNum(hall.getHallNo()).getObject();
				long cancelledNum = (long) hallDao.getCancelledNum(hall.getHallNo()).getObject();
				double offline_income = (double) hallDao.getOfflineIncome(hall.getHallNo()).getObject();
				HallInfoVo vo = new HallInfoVo(hall.getHallNo(), hall.getHallName(), totalNum, onlineNum, successNum,
						cancelledNum, hall.getIncome(), offline_income);
				list.add(vo);
			}
			return new Message(true, list, "��ȡ����ͳ�Ƴɹ�");
		} else {
			return new Message(false, "��ȡ����ͳ��ʧ��");
		}
	}

	public Message getMemberFinances() {
		Message memberMessage = memberDao.getAllMembers();
		if (memberMessage.getResult() == true) {
			List<Member> memberList = (List<Member>) memberMessage.getObject();
			List<MemberFinanceVo> list = new ArrayList<MemberFinanceVo>();
			for (Member member : memberList) {
				long totalNum = (long) memberDao.getOnlineNum(member.getEmail()).getObject();
				long paidNum = (long) memberDao.getPaidNum(member.getEmail()).getObject();
				long cancelledNum = (long) memberDao.getCancelledNum(member.getEmail()).getObject();
				MemberFinanceVo vo = new MemberFinanceVo(member.getEmail(), totalNum, paidNum, cancelledNum,member.getState(),
						member.getConsumption());
				list.add(vo);
			}
			return new Message(true, list, "��ȡ��Աͳ�Ƴɹ�");
		} else {
			return new Message(false, "��ȡ��Աͳ��ʧ��");
		}
	}

	public Message getSystemFinances() {
		Message memberMessage = memberDao.getMemberNum();
		Message hallMessage = hallDao.getHallNum();
		Message orderMessage = orderDao.getOrderNum();
		Message managerMessage = managerDao.findManager(1437);
		if (orderMessage.getResult() == true && memberMessage.getResult() == true && hallMessage.getResult() == true
				&& managerMessage.getResult() == true) {
			long totalMember = (long) memberMessage.getObject();
			long totalHall = (long) hallMessage.getObject();
			long totalOrder = (long) orderMessage.getObject();
			long[] lvlMember = new long[5];
			for (int i = 0; i < 5; i++) {
				Message message = memberDao.getLvlNum(i);
				long count = (long) message.getObject();
				lvlMember[i] = count;
			}
			double totalConsumption = (double) orderDao.getTotalConsumption().getObject();
			double totalIncome = ((Manager) managerMessage.getObject()).getIncome();
			SystemFinanceVo vo = new SystemFinanceVo(totalMember, totalHall, totalOrder, lvlMember, totalConsumption,
					totalIncome);
			return new Message(true, vo, "��ȡ��������ɹ�");
		} else {
			return new Message(false, "��ȡ�������ʧ��");
		}
	}
}
