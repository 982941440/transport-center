package com.tota.transport.dataaccess.dao.mysql;


import com.tota.se.dataaccess.mysql.BaseMysqlDAO;
import com.tota.transport.dataaccess.domain.OrderDeliverDO;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author jcduan
 * @date 2018年9月18日 上午10:06:32
 */
public interface OrderDeliverMysqlDAO extends BaseMysqlDAO<OrderDeliverDO> {

           OrderDeliverDO findById(long id);



}
