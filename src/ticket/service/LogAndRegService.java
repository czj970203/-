package ticket.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ticket.config.Message;
import ticket.dao.HallDao;
import ticket.dao.ManagerDao;
import ticket.dao.MemberDao;
import ticket.dao.RegistryDao;
import ticket.model.Hall;
import ticket.model.Manager;
import ticket.model.Member;
import ticket.model.Registry;

@Service
public class LogAndRegService {

	@Resource
	MemberDao memberDao;

	@Resource
	HallDao hallDao;

	@Resource
	ManagerDao managerDao;

	@Resource
	RegistryDao registryDao;

	public Message memberLogin(String email, String password) {
		Message message = memberDao.findMemberByEmail(email);
		if (message.getResult() == false) {
			return new Message(false, "���û�������");
		} else {
			Member member = (Member) message.getObject();
			return checkPasswd(member, member.getPassword(), password);
		}
	}

	public Message hallLogin(int hallNo, String password) {
		Message message = hallDao.findHallById(hallNo);
		if (message.getResult() == false) {
			return new Message(false, "�ó��ݲ�����");
		} else {
			Hall hall = (Hall) message.getObject();
			return checkPasswd(hall, hall.getPassword(), password);
		}

	}

	public Message managerLogin(int managerNo, String password) {
		Message message = managerDao.findManager(managerNo);
		if (message.getResult() == false) {
			return new Message(false, "�þ�������");
		} else {
			Manager manager = (Manager) message.getObject();
			return checkPasswd(manager, manager.getPassword(), password);
		}
	}

	public Message memberRegister(Member member) {
		member.setState(1);
		member.setBalance(0.0);
		member.setConsumption(0.0);
		member.setLevel(0);
		member.setPoint(0);
		member.setDiscount(1.0);
		Message message = memberDao.register(member);
		if (message.getResult() == true) {
			return new Message(true, "��Աע��ɹ�");
		} else {
			return new Message(false, "��Աע��ʧ��");
		}
	}

	public Message hallRegister(Registry reg) {
		return registryDao.addReg(reg);
	}

	private Message checkPasswd(Object object, String correct, String input) {
		if (correct.equals(input)) {
			return new Message(true, object, "��¼�ɹ�");
		} else {
			return new Message(false, "�û������������");
		}
	}

}
