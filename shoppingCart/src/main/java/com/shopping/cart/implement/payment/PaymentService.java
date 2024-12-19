package com.shopping.cart.implement.payment;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.shopping.cart.implement.order.OrderService;
import com.shopping.cart.interfaces.payment.PaymentInterfaces;
import com.shopping.cart.models.dto.payment.Payment;
import com.shopping.cart.utilidades.ErrorExceptionHandler;

@Service
public class PaymentService extends ErrorExceptionHandler implements PaymentInterfaces{



	@Override
	public ResponseEntity<Object> paymentCash(Payment pay) {
		try {
			ResponseEntity<Object> responseEntity = null;	
			double totalAmount=0.00;
			double totalDebt=0.00;
			for (int i = 0; i < OrderService.listCart.get(0).getProducts().size(); i++) {			
				totalAmount= totalAmount+OrderService.listCart.get(0).getProducts().get(i).getPrice();
			}
			logger.info("total amount to be paid {}",totalAmount);
			
			if(!OrderService.listCart.isEmpty()
					&& (pay.getUserId()==OrderService.listCart.get(0).getUserId()
					&& pay.getDate().trim().equals(OrderService.listCart.get(0).getDate().trim()))
					)
			{
				
					UUID uuid =UUID.randomUUID();
					LocalDateTime date = LocalDateTime.now();
					pay.setIdTransaction(uuid);
					double mountTemp = 0.00;
					totalDebt=totalAmount;
					totalAmount=pay.getMount();								
					for (int i = 0; i < OrderService.listCart.get(0).getProducts().size(); i++) {
						mountTemp = OrderService.listCart.get(0).getProducts().get(i).getPrice();					
						totalAmount=(totalAmount-mountTemp);
						if(totalAmount>0)
						{
							OrderService.listCart.get(0).getProducts().get(i).setPrice(0.00);					
						}else
						{
							
							if(totalAmount<0)
							{
								totalAmount=totalAmount*-1;	
							}
							OrderService.listCart.get(0).getProducts().get(i).setPrice(totalAmount);						
						}
					}	
					
					if(totalAmount>0)
					{	
						logger.info("Payment made on the day {} change {} total debt {}",date,totalAmount,totalDebt);
						pay.setComment("Payment made on the day "+date+" total debt canceled $"+totalDebt+" change $"+totalAmount);
					}else
					{								
						logger.info("the debt was paid");
						OrderService.listCart.clear();
						pay.setComment("Payment made on the day "+date+" paid in full total debt canceled "+totalDebt);
					}
					logger.info("completed successfully paymentCash");
					return responseEntity.ok(pay);						
			}
			logger.info("do not generate content paymentCash");
			return ResponseEntity.noContent().build();
		}  catch (Exception e) {
			logger.info("ERROR ON paymentCash {}",e);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("The service is unable to respond at the moment");
		}		
	}
}
