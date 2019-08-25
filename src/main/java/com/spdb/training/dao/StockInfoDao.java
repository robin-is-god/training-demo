package com.spdb.training.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.jdbc.core.JdbcTemplate;
import com.spdb.training.jdbc.core.JdbcTemplateFactory;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.rowMapper.OrderInfoMapper;
import com.spdb.training.rowMapper.StockInfoMapper;

/**
 * 
 * @author 	ai12345
 * TODO		底层操作数据库商品库存表
 *
 */
public class StockInfoDao {
	private static ILog logger = LoggerFactory.getLogger(StockInfoDao.class);

	private static JdbcTemplate jdbcTemplate = null;
	static {
		try {
			jdbcTemplate = JdbcTemplateFactory.getJdbcTemplate();
		} catch (IOException | SQLException e) {
			logger.error("failed to get jdbctemplate obj", e);

		}

	}

	/**
	 * 插入
	 * 
	 * @param stock
	 * @return
	 * @throws SQLException
	 */
	public static int insert(Stock stock) throws SQLException {
		return 0;
	}

	/**
	 * 根据商品编号获取库存信息
	 * @param itemCode		商品代码
	 * @return				对应商品的库存信息
	 * @throws SQLException
	 */
	public static Stock queryByItemCode(String itemCode) throws SQLException {
		String sql = "select item_code,qty from  bigtraining.stock where item_code = ?";

		return jdbcTemplate.queryForObj(sql, new StockInfoMapper(), itemCode);
	}

	/**
	 * 根据商品编号更新库存
	 * @param itemCode		商品代码
	 * @param decNum		减少的数值
	 * @return				当前操作影响的行数
	 * @throws SQLException
	 */
	public static int updateStock(String itemCode, Integer decNum) throws SQLException {
		String sql = "update bigtraining.stock set qty = qty - ?  where item_code = ?";
		return jdbcTemplate.update(sql, decNum, itemCode);
	}

	/**
	 * 根据商品编号删除商品
	 * 
	 * @param itemCode
	 * @return
	 * @throws SQLException
	 */
	public static int deleteStock(String itemCode) throws SQLException {
		return 0;

	}

	/**
	 * 查询所有有库存的商品
	 * 
	 * @return				未售完商品库存列表
	 * @throws SQLException
	 */
	public static List<Stock> queryIFQty() throws SQLException {
		String sql = "select item_code, qty from  bigtraining.stock where qty > 0 "; 
		return jdbcTemplate.query(sql, new StockInfoMapper());
	}
	
	/**
	 * 查询商品库存量
	 * @param itemCode
	 * @return
	 * @throws SQLException
	 */
	public static Stock queryQtyByItemCode(String itemCode) throws SQLException {
		String sql = "select *  from  bigtraining.order where item_code = ?";
		return jdbcTemplate.queryForObj(sql, new StockInfoMapper(), itemCode);
	}
}
