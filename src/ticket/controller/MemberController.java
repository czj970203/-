package ticket.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ticket.config.Message;
import ticket.dao.HallDao;
import ticket.dao.MemberDao;
import ticket.dao.PayAccountDao;
import ticket.model.Hall;
import ticket.model.Member;
import ticket.model.PayAccount;
import ticket.model.Plan;
import ticket.service.HallService;
import ticket.service.MemberService;
import ticket.service.OrderService;
import ticket.service.PlanService;
import ticket.vo.MemberFinanceVo;
import ticket.vo.MemberUpdateVo;
import ticket.vo.OrderTicketVo;
import ticket.vo.PlanListVo;

@Controller
@RequestMapping(value = "member")
public class MemberController {

	@Resource
	MemberService memberService;
	@Resource
	PlanService planService;
	@Resource
	OrderService orderService;
	@Resource
	HallService hallService;
	@Resource
	HallDao hallDao;
	@Resource
	PayAccountDao payAccountDao;
	@Resource
	MemberDao memberDao;

	@RequestMapping(value = "statistic")
	@ResponseBody
	public Message memberStatistic(HttpSession session) {
		Message message = null;
		if (session.getAttribute("member") != null) {
			Member member = (Member) session.getAttribute("member");
			message = memberService.getMemberInfo(member.getEmail());
			if (message.getResult() == true && member.getState() == 1) {
				MemberFinanceVo vo = (MemberFinanceVo) message.getObject();
				return new Message(true, vo, "��ȡ�û�ͳ�Ƴɹ�");
			} else {
				return message;
			}
		} else {
			return new Message(false, "���ȵ�¼");
		}
	}

	@RequestMapping(value = "info")
	@ResponseBody
	public Message memberInfo(HttpSession session) {
		if (session.getAttribute("member") != null) {
			Member member = (Member) session.getAttribute("member");
			if (member.getState() == 1) {
				return new Message(true, member, "��ȡ�û�������Ϣ�ɹ�");
			} else {
				return new Message(false, "���˻���δ����");
			}
		} else {
			return new Message(false, "���ȵ�¼");
		}
	}

	@RequestMapping(value = "edit")
	@ResponseBody
	public Message updateInfo(HttpSession session, String password, String name, String telephone, String sex) {
		Member member = (Member) session.getAttribute("member");
		int sextemp = 0;
		if (sex.equals("Ů")) {
			sextemp = 1;
		}
		MemberUpdateVo vo = new MemberUpdateVo(member.getEmail(), password, telephone, name, sextemp);
		Message message = memberService.updateMemberInfo(vo);
		if (message.getResult() == true && member.getState() == 1) {
			return new Message(true, "�༭������Ϣ�ɹ�");
		} else {
			return new Message(false, "�༭������Ϣʧ��");
		}
	}

	@RequestMapping(value = "orders")
	@ResponseBody
	public Message getOrders(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		String email = member.getEmail();
		Message message = memberService.viewMemberOrderStatus(email);
		if (message.getResult() == true && member.getState() == 1) {
			return message;
		} else {
			return new Message(false, "��ȡ�û�����ʧ��");
		}
	}

	@RequestMapping(value = "unpaid_orders")
	@ResponseBody
	public Message getUnpaidOrders(HttpSession session) {
		if (session.getAttribute("member") != null) {
			Member member = (Member) session.getAttribute("member");
			String email = member.getEmail();
			Message message = memberService.getUnpaidOrders(email);
			if (message.getResult() == true && member.getState() == 1) {
				return message;
			} else {
				return new Message(false, "��ȡ�û�����ʧ��");
			}
		} else {
			return new Message(false, "���ȵ�¼��");
		}
	}

	@RequestMapping(value = "paid_orders")
	@ResponseBody
	public Message getPaidOrders(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		String email = member.getEmail();
		Message message = memberService.getPaidOrders(email);
		if (message.getResult() == true && member.getState() == 1) {
			return message;
		} else {
			return new Message(false, "��ȡ�û�����ʧ��");
		}
	}

	@RequestMapping(value = "cancelled_orders")
	@ResponseBody
	public Message getCancelledOrders(HttpSession session) {
		Member member = (Member) session.getAttribute("member");
		String email = member.getEmail();
		Message message = memberService.getCancelledOrders(email);
		if (message.getResult() == true && member.getState() == 1) {
			return message;
		} else {
			return new Message(false, "��ȡ�û�����ʧ��");
		}
	}

