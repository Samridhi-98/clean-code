package com.a.introduction.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseSolutionTest {

    private int NOT_EXPIRED_SELL_IN = 15;
    private int EXPIRED_SELL_IN = -1;
    private int QUALITY = 3;
    private final String DEFAULT_ITEM = "DEFAULT_ITEM";

    @Test
    public void shouldDecreaseQualityByOneForNonExpiredItem(){
        GildedRose app = createGildedRoseWithDefaultItem(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN,QUALITY);

        app.updateQuality();

        Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN - 1, QUALITY - 1);

        assertItem(expected, app.items[0]);
    }

    @Test
    public void shouldDecreaseQualityByTwoForExpiredItem(){
        GildedRose app = createGildedRoseWithDefaultItem(DEFAULT_ITEM, EXPIRED_SELL_IN, QUALITY);

        app.updateQuality();

        Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, QUALITY - 2);

        assertItem(expected, app.items[0]);
    }

    private GildedRose createGildedRoseWithDefaultItem(String itemName, int sell_in, int quality){
        Item item = new Item(itemName, sell_in,quality);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);
        return app;
    }

    private void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }
}
