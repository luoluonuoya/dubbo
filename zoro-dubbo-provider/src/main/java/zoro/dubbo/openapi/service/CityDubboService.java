package zoro.dubbo.openapi.service;

import zoro.dubbo.openapi.model.City;

/**  
 * @Title: CityDubboService.java
 * @Package zoro.dubbo.openapi.service
 * @company：     
 * @Description: TODO
 * @author zoro
 * @date 2017年7月7日 下午3:26:52
 * @version V1.0  
 */
public interface CityDubboService {
	
	City findCityByName(String cityName);

}
