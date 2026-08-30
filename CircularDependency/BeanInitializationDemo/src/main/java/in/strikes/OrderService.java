package in.strikes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {


    PaymentService paymentService;
//proxy object injected
    public OrderService( @Lazy PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.pay();

        System.out.println("Order placed");
    }

    public void getOrderDetails() {
        System.out.println("Order Details");
    }
}
