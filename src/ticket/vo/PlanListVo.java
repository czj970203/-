package ticket.vo;

public class PlanListVo {
	// ��Ա�˻�
	String email;
	// �ƻ����
	int planNo;
	// ���ݱ���
	int hallNo;
	// ��������
	String hallName;
	// ���ݵص�
	String address;
	// �ݳ�ʱ��
	String showDate;
	// ʣ����ͨ������
	int juniorNum;
	// ʣ��ߵ�������
	int seniorNum;
	// ��ͨ���۸�
	double juniorPrice;
	// �ߵ����۸�
	double seniorPrice;
	// �ݳ�����
	String showType;
	// ��������
	String description;
	/**
	 * @param email
	 * @param planNo
	 * @param hallNo
	 * @param hallName
	 * @param address
	 * @param showDate
	 * @param juniorNum
	 * @param seniorNum
	 * @param juniorPrice
	 * @param seniorPrice
	 * @param showType
	 * @param description
	 */
	public PlanListVo(String email, int planNo, int hallNo, String hallName, String address, String showDate,
			int juniorNum, int seniorNum, double juniorPrice, double seniorPrice, String showType, String description) {
		super();
		this.email = email;
		this.planNo = planNo;
		this.hallNo = hallNo;
		this.hallName = hallName;
		this.address = address;
		this.showDate = showDate;
		this.juniorNum = juniorNum;
		this.seniorNum = seniorNum;
		this.juniorPrice = juniorPrice;
		this.seniorPrice = seniorPrice;
		this.showType = showType;
		this.description = description;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the planNo
	 */
	public int getPlanNo() {
		return planNo;
	}
	/**
	 * @param planNo the planNo to set
	 */
	public void setPlanNo(int planNo) {
		this.planNo = planNo;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the showDate
	 */
	public String getShowDate() {
		return showDate;
	}
	/**
	 * @param showDate the showDate to set
	 */
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	/**
	 * @return the juniorNum
	 */
	public int getJuniorNum() {
		return juniorNum;
	}
	/**
	 * @param juniorNum the juniorNum to set
	 */
	public void setJuniorNum(int juniorNum) {
		this.juniorNum = juniorNum;
	}
	/**
	 * @return the seniorNum
	 */
	public int getSeniorNum() {
		return seniorNum;
	}
	/**
	 * @param seniorNum the seniorNum to set
	 */
	public void setSeniorNum(int seniorNum) {
		this.seniorNum = seniorNum;
	}
	/**
	 * @return the juniorPrice
	 */
	public double getJuniorPrice() {
		return juniorPrice;
	}
	/**
	 * @param juniorPrice the juniorPrice to set
	 */
	public void setJuniorPrice(double juniorPrice) {
		this.juniorPrice = juniorPrice;
	}
	/**
	 * @return the seniorPrice
	 */
	public double getSeniorPrice() {
		return seniorPrice;
	}
	/**
	 * @param seniorPrice the seniorPrice to set
	 */
	public void setSeniorPrice(double seniorPrice) {
		this.seniorPrice = seniorPrice;
	}
	/**
	 * @return the showType
	 */
	public String getShowType() {
		return showType;
	}
	/**
	 * @param showType the showType to set
	 */
	public void setShowType(String showType) {
		this.showType = showType;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
