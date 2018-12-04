import com.tota.transport.dataaccess.dao.mysql.DeliverBalanceMysqlDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {

    @Autowired
    private DeliverBalanceMysqlDAO deliverBalanceMysqlDAO;




//   ApplicationContext ac = new FileSystemXmlApplicationContext("spring-config.xml");
//          ac.getBean("DeliverBalanceMysqlDAO");



    public static void main(String[] args) {
//        DeliveryBalanceRpcServiceImpl db=new DeliveryBalanceRpcServiceImpl();
//        db.balanceRecharge(5464646,1000);


           ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\win 10\\Desktop\\web\\transport-center\\transport-rpc\\src\\main\\resources\\spring-config.xml");
        DeliverBalanceMysqlDAO deliverBalanceMysqlDAO= (DeliverBalanceMysqlDAO)ac.getBean("deliverBalanceMysqlDAO");

      long balance=  deliverBalanceMysqlDAO.queryBalance(454545);
        System.out.println("ssssssssssssssssssss   "+balance);
    }

}
