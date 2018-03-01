package ticket.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {
	// ������
	int orderid;
	// ��Ա�˺�
	String email;
	// ��Ʊ������0��ʾ����Ԥ����1��ʾ���¹�Ʊ��
	int orderMethod;
	// ��Ʊѡ�0Ϊѡ������1Ϊ��������
	int option;
	// ��Ʊ����
	int ticketNum;
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
	// �Ƿ��˶���0Ϊ�˶���1Ϊ���˶���
	int isCancelled;
	// �Ƿ������̼ң�0Ϊδ���㣬1Ϊ�ѽ���)
	int isSettled;
	// ���ݱ��
	int hallNo;
	// ��������
	String hallName;
	// �ݳ�����
	String showType;
	
	public Order() {
		
	}

	/**
	 * @return the orderid
	 */
	@Id
	@GeneratedValue
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
	public int getOption() {
		return option;
	}

	/**
	 * @param option
	 *            the option to set
	 */
	public void setOption(int option) {
		this.option = option;
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
	 * @return the conState
	 */
	public int getIsCancelled() {
		return isCancelled;
	}

	/**
	 * @param conState
	 *            the conState to set
	 */
	public void setIsCancelled(int isCancelled) {
		this.isCancelled = isCancelled;
	}

	/**
	 * @return the isSettled
	 */
	public int getIsSettled() {
		return isSettled;
	}

	/**
	 * @param isSettled
	 *            the isSettled to set
	 */
	public void setIsSettled(int isSettled) {
		this.isSettled = isSettled;
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
