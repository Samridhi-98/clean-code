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
        Item item = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN, QUALITY);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(DEFAULT_ITEM, app.items[0].name);
        assertEquals(NOT_EXPIRED_SELL_IN - 1, app.items[0].sellIn);
        assertEquals(QUALITY - 1, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseQualityByTwoForExpiredItem(){
        Item item = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN, QUALITY);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(DEFAULT_ITEM, app.items[0].name);
        assertEquals(EXPIRED_SELL_IN - 1, app.items[0].sellIn);
        assertEquals(QUALITY - 2, app.items[0].quality);
    }
}
