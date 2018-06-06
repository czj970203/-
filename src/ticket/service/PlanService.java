package ticket.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ticket.config.Message;
import ticket.dao.PlanDao;
import ticket.dao.SeatDao;
import ticket.model.Plan;
import ticket.model.Seat;
import ticket.vo.SeatConditionVo;

@Service
public class PlanService {

	@Resource
	PlanDao planDao;
	@Resource
	SeatDao seatDao;

	public Message makePlan(Plan plan) {
		Message message = planDao.addPlan(plan);
		if (message.getResult() == true) {

			message.setReason("�ƻ������ɹ�");
		} else {
			message.setReason("�ƻ�����ʧ��");
		}
		return message;
	}

	public Message getHallPlans(int hallNo) {
		Message planMessage = planDao.findPlanByHotel(hallNo);
		if (planMessage.getResult() == true) {
			List<Plan> list = (List<Plan>) planMessage.getObject();
			return new Message(true, list, "��ȡ�Ƶ�ƻ��ɹ�");
		} else {
			return new Message(false, "�Ƶ���Ϣ����");
		}
	}

	public Message getPlanInfo(int planNo) {
		Message message = planDao.findPlanById(planNo);
		if (message.getResult() == true) {
			Plan plan = (Plan) message.getObject();
			return new Message(true, plan, "��ȡ�ƻ���Ϣ�ɹ�");
		} else {
			return new Message(false, "�üƻ�������");
		}
	}

	public Message arrangeSeats(int planNo) {
		Message message = planDao.findPlanById(planNo);
		if (message.getResult() == true) {
			Plan plan = (Plan) message.getObject();
			int juniorNum = plan.getJuniorNum();
			int seniorNum = plan.getSeniorNum();
			int maxColumn = 7;
			int junMaxRow = juniorNum / maxColumn;
			int senMaxRow = seniorNum / maxColumn;
			int junRemain = juniorNum % maxColumn;
			int senRemain = seniorNum % maxColumn;
			for (int i = 0; i < junMaxRow; i++) {
				for (int j = 0; j < 7; j++) {
					Seat seat = new Seat();
					seat.setPlanNo(planNo);
					seat.setSrow(i);
					seat.setScolumn(j);
					seat.setType(0);
					seat.setOccupied(0);
					seatDao.addSeat(seat);
				}
			}
			for (int i = 0; i < junRemain; i++) {
				Seat seat = new Seat();
				seat.setPlanNo(planNo);
				seat.setSrow(junMaxRow);
				seat.setScolumn(i);
				seat.setType(0);
				seat.setOccupied(0);
				seatDao.addSeat(seat);
			}
			for (int i = 0; i < senMaxRow; i++) {
				for (int j = 0; j < 7; j++) {
					Seat seat = new Seat();
					seat.setPlanNo(planNo);
					seat.setSrow(i);
					seat.setScolumn(j);
					seat.setType(1);
					seat.setOccupied(0);
					seatDao.addSeat(seat);
				}
			}

			for (int i = 0; i < senRemain; i++) {
				Seat seat = new Seat();
				seat.setPlanNo(planNo);
				seat.setSrow(senMaxRow);
				seat.setScolumn(i);
				seat.setType(1);
				seat.setOccupied(0);
				seatDao.addSeat(seat);
			}
			return new Message(true, "��λ���ųɹ�");
		} else {
			return new Message(false, "��λ����ʧ��");
		}
	}

	public Message getJunSeatCondition(int planNo) {
		Message message = seatDao.getSeatById(planNo);
		if (message.getResult() == true) {
			List<Seat> list = (List<Seat>) message.getObject();
			Message planMessage = planDao.findPlanById(planNo);
			Plan plan = (Plan) planMessage.getObject();
			int juniorNum = plan.getJuniorNum();
			int maxRow = juniorNum % 7 == 0 ? juniorNum / 7 : juniorNum / 7 + 1;
			int remaining = juniorNum % 7;
			char[][] map = new char[maxRow][7];
			List<String> unavailable = new ArrayList<String>();
			for (Seat seat : list) {
				if (seat.getType() == 0) {
					map[seat.getSrow()][seat.getScolumn()] = 'c';
				}
				for (int m = remaining; m < 7; m++) {
					if (map[maxRow - 1][m] != 'c') {
						map[maxRow - 1][m] = '_';
					}
				}
				if (seat.getType() == 0 && seat.getOccupied() == 1) {
					int row = seat.getSrow() + 1;
					int column = seat.getScolumn() + 1;
					String seatNo = row + "_" + column;
					unavailable.add(seatNo);
				}
			}
			SeatConditionVo vo = new SeatConditionVo(map, unavailable);
			return new Message(true, vo, "��ȡ��λ��Ϣ�ɹ�");

		} else {
			return new Message(false, "��ȡ��λ��Ϣʧ��");
		}
	}

	public Message getSenSeatCondition(int planNo) {
		Message message = seatDao.getSeatById(planNo);
		if (message.getResult() == true) {
			List<Seat> list = (List<Seat>) message.getObject();
			Message planMessage = planDao.findPlanById(planNo);
			Plan plan = (Plan) planMessage.getObject();
			int seniorNum = plan.getSeniorNum();
			int maxRow = seniorNum % 7 == 0 ? seniorNum / 7 : seniorNum / 7 + 1;
			char[][] map = new char[maxRow][7];
			List<String> unavailable = new ArrayList<String>();
			for (Seat seat : list) {
				if (seat.getType() == 1) {
					map[seat.getSrow()][seat.getScolumn()] = 'c';
				}
				for (int m = 0; m < 7; m++) {
					if (map[maxRow - 1][m] != 'c') {
						map[maxRow - 1][m] = '_';
					}
				}
				if (seat.getType() == 1 && seat.getOccupied() == 1) {
					int row = seat.getSrow() + 1;
					int column = seat.getScolumn() + 1;
					String seatNo = row + "_" + column;
					unavailable.add(seatNo);
				}
			}
			SeatConditionVo vo = new SeatConditionVo(map, unavailable);
			return new Message(true, vo, "��ȡ��λ��Ϣ�ɹ�");

		} else {
			return new Message(false, "��ȡ��λ��Ϣʧ��");
		}
	}
	
	public Message searchPlan(int hallNo,int planNo) {
		return planDao.searchPlan(hallNo, planNo);
	}
}
