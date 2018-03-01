package ticket.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
public class Manager {

	// ������
	int managerNo;
	// ��¼����
	String password;
	// �ۼ�Ӫҵ��
	double income;

	/**
	 * @return the managerNo
	 */
	@Id
	public int getManagerNo() {
		return managerNo;
	}

	/**
	 * @param managerNo
	 *            the managerNo to set
	 */
	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
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

}
