package com.tota.transport.dataaccess.dao.mysql;


import com.tota.transport.dataaccess.domain.DeliverBalanceDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 * @author jcduan
 * @date 2018年9月18日 上午10:06:32
 */
public interface DeliverBalanceMysqlDAO {

    /**
     *创建配送余额记录表
     * @param shopId  商铺id
     * @return
     */

    void createBalance(@Param("shopId")long shopId);


    /**
     *在商家配送余额中充值和扣费
     * @param amount  充值和扣费的金额
     * @param shopId  店铺id
     * @return
     */

    void  updateBalance(@Param("shopId")long shopId,@Param("amount") long  amount);


    /**
     *查询余额
     * @param shopId   店铺id
     * @return
     */

    long  queryBalance(@Param("shopId")long shopId);







}
