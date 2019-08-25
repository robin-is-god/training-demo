package com.spdb.training.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.spdb.training.beans.order.Order;
import com.spdb.training.beans.stock.Stock;
import com.spdb.training.jdbc.core.IRowMapper;
import com.spdb.training.jdbc.core.MapRowMapper;

/**
* @ClassName: OrderInfoMapper
* @Description: TODO:
* @author Robin
* @date 2019年8月20日
*
*/

public class OrderInfoMapper implements IRowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Map<String, Object> resultMap = new MapRowMapper().mapRow(rs, rowNum);

		Order orderInfo = new Order();
		if (resultMap.containsKey("order_id"))
			orderInfo.setOrderId(rs.getInt("order_id"));
		
		if (resultMap.containsKey("item_code"))
			orderInfo.setOrderCode(rs.getString("item_code"));
		
		if (resultMap.containsKey("order_qty"))
			orderInfo.setOrderNum(rs.getInt("order_qty"));
		
		if (resultMap.containsKey("order_date"))
			orderInfo.setOrderDate(rs.getString("order_date"));
		
		if (resultMap.containsKey("order_time"))
			orderInfo.setOrderTime(rs.getString("order_time"));
		
		if (resultMap.containsKey("order_user"))
			orderInfo.setOrderUser(rs.getString("order_user"));
		return orderInfo;
	}
	
}
