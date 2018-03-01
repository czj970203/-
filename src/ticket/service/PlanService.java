package ticket.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ticket.config.Message;
import ticket.dao.PlanDao;
import ticket.model.Plan;

@Service
public class PlanService {

	@Resource
	PlanDao planDao;
	
	public Message makePlan(Plan plan) {
		Message message = planDao.addPlan(plan);
		if(message.getResult() == true) {
			message.setReason("�ƻ������ɹ�");
		}else {
			message.setReason("�ƻ�����ʧ��");
		}
		return message;
	}
}
