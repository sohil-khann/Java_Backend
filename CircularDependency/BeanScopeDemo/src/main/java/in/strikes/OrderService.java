package in.strikes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")// lazy initialization
//@Scope("singleton")  // eager initialization
public class OrderService {

    public OrderService() {
        System.out.println("OrderService created");
    }

//    public void placeOrder() {
//        System.out.println("Order placed");
//    }
}
