package zoro.dubbo.openapi.facade;

import zoro.dubbo.openapi.model.City;

/**  
 * @Title: CityDubboFacade.java
 * @Package zoro.dubbo.openapi.facade
 * @company：    
 * @Description: TODO
 * @author zoro
 * @date 2017年7月7日 下午4:55:46
 * @version V1.0
 */
public interface CityDubboFacade {

	City findCityByName(String cityName);

}
