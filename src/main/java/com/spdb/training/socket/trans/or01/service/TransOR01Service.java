package com.spdb.training.socket.trans.or01.service;

import java.util.ArrayList;
import java.util.List;

import com.spdb.training.beans.stock.Stock;
import com.spdb.training.beans.stock.StockRsp;
import com.spdb.training.exception.BusinessException;
import com.spdb.training.log.ILog;
import com.spdb.training.log.LoggerFactory;
import com.spdb.training.services.ResultCodeEnum;
import com.spdb.training.services.StockTransServices;
import com.spdb.training.services.stock.StockServiceImpl;
import com.spdb.training.socket.trans.anno.TransCodeAnno;
import com.spdb.training.socket.trans.entity.TransReqContext;
import com.spdb.training.socket.trans.entity.TransRspContext;
import com.spdb.training.socket.trans.or01.ReqOR01Service;
import com.spdb.training.socket.trans.or01.RspOR01Service;
import com.spdb.training.socket.trans.or01.RspOR01ServiceBody;
import com.spdb.training.socket.trans.service.AbsAtomicTransService;

/** 
* @author 作者: 王腾蛟
* @version time：2019年6月18日 下午4:20:13 
*   类说明: 测试用的交易OR01
*/
@TransCodeAnno("OR01")
public class TransOR01Service extends AbsAtomicTransService<ReqOR01Service, RspOR01Service> {
	
	ILog log = LoggerFactory.getLogger(TransOR01Service.class);
	private StockServiceImpl stockServiceImpl;

	@Override
	public void process(TransReqContext<ReqOR01Service> reqContext, TransRspContext<RspOR01Service> rspContext) {
		//报文编写方式2，根据具体业务获取写入
		
		ReqOR01Service context = reqContext.getContext();
		//获取body context.getBody()
		
		RspOR01ServiceBody body = new RspOR01ServiceBody();
		
		if (stockServiceImpl == null) {
			stockServiceImpl = new StockServiceImpl();
		}
		
		List<Stock> row = stockServiceImpl.queryStockHaveQty();
		if (row == null || row.isEmpty()) {
			throw new BusinessException(ResultCodeEnum.TRAINPB0002.getCode(), ResultCodeEnum.TRAINPB0002.getMsg(),
					"");
		} else {
			log.info("所有有库存商品查询信息:{}", row.toString());
		}

		body.setRow(row);
		body.setNums(row.size());
		rspContext.getContext().setBody(body);
	}

	@Override
	public void valid(TransReqContext<ReqOR01Service> reqContext) {
		// TODO Auto-generated method stub
		System.out.println("valid:请完成你的业务逻辑校验");
	}

}
