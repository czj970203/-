package ticket.vo;

import java.sql.Date;

public class OrderTicketVo {
	// ��Ա�˺�
	String email;
	// ��Ʊѡ�0Ϊѡ������1Ϊ��������
	int toption;
	// ��Ʊ����
	int ticketNum;
	// ��Ʊ���ࣨ0Ϊ��ͨ����1Ϊ�ߵ�����
	int ticketType;
	// �������
	double totalPrice;
	// �µ�ʱ��
	String orderDate;
	// �ݳ�ʱ��
	String showDate;
	// ���ݱ��
	int hallNo;
	// ��������
	String hallName;
	// �ݳ�����
	String showType;
	// �Żݽ��
	double minused;

	/**
	 * @param email
	 * @param toption
	 * @param ticketNum
	 * @param ticketType
	 * @param totalPrice
	 * @param orderDate
	 * @param showDate
	 * @param hallNo
	 * @param hallName
	 * @param showType
	 */
	public OrderTicketVo(String email, int toption, int ticketNum, int ticketType, double totalPrice, String orderDate,
			String showDate, int hallNo, String hallName, String showType, double minused) {
		super();
		this.email = email;
		this.toption = toption;
		this.ticketNum = ticketNum;
		this.ticketType = ticketType;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.showDate = showDate;
		this.hallNo = hallNo;
		this.hallName = hallName;
		this.showType = showType;
		this.minused = minused;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the option
	 */
	public int getToption() {
		return toption;
	}

	/**
	 * @param option
	 *            the option to set
	 */
	public void setToption(int toption) {
		this.toption = toption;
	}

	/**
	 * @return the ticketNum
	 */
	public int getTicketNum() {
		return ticketNum;
	}

	/**
	 * @param ticketNum
	 *            the ticketNum to set
	 */
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	/**
	 * @return the ticketType
	 */
	public int getTicketType() {
		return ticketType;
	}

	/**
	 * @param ticketType
	 *            the ticketType to set
	 */
	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate
	 *            the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @return the showDate
	 */
	public String getShowDate() {
		return showDate;
	}

	/**
	 * @param showDate
	 *            the showDate to set
	 */
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}

	/**
	 * @return the hallNo
	 */
	public int getHallNo() {
		return hallNo;
	}

	/**
	 * @param hallNo
	 *            the hallNo to set
	 */
	public void setHallNo(int hallNo) {
		this.hallNo = hallNo;
	}

	/**
	 * @return the hallName
	 */
	public String getHallName() {
		return hallName;
	}

	/**
	 * @param hallName
	 *            the hallName to set
	 */
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}

	/**
	 * @return the showType
	 */
	public String getShowType() {
		return showType;
	}

	/**
	 * @param showType
	 *            the showType to set
	 */
	public void setShowType(String showType) {
		this.showType = showType;
	}

	/**
	 * @return the minused
	 */
	public double getMinused() {
		return minused;
	}

	/**
	 * @param minused
	 *            the minused to set
	 */
	public void setMinused(double minused) {
		this.minused = minused;
	}

}
