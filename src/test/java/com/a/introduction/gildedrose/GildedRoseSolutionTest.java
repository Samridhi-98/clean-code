package com.a.introduction.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseSolutionTest {

    private int NOT_EXPIRED_SELL_IN = 15;
    private int EXPIRED_SELL_IN = -1;
    private int DEFAULT_QUALITY = 3;
    private int MAX_QUALITY = 50;
    private final String DEFAULT_ITEM = "DEFAULT_ITEM";
    private final String AGED_BRIE = "Aged Brie";

    @Test
    public void shouldDecreaseQualityByOneForNonExpiredItem(){
        GildedRose app = createGildedRoseWithDefaultItem(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN,DEFAULT_QUALITY);

        app.updateQuality();

        Item expected = new Item(DEFAULT_ITEM, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 1);

        assertItem(expected, app.items[0]);
    }

    @Test
    public void shouldDecreaseQualityByTwoForExpiredItem(){
        GildedRose app = createGildedRoseWithDefaultItem(DEFAULT_ITEM, EXPIRED_SELL_IN, DEFAULT_QUALITY);

        app.updateQuality();

        Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY - 2);

        assertItem(expected, app.items[0]);
    }

    @Test
    public void shouldIncreaseQualityByOneForAgedBrie(){
        GildedRose app = createGildedRoseWithDefaultItem(AGED_BRIE, NOT_EXPIRED_SELL_IN, DEFAULT_QUALITY);

        app.updateQuality();

        Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 1);

        assertItem(expected, app.items[0]);
    }

    @Test
    public void shouldIncreaseQualityByTwoForAgedBrie(){
        GildedRose app = createGildedRoseWithDefaultItem(AGED_BRIE, EXPIRED_SELL_IN, DEFAULT_QUALITY);

        app.updateQuality();

        Item expected = new Item(AGED_BRIE, EXPIRED_SELL_IN - 1, DEFAULT_QUALITY + 2);

        assertItem(expected, app.items[0]);
    }

    @Test
    public void shouldNotIncreaseQualityAfterMaxValue(){
        GildedRose app = createGildedRoseWithDefaultItem(AGED_BRIE, NOT_EXPIRED_SELL_IN, MAX_QUALITY);

        app.updateQuality();

        Item expected = new Item(AGED_BRIE, NOT_EXPIRED_SELL_IN - 1, MAX_QUALITY);

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
