import com.epam.tamentoring.bo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrderService orderService;

    @Mock
    DiscountUtility discountUtility;

    /*Verify that for a user named John Smith whose date of birth is "1990/10/10",
            the amount of the provided discount is equal to 3.*/

    /*Verify that the mocked object is called only once.*/

    /*Verify that there are no other interactions with the mocked object.*/
    @Test
    public void shouldProvideDiscountForSpecificUser() {
        List<Product> products = new ArrayList<>(List.of(new Product(1, "Pillow", 100.00, 1)));
        final ShoppingCart shoppingCart = new ShoppingCart(products);
        final UserAccount userJohn = new UserAccount("John", " Smith", "1990/10/10", shoppingCart);

        Mockito.when(discountUtility.calculateDiscount(userJohn)).thenReturn(3.0);


        Assertions.assertEquals(3.0, orderService.getDiscountUtility().calculateDiscount(userJohn), "Discount should be 3.0");
        Mockito.calls(1);

        Mockito.verify(discountUtility).calculateDiscount(userJohn);
        Mockito.verifyNoMoreInteractions(discountUtility);
    }


}
