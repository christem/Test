
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
@Table(name = "house_sale_static")
public class SaleStaticDto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@Column(name = "saleNo")
	public String saleNo;
	@Column(name = "count")
	public int count;
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
	 * @return count 
	 */
	public int getCount() {
		return count;
	}
	/** 
	 * @param count 要设置的 count 
	 */
	public void setCount(int count) {
		this.count = count;
	}
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
	
}
