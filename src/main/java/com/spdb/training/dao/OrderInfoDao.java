package com.spdb.training.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.spdb.training.beans.order.Order;
import com.spdb.training.jdbc.core.JdbcTemplate;
import com.spdb.training.jdbc.core.JdbcTemplateFactory;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.rowMapper.OrderInfoMapper;

/**
 * 
 * @author ai12345TODO TODO 实现订单表的底层操作
 */
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

	/**
	 * TODO				将订单信息插入订单表		
	 * @param orderInfo	订单信息
	 * @return			本次操作影响的行数
	 * @throws SQLException
	 */
	public static int insert(Order orderInfo) throws SQLException {
		String sql = "insert into  bigtraining.order(item_code,order_qty,order_date,order_time,order_user)"
				+ "values(?,?,?,?,?)";
		Object[] args = { orderInfo.getOrderCode(), orderInfo.getOrderNum(), orderInfo.getOrderDate(),
				orderInfo.getOrderTime(), orderInfo.getOrderUser() };
		return jdbcTemplate.update(sql, args);
	}

	/**
	 * TODO					根据订单号删除订单信息
	 * @param id			订单号
	 * @return				本次操作影响的行数
	 * @throws SQLException
	 */
	public static int deleteById(String id) throws SQLException {
		String sql = "delete from   bigtraining.order  where id = ?";
		return jdbcTemplate.update(sql, id);
	}

	/**
	 * TODO					查询订单表各种商品的销售数量
	 * @return				已售商品统计信息表（结构和Stock类属性一致）
	 * @throws SQLException
	 */
	public static List<Order> queryTotalQtyByItemCode() throws SQLException {
		String sql = "select Item_code,SUM(order_qty)  from  bigtraining.order group by Item_code";
		return jdbcTemplate.query(sql, new OrderInfoMapper());

	}
	
}
