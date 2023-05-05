import com.epam.tamentoring.bo.Product;
import com.epam.tamentoring.bo.ShoppingCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCartTest {

    @Test
    public void shouldIncreaseProductQuantityWhenAddSameProductToShoppingCart() {
        final ArrayList<Product> products = new ArrayList<>(List.of(new Product(1, "Pillow", 100.00, 1)));
        ShoppingCart shoppingCart = new ShoppingCart(products);

        products.forEach(shoppingCart::addProductToCart);

        Assertions.assertEquals(2.0, shoppingCart.getProducts().stream()
                .filter(p -> p.getId() == 1).findFirst().map(Product::getQuantity).get(), "Wrong products added to cart.");
    }

    @Test
    public void shouldAddAnotherProductToShoppingCart() {
        final List<Product> products = new ArrayList<>(List.of(new Product(1, "Pillow", 100.00, 1)));
        ShoppingCart shoppingCart = new ShoppingCart(products);
        final Product anotherProduct = new Product(2, "Blanket", 200.00, 1);

        shoppingCart.addProductToCart(anotherProduct);

        System.out.println(shoppingCart);

        Assertions.assertEquals(2, shoppingCart.getProducts().size(), "Wrong products added to cart.");
    }

    @Test
    public void shouldRemoveProductFromShoppingCart() {
        final List<Product> products = new ArrayList<>(List.of(new Product(1, "Pillow", 100.00, 1)));
        ShoppingCart shoppingCart = new ShoppingCart(products);

        shoppingCart.removeProductFromCart(products.get(0));

        Assertions.assertTrue(shoppingCart.getProducts().isEmpty(), "Product should be removed from shopping cart.");
    }


    @Test
    public void shoppingCartShouldHaveTotalPrice() {
        final List<Product> products = new ArrayList<>(List.of(new Product(1, "Pillow", 100.00, 1)));
        ShoppingCart shoppingCart = new ShoppingCart(products);

        Assertions.assertEquals(100.0, shoppingCart.getCartTotalPrice(), "Total price should be 100.0");
    }

    @Test
    public void shoppingCartShouldHaveTotalPriceForAllProducts() {
        final List<Product> products = new ArrayList<>(List.of(new Product(1, "Pillow", 100.00, 1)
                                                                , new Product(1, "Blanket", 200.00, 1)));

        ShoppingCart shoppingCart = new ShoppingCart(products);
        Assertions.assertEquals(300.0, shoppingCart.getCartTotalPrice(), "Total price should be 300.0");

    }
}
