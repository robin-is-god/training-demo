package com.spdb.training.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.spdb.training.beans.order.Order;
import com.spdb.training.beans.stock.Stock;
import com.spdb.training.jdbc.core.JdbcTemplate;
import com.spdb.training.jdbc.core.JdbcTemplateFactory;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.rowMapper.StockInfoMapper;


public class OrderInfoDao {
	private static ILog logger = LoggerFactory.getLogger(OrderInfoDao.class);

	private static JdbcTemplate jdbcTemplate = null;
	static {
		try {
			jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate();
		} catch (IOException | SQLException e) {
			logger.error("failed to get jdbctemplate obj", e);

		}

	}

	public static int insert(Order orderInfo) throws SQLException {
		String sql = "insert into  bigtraining.order(order_id ,Item_code,order_qty,order_date,order_time,order_user)"
				+ "values(?,?,?,?,?,?)";
		Object[] args = { orderInfo.getOrderId(), orderInfo.getItemCode(), orderInfo.getQty(), orderInfo.getOrderDate(),
				orderInfo.getOrderTime(), orderInfo.getOrderUser() };
		return jdbcTemplate.update(sql, args);
	}
  
	public static int deleteById(String id) throws SQLException {
		String sql = "delete from   bigtraining.order  where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	public static List<Stock> queryTotalQtyByItemCode() throws SQLException {
		String sql = "select Item_code,SUM(order_qty)  from  bigtraining.order group by Item_code";
		return jdbcTemplate.query(sql, new StockInfoMapper());

	}
}