	@RequestMapping(value = "plan")
	@ResponseBody
	public Message getPlans(HttpSession session, int hallNo) {
		Message message = planService.getHallPlans(hallNo);
		Member member = (Member) session.getAttribute("member");
		List<Plan> list = (List<Plan>) message.getObject();
		List<PlanListVo> result = new ArrayList<PlanListVo>();
		if (message.getResult() == true && member.getState() == 1) {
			for (Plan plan : list) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date nowDate = new Date();
				String showdate = plan.getShowDate();
				Date showDate = null;
				try {
					showDate = dateFormat.parse(showdate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long timetemp = showDate.getTime() - nowDate.getTime();
				if (timetemp > 0) {
					PlanListVo vo = new PlanListVo(member.getEmail(), plan.getPlanNo(), plan.getHallNo(),
							plan.getHallName(), plan.getAddress(), plan.getShowDate(), plan.getJuniorNum(),
							plan.getSeniorNum(), plan.getJuniorPrice(), plan.getSeniorPrice(), plan.getShowType(),
							plan.getDescription());
					result.add(vo);
				}
			}
			return new Message(true, result, "��ȡ���ݼƻ��ɹ�");
		} else {
			return new Message(false, "��ȡ���ݼƻ�ʧ��");
		}
	}

	@RequestMapping(value = "instantBuyTicket")
	@ResponseBody
	public Message instantBuyTicket(HttpSession session, String email, double minused, int option, int ticketNum,
			int ticketType, double ticketPrice, String showDate, String showType, int hallNo) {
		Message hallMessage = hallDao.findHallById(hallNo);
		Hall hall = (Hall) hallMessage.getObject();
		Date orderdate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderDate = dateFormat.format(orderdate);
		// �Ż�ȯ���������(minused)
		double totalPrice = ticketPrice * ticketNum - minused;
		Message memberMessage = memberService.getMember(email);
		List<Member> list = (List<Member>) memberMessage.getObject();
		Member member = list.get(0);
		member.setPoint((int) (member.getPoint() - minused * 100));
		memberDao.update(member);
		OrderTicketVo vo = new OrderTicketVo(email, option, ticketNum, ticketType, totalPrice, orderDate, showDate,
				hallNo, hall.getHallName(), showType, minused);
		return memberService.instantOrderTicket(vo);

	}

	@RequestMapping(value = "selectBuyTicket")
	@ResponseBody
	public Message selectBuyTicket(HttpSession session, String email, double minused, int option, int ticketNum,
			int ticketType, double totalPrice, String showDate, String showType, int hallNo) {
		Message hallMessage = hallDao.findHallById(hallNo);
		Hall hall = (Hall) hallMessage.getObject();
		Date orderdate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderDate = dateFormat.format(orderdate);
		// �Ż�ȯ���������
		double totalprice = totalPrice - minused;
		Message memberMessage = memberService.getMember(email);
		List<Member> list = (List<Member>) memberMessage.getObject();
		Member member = list.get(0);
		member.setPoint((int) (member.getPoint() - minused * 100));
		memberDao.update(member);
		OrderTicketVo vo = new OrderTicketVo(email, option, ticketNum, ticketType, totalprice, orderDate, showDate,
				hallNo, hall.getHallName(), showType, minused);
		return memberService.selectOrderTicket(vo);

	}

	@RequestMapping(value = "cancelOrder")
	@ResponseBody
	// Ĭ��ֻ��֧�����Ķ��������˶�����δ֧�����Զ�15���Ӻ��˶����������Լ��ٶ��û����Ѷ�ͻ��ֵ�����
	public Message cancelOrder(HttpSession session, int orderid) {
		return orderService.cancelOrder(orderid);
	}

	@RequestMapping(value = "searchPlan")
	@ResponseBody
	public Message searchPlan(int hallNo, int planNo) {
		Message message = planService.searchPlan(hallNo, planNo);
		if (message.getResult() == true) {
			List<Plan> list = (List<Plan>) message.getObject();
			List<Plan> result = new ArrayList<Plan>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date nowDate = new Date();
			for (Plan plan : list) {
				String showdate = plan.getShowDate();
				Date showDate = null;
				try {
					showDate = dateFormat.parse(showdate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long timetemp = showDate.getTime() - nowDate.getTime();
				if (timetemp > 0) {
					result.add(plan);
				}
			}
			return new Message(true, result, "��ȡ���ݼƻ��ɹ�");
		} else {
			return new Message(false, "��ȡ���ݼƻ�ʧ��");
		}
	}

	@RequestMapping(value = "searchHall")
	@ResponseBody
	public Message searchHall(int hallNo) {
		Message message = hallService.searchHall(hallNo);
		if (message.getResult() == true) {
			List<Hall> list = (List<Hall>) message.getObject();
			return new Message(true, list, "�������ݳɹ�");
		} else {
			return new Message(false, "��������ʧ��");
		}
	}

	@RequestMapping(value = "stopMember")
	@ResponseBody
	public Message stopMember(String email) {
		return memberService.stopMember(email);
	}

	@RequestMapping(value = "pay")
	@ResponseBody
	public Message payOrder(HttpSession session, String telephone, String password, int orderid, double totalPrice) {
		Member member = (Member) session.getAttribute("member");
		String email = member.getEmail();
		List<PayAccount> list = (List<PayAccount>) payAccountDao.findByEmail(email).getObject();
		PayAccount account = list.get(0);
		if (account.getTelephone().equals(telephone) && account.getPassword().equals(password)) {
			return memberService.payOrder(totalPrice, orderid);
		} else {
			return new Message(false, "֧����Ϣ����");
		}

	}

}
