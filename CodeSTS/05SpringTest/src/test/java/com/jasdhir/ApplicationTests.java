package com.jasdhir;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jasdhir.app.ShoppingCart;

@SpringBootTest
class ApplicationTests {

	 @Autowired // field injection
	    private ShoppingCart shoppingCart;
	    @Test
	    public void testCheckout() {
	        shoppingCart.addItem("Item1", 3);
	        shoppingCart.addItem("item2", 5);
	        String result = shoppingCart.checkout();
	        Assertions.assertEquals("3 orders placed", result);
	    }

}
