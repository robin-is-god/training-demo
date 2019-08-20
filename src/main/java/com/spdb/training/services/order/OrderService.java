package com.spdb.training.services.order;

import com.spdb.training.beans.order.Order;

/**
 * @ClassName:OrderService
 * @Descritpion:TODO:
 * @author annliao
 * @date:2019年8月16日
 *
 */
public interface OrderService {
	//购买增加一条记录
	boolean insert(Order order);
	
}