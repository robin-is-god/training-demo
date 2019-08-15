package com.spdb.training.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.jdbc.core.IRowMapper;
import com.spdb.training.jdbc.core.MapRowMapper;

/**
* @ClassName: StockInfoMapper
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
*
*/

public class StockInfoMapper implements IRowMapper<Stock>{
	@Override
	public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 先使用maprowmapper来完成对象化处理
		Map<String, Object> resultMap = new MapRowMapper().mapRow(rs, rowNum);

		Stock stockInfo = new Stock();
		if (resultMap.containsKey("item_code"))
			stockInfo.setItemCode(rs.getString("item_code"));
		if (resultMap.containsKey("qty"))
			stockInfo.setQty(rs.getInt("qty"));
		return stockInfo;
	}
}
