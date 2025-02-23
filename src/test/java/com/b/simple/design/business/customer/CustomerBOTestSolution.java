package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CustomerBOTestSolution {

    private CustomerBO customerBO = new CustomerBOImpl();
    private CustomerBO customerBOImplSolution = new CustomerBOImplSolution();

    @Test
    public void testCustomerProductSum_TwoProductsSameCurrencies() throws DifferentCurrenciesException {

        Amount[] amounts = {new AmountImpl(new BigDecimal("5.0"), Currency.EURO), new AmountImpl(new BigDecimal("6.0"), Currency.EURO)};

        List<Product> products = createProductWithAmount(amounts);

        Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);
        Amount actual = customerBO.getCustomerProductsSum(products);

        assertAmount(expected, actual);
    }

    @Test
    public void testCustomerProductSum_TwoProductsDifferentCurrencies() throws DifferentCurrenciesException {

        Amount[] amounts = {new AmountImpl(new BigDecimal("5.0"), Currency.EURO), new AmountImpl(new BigDecimal("6.0"), Currency.INDIAN_RUPEE)};

        List<Product> products = createProductWithAmount(amounts);

        assertThrows(DifferentCurrenciesException.class,() -> customerBO.getCustomerProductsSum(products));
    }

    @Test
    public void testCustomerProductSum_ForEmptyProductList() throws DifferentCurrenciesException {

        List<Product> products = new ArrayList<Product>();

        Amount actual = customerBO.getCustomerProductsSum(products);;
        Amount expected = new AmountImpl(BigDecimal.ZERO, Currency.EURO);

        assertAmount(expected,actual);
    }

    private void assertAmount(Amount expected, Amount actual) {
        assertEquals(expected.getCurrency(), actual.getCurrency());
        assertEquals(expected.getValue(), actual.getValue());
    }

    private List<Product> createProductWithAmount(Amount[] amounts) {
        return Arrays.stream(amounts)
                .map(amount ->
                        new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE,
                                amount))
                .collect(Collectors.toList());
    }

}
