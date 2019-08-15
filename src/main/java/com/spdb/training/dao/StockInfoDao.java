package com.spdb.training.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.jdbc.core.JdbcTemplate;
import com.spdb.training.jdbc.core.JdbcTemplateFactory;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.rowMapper.StockInfoMapper;

/**
* @ClassName: StockInfoDao
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
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
	 * @param stock
	 * @return
	 * @throws SQLException
	 */
	public static int insert(Stock stock) throws SQLException {
		return 0;
	}
	
	/**
	 * 根据商品编号查询商品
	 * @param itemCode
	 * @return
	 * @throws SQLException
	 */
	public static Stock queryBy(String itemCode) throws SQLException {
		String sql = "select item_code,qty from  bigtraining.stock where item_code = ?";
		
		return jdbcTemplate.queryForObj(sql, new StockInfoMapper(), itemCode);
	}
	
	/**
	 * 根据商品编号更新库存
	 * @param itemCode
	 * @return
	 * @throws SQLException
	 */
	public static int updateStock(String itemCode, Integer num) throws SQLException {
		return 0;
	}
	
	/**
	 * 根据商品编号删除商品
	 * @param itemCode
	 * @return
	 * @throws SQLException
	 */
	public static int deleteStock(String itemCode) throws SQLException {
		return 0;
	}
	
	/**
	 * 查询所有有库存的商品
	 * @return
	 * @throws SQLException
	 */
	public static List<Stock> queryByPage() throws SQLException {
		String sql = "";
		return jdbcTemplate.query(sql, new StockInfoMapper());
	}
}
