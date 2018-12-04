package com.tota.transport.rpc.service;

import com.tota.transport.dataaccess.dao.mysql.DeliverBalanceMysqlDAO;
import com.tota.transport.dataaccess.domain.DeliverBalanceDO;
import com.tota.transport.rpc.api.domain.ResponseResult;
import com.tota.transport.rpc.api.domain.response.BalanceQueryResp;
import com.tota.transport.rpc.api.service.DeliveryBalanceRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryBalanceRpcServiceImpl implements DeliveryBalanceRpcService {

    @Autowired
    private DeliverBalanceMysqlDAO deliverBalanceMysqlDAO;



    @Override
    public ResponseResult balanceRecharge(long shopId,long amount) {

       deliverBalanceMysqlDAO.updateBalance(shopId,amount);

        ResponseResult rr=new ResponseResult();

            rr.setStatus("success");
            rr.setMsg("充值成功");
            rr.setCode(0);



        return  rr;
    }

    @Override
    public ResponseResult<BalanceQueryResp> balanceQuery(long shopId) {

        long balance=deliverBalanceMysqlDAO.queryBalance(shopId);

        System.out.println("sffffffffffff   "+balance);

        ResponseResult rr=new ResponseResult();

        if(balance>0){
            rr.setStatus("success");
            rr.setMsg("成功");
            rr.setCode(0);

            BalanceQueryResp  balanceQueryResp=new BalanceQueryResp();
            balanceQueryResp.setAmount(balance);

            rr.setResult(balanceQueryResp);
        }else{
            rr.setStatus("fail");
            rr.setMsg("失败");
            rr.setCode(1);
        }

        return rr;
    }

//
//    public static void main(String[] args) {
//        DeliveryBalanceRpcServiceImpl db=new DeliveryBalanceRpcServiceImpl();
//        db.balanceRecharge(5464646,1000);
//    }
}
