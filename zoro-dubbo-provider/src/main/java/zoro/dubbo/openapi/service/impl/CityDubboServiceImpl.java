package zoro.dubbo.openapi.service.impl;

import org.springframework.stereotype.Service;

import zoro.dubbo.openapi.model.City;
import zoro.dubbo.openapi.service.CityDubboService;

/**  
 * @Title: CityDubboServiceImpl.java
 * @Package zoro.dubbo.openapi.service.impl
 * @company：     
 * @Description: TODO
 * @author zoro
 * @date 2017年7月7日 下午3:27:10
 * @version V1.0  
 */
@Service
public class CityDubboServiceImpl implements CityDubboService {
	
	public City findCityByName(String cityName) {
		return new City("广州", "羊城");
	}

}
