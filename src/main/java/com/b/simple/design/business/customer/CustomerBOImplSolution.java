package com.b.simple.design.business.customer;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;

import java.math.BigDecimal;
import java.util.List;

public class CustomerBOImplSolution implements CustomerBO{
    @Override
    public Amount getCustomerProductsSum(List<Product> products) throws DifferentCurrenciesException {

        if (products.size() == 0)
            return new AmountImpl(BigDecimal.ZERO, Currency.EURO);

        Currency firstProductCurrency = products.get(0).getAmount()
                .getCurrency();

        if(!doAllProductsHaveSameCurrency(products, firstProductCurrency)){
            throw new DifferentCurrenciesException();
        }

        return calculateSumOfProduct(products, firstProductCurrency);
    }

    private boolean doAllProductsHaveSameCurrency(List<Product> products, Currency firstProductCurrency) {
        boolean currencySameAsFirstProduct = products.stream()
                .map(product -> product.getAmount().getCurrency())
                .allMatch(currency -> currency.equals(firstProductCurrency));

        return currencySameAsFirstProduct;
    }

    private AmountImpl calculateSumOfProduct(List<Product> products, Currency firstProductCurrency) {
        BigDecimal sum = products.stream()
                .map(product -> product.getAmount().getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new AmountImpl(sum, firstProductCurrency);
    }
}
