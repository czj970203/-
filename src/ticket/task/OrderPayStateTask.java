package ticket.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import ticket.config.Message;
import ticket.dao.MemberDao;
import ticket.dao.OrderDao;
import ticket.model.Member;
import ticket.model.Order;

@Component
public class OrderPayStateTask {
	@Resource
	OrderDao orderDao;
	@Resource
	MemberDao memberDao;

	// ÿ���Ӷ���鶩��״̬�������µ�ʱ��ʮ����Ӻ���δ֧���Ķ�����ȡ��
	@Scheduled(cron = "0 * * * * ?")
	public void checkOrderPayState() {
		Message orderMessage = orderDao.getUnpaidOrders();
		if (orderMessage.getResult() == true) {
			List<Order> list = (List<Order>) orderMessage.getObject();
			if (list.size() != 0) {
				for (Order order : list) {
					String orderdate = order.getOrderDate();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Date orderDate = null;
					try {
						orderDate = dateFormat.parse(orderdate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					Date nowDate = new Date();
					long timetemp = nowDate.getTime() - orderDate.getTime();
					long pastMin = timetemp / (60 * 1000);
					if (pastMin > 15) {
						Message message = memberDao.findMemberByEmail(order.getEmail());
						List<Member> list1 = (List<Member>) message.getObject();
						Member member = list1.get(0);
						member.setPoint((int) (member.getPoint() + order.getMinused() * 100));
						order.setIsCancelled(0);
						memberDao.update(member);
						orderDao.update(order);
					}
				}
			}else {
				System.out.println("��ǰ��δ֧������");
			}
		}
	}

}
