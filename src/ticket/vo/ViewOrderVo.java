package ticket.vo;

import ticket.model.Order;

public class ViewOrderVo {
	// ������
	int orderid;
	// ��Ա�˺�
	String email;
	// ��Ʊ������0��ʾ����Ԥ����1��ʾ���¹�Ʊ��
	int orderMethod;
	// ��Ʊѡ�0Ϊѡ������1Ϊ��������
	int toption;
	// ��Ʊ����
	int ticketNum;
	// ��Ʊ����(0Ϊ��ͨ����1Ϊ�ߵ�����
	int ticketType;
	// �������
	double totalPrice;
	// �µ�ʱ��
	String orderDate;
	// �ݳ�ʱ��
	String showDate;
	// ֧��״̬��0Ϊδ֧����1Ϊ��֧��,���¹�ƱĬ����֧����
	int payState;
	// ��Ʊ״̬��0Ϊʧ�ܣ�1Ϊ�ɹ���ѡ������Ĭ�ϳɹ���
	int allocState;
	// ���ݱ��
	int hallNo;
	// ��������
	String hallName;
	// �ݳ�����
	String showType;

	/**
	 * @param orderid
	 * @param email
	 * @param orderMethod
	 * @param toption
	 * @param ticketNum
	 * @param ticketType
	 * @param totalPrice
	 * @param orderDate
	 * @param showDate
	 * @param payState
	 * @param allocState
	 * @param hallNo
	 * @param hallName
	 * @param showType
	 */
	public ViewOrderVo(int orderid, String email, int orderMethod, int toption, int ticketNum, int ticketType,
			double totalPrice, String orderDate, String showDate, int payState, int allocState, int hallNo,
			String hallName, String showType) {
		super();
		this.orderid = orderid;
		this.email = email;
		this.orderMethod = orderMethod;
		this.toption = toption;
		this.ticketNum = ticketNum;
		this.ticketType = ticketType;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.showDate = showDate;
		this.payState = payState;
		this.allocState = allocState;
		this.hallNo = hallNo;
		this.hallName = hallName;
		this.showType = showType;
	}

	public ViewOrderVo(Order order) {
		this.orderid = order.getOrderid();
		this.email = order.getEmail();
		this.orderMethod = order.getOrderMethod();
		this.toption = order.getToption();
		this.ticketNum = order.getTicketNum();
		this.ticketType = order.getTicketType();
		this.totalPrice = order.getTotalPrice();
		this.orderDate = order.getOrderDate();
		this.showDate = order.getShowDate();
		this.payState = order.getPayState();
		this.allocState = order.getAllocState();
		this.hallNo = order.getHallNo();
		this.hallName = order.getHallName();
		this.showType = order.getShowType();
	}

	/**
	 * @return the orderid
	 */
	public int getOrderid() {
		return orderid;
	}

	/**
	 * @param orderid
	 *            the orderid to set
	 */
	public void setOrderid(int orderid) {
		this.orderid = orderid;
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
	 * @return the orderMethod
	 */
	public int getOrderMethod() {
		return orderMethod;
	}

	/**
	 * @param orderMethod
	 *            the orderMethod to set
	 */
	public void setOrderMethod(int orderMethod) {
		this.orderMethod = orderMethod;
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
	 * @return the payState
	 */
	public int getPayState() {
		return payState;
	}

	/**
	 * @param payState
	 *            the payState to set
	 */
	public void setPayState(int payState) {
		this.payState = payState;
	}

	/**
	 * @return the allocState
	 */
	public int getAllocState() {
		return allocState;
	}

	/**
	 * @param allocState
	 *            the allocState to set
	 */
	public void setAllocState(int allocState) {
		this.allocState = allocState;
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

}
