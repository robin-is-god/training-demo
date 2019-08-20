package com.spdb.training.services;

import com.spdb.training.beans.order.Order;
import com.spdb.training.beans.order.OrderRsp;
import com.spdb.training.beans.trans.TransReqContext;
import com.spdb.training.beans.trans.TransRspContext;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.services.order.OrderServiceImpl;

/**
* @ClassName: OrderTransService
* @Description: TODO:
* @author Robin
* @date 2019年8月20日
*
*/

public class OrderTransService implements ITransServices<Order, OrderRsp>{
	
	ILog log = LoggerFactory.getLogger(OrderTransService.class);
	private OrderServiceImpl orderServiceImpl;
	
	@Override
	public void execute(TransReqContext<Order> reqContext, TransRspContext<OrderRsp> rspContext) {
		if (orderServiceImpl == null) {
			orderServiceImpl = new OrderServiceImpl();
		}
		
		Order context = reqContext.getContext();
		log.info(context.toString());
	}
	
	public static void main(String[] args) {
		
	}
}
