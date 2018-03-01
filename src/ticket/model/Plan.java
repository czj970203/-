package ticket.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "plan")
public class Plan {

	// �ƻ����
	int planNo;
	// ���ݱ���
	int hallNo;
	// ��������
	String hallName;
	// ���ݵص�
	String address;
	// �ݳ�ʱ��
	long showDate;
	// ��ͨ���۸�
	double juniorPrice;
	// �ߵ����۸�
	double seniorPrice;
	// �ݳ�����
	String showType;
	// ��������
	String description;

	/**
	 * @return the planNo
	 */
	public int getPlanNo() {
		return planNo;
	}

	/**
	 * @param planNo
	 *            the planNo to set
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
	 * @return the showDate
	 */
	public long getShowDate() {
		return showDate;
	}

	/**
	 * @param showDate
	 *            the showDate to set
	 */
	public void setShowDate(long showDate) {
		this.showDate = showDate;
	}

	/**
	 * @return the juniorPrice
	 */
	public double getJuniorPrice() {
		return juniorPrice;
	}

	/**
	 * @param juniorPrice
	 *            the juniorPrice to set
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
	 * @param seniorPrice
	 *            the seniorPrice to set
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
	 * @param showType
	 *            the showType to set
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
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
