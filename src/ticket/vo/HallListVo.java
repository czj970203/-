package ticket.vo;

public class HallListVo {
	// �û��˺�
	String email;
	// ���ݱ��루�Զ����ɣ�
	int hallNo;
	// ��������
	String password;
	// ��������
	String hallName;
	// ���ݵص�
	String address;
	// ��ͨ������
	int juniorNum;
	// �ߵ�������
	int seniorNum;
	// �ۼ�Ӫҵ��
	double income;
	// �������
	double percent;

	/**
	 * @param hallNo
	 * @param password
	 * @param hallName
	 * @param address
	 * @param juniorNum
	 * @param seniorNum
	 * @param income
	 * @param percent
	 */
	public HallListVo(String email, int hallNo, String password, String hallName, String address, int juniorNum,
			int seniorNum, double income, double percent) {
		super();
		this.email = email;
		this.hallNo = hallNo;
		this.password = password;
		this.hallName = hallName;
		this.address = address;
		this.juniorNum = juniorNum;
		this.seniorNum = seniorNum;
		this.income = income;
		this.percent = percent;
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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the juniorNum
	 */
	public int getJuniorNum() {
		return juniorNum;
	}

	/**
	 * @param juniorNum
	 *            the juniorNum to set
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
	 * @param seniorNum
	 *            the seniorNum to set
	 */
	public void setSeniorNum(int seniorNum) {
		this.seniorNum = seniorNum;
	}

	/**
	 * @return the income
	 */
	public double getIncome() {
		return income;
	}

	/**
	 * @param income
	 *            the income to set
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	/**
	 * @return the percent
	 */
	public double getPercent() {
		return percent;
	}

	/**
	 * @param percent
	 *            the percent to set
	 */
	public void setPercent(double percent) {
		this.percent = percent;
	}

}