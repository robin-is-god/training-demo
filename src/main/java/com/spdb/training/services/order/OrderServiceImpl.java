package com.spdb.training.services.order;

import java.sql.SQLException;

import com.spdb.training.beans.order.Order;
import com.spdb.training.dao.OrderInfoDao;
import com.spdb.training.exception.ExceptionHandle;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;

/**
* @ClassName: OrderServiceImpl
* @Description: TODO:
* @author Robin
* @date 2019年8月20日
*
*/

public class OrderServiceImpl implements OrderService {
	private static ILog logger = LoggerFactory.getLogger(OrderService.class);

	@Override
	public boolean insert(Order order) {
		try {
			int rs = OrderInfoDao.insert(order);
			if (rs == 1)
			logger.info("生成订单成功：{}", order.toString()); 
			return true;
		} catch (SQLException e) {
			ExceptionHandle.handle(e);
		}
		return false; 
	}
}
