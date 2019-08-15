package com.spdb.training.socket.trans.or02.service;

import com.spdb.training.socket.trans.anno.TransCodeAnno;
import com.spdb.training.socket.trans.entity.TransReqContext;
import com.spdb.training.socket.trans.entity.TransRspContext;
import com.spdb.training.socket.trans.or02.ReqOR02Service;
import com.spdb.training.socket.trans.or02.RspOR02Service;
import com.spdb.training.socket.trans.or02.RspOR02ServiceBody;
import com.spdb.training.socket.trans.service.AbsAtomicTransService;

/** 
* @author 作者: 王腾蛟
* @version time：2029年6月18日 下午4:20:13 
*   类说明: 测试用的交易OR02
*/
@TransCodeAnno("OR02")
public class TransOR02Service extends AbsAtomicTransService<ReqOR02Service, RspOR02Service> {

	@Override
	public void process(TransReqContext<ReqOR02Service> reqContext, TransRspContext<RspOR02Service> rspContext) {
		//报文编写方式2，根据具体业务获取写入
		ReqOR02Service context = reqContext.getContext();
		//获取body context.getBody()
		
		
		RspOR02ServiceBody body = new RspOR02ServiceBody();
		//body.setNameId(nameId);
		
		rspContext.getContext().setBody(body);
	}

	@Override
	public void valid(TransReqContext<ReqOR02Service> reqContext) {
		System.out.println("valid:请完成你的业务逻辑校验");
	}

}
