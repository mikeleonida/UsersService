package com.eventdriven.estore.UsersService.query;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.estore.core.model.PaymentDetails;
import com.appsdeveloperblog.estore.core.model.User;
import com.appsdeveloperblog.estore.core.query.FetchUserPaymentDetailsQuery;

@Component
public class UserEventsHandler {

	@QueryHandler
	public User findUserPaymentDetails(FetchUserPaymentDetailsQuery query) {
		PaymentDetails paymentDetails = PaymentDetails.builder()
				.cardNumber("1234567890")
				.cvv("987")
				.name("Jennifer Grayson")
				.validUntilMonth(12)
				.validUntilYear(2027).build();

		User userRest = User.builder()
				.firstName("Jennifer")
				.lastName("Grayson")
				.userId(query.getUserId())
				.paymentDetails(paymentDetails).build();
		
		return userRest;
	}

}
