package tests.automationpractice;

import pom.automationpractice.fragments.*;
import pom.automationpractice.pages.MainPage;
import pom.automationpractice.utils.UserActionUtils;
import tests.BaseTest;
import utils.basketUtils.BasketUtils;
import utils.basketUtils.pojo.Basket;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class TechTasks extends BaseTest {
    private static final int INDEX = 0;

    private MainPage mainPage;
    private HeaderFragment headerFragment;
    private UserActionUtils userActionUtils;
    private ProductListFragment productListFragment;
    private CartPopupFragment cartPopupFragment;
    private BasketFragment basketFragment;
    private BuyProductBlockFragment buyProductBlockFragment;

    private List<Basket> baskets;
    private int usedBasketId;

    private final Random rand = new Random();

    @BeforeMethod
    public void setUpClass() {
        mainPage = new MainPage();
        headerFragment = new HeaderFragment();
        userActionUtils = new UserActionUtils();
        productListFragment = new ProductListFragment();
        cartPopupFragment = new CartPopupFragment();
        basketFragment = new BasketFragment();
        buyProductBlockFragment = new BuyProductBlockFragment();

        baskets = BasketUtils.getBaskets();
    }

    @Test
    public void registerNewUser() {
        String timestamp = String.valueOf(System.currentTimeMillis());

        userActionUtils.signUpNewUserWithoutLogout(timestamp);

        assertThat(headerFragment.isSignOutButtonVisible()).isTrue();
    }

    @Test
    public void checkoutByRandomBasket() {
        String timestamp = String.valueOf(System.currentTimeMillis());

        userActionUtils.signUpNewUserWithoutLogout(timestamp);
        Basket basket = getRandomBasketIndex(baskets.size());

        basket.getItems().forEach(product -> {
            headerFragment.doSearch(product.name);
            productListFragment.getProductFromListFragment(product.name).clickAddToCartProduct();
            cartPopupFragment.clickContinueShoppingButton();
        });

        headerFragment.clickToOpenCart();
        basketFragment.clickProceedToCheckoutButton();
        basketFragment.clickProceedToCheckoutOnAddressButton();
        basketFragment.tipTermsOfServiceCheckbox();
        basketFragment.clickProceedToCheckoutOnShippingButton();
        basketFragment.clickPayByCheckButton();
        basketFragment.clickIConfirmMyOrderButton();

        assertThat(basketFragment.isSuccessAllertVisible()).isTrue();

    }

    @Test(dependsOnMethods = {"checkoutByRandomBasket"})
    public void checkoutByLeftBasket() {
        String timestamp = String.valueOf(System.currentTimeMillis());

        Basket freeBasket = baskets.get(INDEX);
        for (Basket basket : baskets) {
            if (!basket.id.equals(usedBasketId)) {
                freeBasket = basket;
            }
        }

        userActionUtils.signUpNewUserWithoutLogout(timestamp);

        mainPage.visit(freeBasket.items.get(0).path);

        freeBasket.getItems().forEach(product -> {
            mainPage.visit(product.path);
            buyProductBlockFragment.clickAddToCartButton();
            cartPopupFragment.clickContinueShoppingButton();
        });

        headerFragment.clickToOpenCart();
        basketFragment.clickProceedToCheckoutButton();
        basketFragment.clickProceedToCheckoutOnAddressButton();
        basketFragment.tipTermsOfServiceCheckbox();
        basketFragment.clickProceedToCheckoutOnShippingButton();
        basketFragment.clickPayByCheckButton();
        basketFragment.clickIConfirmMyOrderButton();

        assertThat(basketFragment.isSuccessAllertVisible()).isTrue();

        new MainPage().visit();

    }

    private Basket getRandomBasketIndex(int basketSize) {
        int randomElement = rand.nextInt(basketSize);
        usedBasketId = baskets.get(randomElement).getId();
        return baskets.get(randomElement);
    }

    @AfterMethod
    public void signOut() {
        if (headerFragment.isSignOutButtonVisible()) {
            headerFragment.clickSignOutButton();
        }
    }


}
