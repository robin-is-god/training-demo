package com.spdb.training.services.stock;

import java.util.List;

import com.spdb.training.beans.stock.Stock;

/**
* @ClassName: StockService
* @Description: TODO:
* @author Robin
* @date 2019年8月15日
*
*/

public interface StockService {
	Stock queryStockByItemCode(String itemCode);
	List<Stock>  queryStockHaveQty();
	boolean updateStockQtyByItemCode(String itemCode);
}
