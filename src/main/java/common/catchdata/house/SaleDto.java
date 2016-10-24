/**   
 * @Project: Test 
 * @Title: SaleDto.java 
 * @Package common.catchdata.house 
 * @Description: TODO 
 * @author suny 
 * @date 2016年10月24日 下午2:20:49 
 * @Copyright: 2016 年 研信科技. All rights reserved  
 * @version V1.0   
 */
package common.catchdata.house;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * @ClassName SaleDto  
 * @Description TODO 
 * @author suny 
 * @date 2016年10月24日  
 *   
 */
@Entity
//@Entity表示该类能被hibernate持久化
@Table(name = "house_sale_cs")
public class SaleDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@Column(name = "saleNo")
	public String saleNo;
	@Column(name = "roomNo")
	public String roomNo;
	@Column(name = "floorNo")
	public String floorNo;
	@Column(name = "houseUse")
	public String houseUse;
	@Column(name = "housingType")
	public String housingType;
	@Column(name = "decorationStatus")
	public String decorationStatus;
	@Column(name = "builtArea")
	public String builtArea;
	@Column(name = "innerArea")
	public String innerArea;
	@Column(name = "shareArea")
	public String shareArea;
	@Column(name = "price")
	public String price;
	@Column(name = "totalPrice")
	public String totalPrice;
	@Column(name = "SaleStatus")
	public String SaleStatus;
	/** 
	 * @return id 
	 */
	public int getId() {
		return id;
	}
	/** 
	 * @param id 要设置的 id 
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** 
	 * @return saleNo 
	 */
	public String getSaleNo() {
		return saleNo;
	}
	/** 
	 * @param saleNo 要设置的 saleNo 
	 */
	public void setSaleNo(String saleNo) {
		this.saleNo = saleNo;
	}
	/** 
	 * @return roomNo 
	 */
	public String getRoomNo() {
		return roomNo;
	}
	/** 
	 * @param roomNo 要设置的 roomNo 
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	/** 
	 * @return floorNo 
	 */
	public String getFloorNo() {
		return floorNo;
	}
	/** 
	 * @param floorNo 要设置的 floorNo 
	 */
	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}
	/** 
	 * @return houseUse 
	 */
	public String getHouseUse() {
		return houseUse;
	}
	/** 
	 * @param houseUse 要设置的 houseUse 
	 */
	public void setHouseUse(String houseUse) {
		this.houseUse = houseUse;
	}
	/** 
	 * @return housingType 
	 */
	public String getHousingType() {
		return housingType;
	}
	/** 
	 * @param housingType 要设置的 housingType 
	 */
	public void setHousingType(String housingType) {
		this.housingType = housingType;
	}
	/** 
	 * @return decorationStatus 
	 */
	public String getDecorationStatus() {
		return decorationStatus;
	}
	/** 
	 * @param decorationStatus 要设置的 decorationStatus 
	 */
	public void setDecorationStatus(String decorationStatus) {
		this.decorationStatus = decorationStatus;
	}
	/** 
	 * @return builtArea 
	 */
	public String getBuiltArea() {
		return builtArea;
	}
	/** 
	 * @param builtArea 要设置的 builtArea 
	 */
	public void setBuiltArea(String builtArea) {
		this.builtArea = builtArea;
	}
	/** 
	 * @return innerArea 
	 */
	public String getInnerArea() {
		return innerArea;
	}
	/** 
	 * @param innerArea 要设置的 innerArea 
	 */
	public void setInnerArea(String innerArea) {
		this.innerArea = innerArea;
	}
	/** 
	 * @return shareArea 
	 */
	public String getShareArea() {
		return shareArea;
	}
	/** 
	 * @param shareArea 要设置的 shareArea 
	 */
	public void setShareArea(String shareArea) {
		this.shareArea = shareArea;
	}
	/** 
	 * @return price 
	 */
	public String getPrice() {
		return price;
	}
	/** 
	 * @param price 要设置的 price 
	 */
	public void setPrice(String price) {
		this.price = price;
	}
	/** 
	 * @return totalPrice 
	 */
	public String getTotalPrice() {
		return totalPrice;
	}
	/** 
	 * @param totalPrice 要设置的 totalPrice 
	 */
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	/** 
	 * @return saleStatus 
	 */
	public String getSaleStatus() {
		return SaleStatus;
	}
	/** 
	 * @param saleStatus 要设置的 saleStatus 
	 */
	public void setSaleStatus(String saleStatus) {
		SaleStatus = saleStatus;
	}
}
