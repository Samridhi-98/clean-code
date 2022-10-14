package com.a.introduction.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseSolutionTest {

    private final int SELL_IN = 15;
    private final int QUALITY = 5;
    private final String DEFAULT_ITEM = "DEFAULT_ITEM";

    @Test
    public void shouldDecreaseQualityByOneForNonExpiredItem(){
        Item item = new Item(DEFAULT_ITEM, SELL_IN, QUALITY);
        Item[] items = new Item[] { item };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertEquals(DEFAULT_ITEM, app.items[0].name);
        assertEquals(SELL_IN - 1, app.items[0].sellIn);
        assertEquals(QUALITY - 1, app.items[0].quality);
    }
}
