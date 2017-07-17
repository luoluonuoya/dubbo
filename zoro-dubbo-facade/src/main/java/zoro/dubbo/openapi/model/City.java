package zoro.dubbo.openapi.model;

import java.io.Serializable;

/**  
 * @Title: City.java
 * @Package zoro.dubbo.openapi.model
 * @company：    
 * @Description: TODO
 * @author zoro
 * @date 2017年7月7日 下午4:56:00
 * @version V1.0  
 */
public class City implements Serializable {

	private static final long serialVersionUID = -798641804258414744L;

	public City(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}
	
	private String name;
	
	private String desc;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "City [name=" + name + ", desc=" + desc + "]";
	}

}