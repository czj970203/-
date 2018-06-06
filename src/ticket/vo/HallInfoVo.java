package ticket.vo;

public class HallInfoVo {
	int hallNo;
	String hallName;
	long totalOrder;
	long onlineOrder;
	long successOrder;
	long cancelledOrder;
	double online_income;
	double offline_income;
	
	/**
	 * @param hallNo
	 * @param hallName
	 * @param totalOrder --- �������¶�������֮��
	 * @param onlineOrder --- ���϶�������
	 * @param successOrder
	 * @param cancelledOrder
	 * @param income
	 */
	public HallInfoVo(int hallNo, String hallName, long totalOrder, long onlineOrder, long successOrder,
			long cancelledOrder, double online_income, double offline_income) {
		super();
		this.hallNo = hallNo;
		this.hallName = hallName;
		this.totalOrder = totalOrder;
		this.onlineOrder = onlineOrder;
		this.successOrder = successOrder;
		this.cancelledOrder = cancelledOrder;
		this.online_income = online_income;
		this.offline_income = offline_income;
	}
	/**
	 * @return the hallNo
	 */
	public int getHallNo() {
		return hallNo;
	}
	/**
	 * @param hallNo the hallNo to set
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
	 * @param hallName the hallName to set
	 */
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	/**
	 * @return the totalOrder
	 */
	public long getTotalOrder() {
		return totalOrder;
	}
	/**
	 * @param totalOrder the totalOrder to set
	 */
	public void setTotalOrder(long totalOrder) {
		this.totalOrder = totalOrder;
	}
	/**
	 * @return the onlineOrder
	 */
	public long getOnlineOrder() {
		return onlineOrder;
	}
	/**
	 * @param onlineOrder the onlineOrder to set
	 */
	public void setOnlineOrder(long onlineOrder) {
		this.onlineOrder = onlineOrder;
	}
	/**
	 * @return the successOrder
	 */
	public long getSuccessOrder() {
		return successOrder;
	}
	/**
	 * @param successOrder the successOrder to set
	 */
	public void setSuccessOrder(long successOrder) {
		this.successOrder = successOrder;
	}
	/**
	 * @return the cancelledOrder
	 */
	public long getCancelledOrder() {
		return cancelledOrder;
	}
	/**
	 * @param cancelledOrder the cancelledOrder to set
	 */
	public void setCancelledOrder(long cancelledOrder) {
		this.cancelledOrder = cancelledOrder;
	}
	/**
	 * @return the online_income
	 */
	public double getOnline_income() {
		return online_income;
	}
	/**
	 * @param online_income the online_income to set
	 */
	public void setOnline_income(double online_income) {
		this.online_income = online_income;
	}
	/**
	 * @return the offline_income
	 */
	public double getOffline_income() {
		return offline_income;
	}
	/**
	 * @param offline_income the offline_income to set
	 */
	public void setOffline_income(double offline_income) {
		this.offline_income = offline_income;
	}
	

}
