package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test public void
    should_have_right_item_name_when_created_by_the_constructor() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test public void
    should_decrease_quality_by_1_for_normal_item_quality_positive() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }

    @Test public void
    should_decrease_sellin_by_1_for_nonSulfur_items() {
        Item[] items = new Item[] { new Item("foo", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }

    @Test public void
    should_increase_quality_by_1_for_AgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 30, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
    }

    @Test public void
    should_increase_quality_by_2_after_sell_date_for_AgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test public void
    should_not_increase_quality_if_greater_equal_than_50_for_AgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", 30, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test public void
    should_not_increase_quality_if_greater_equal_than_50_after_sell_date_for_AgedBrie() {
        Item[] items = new Item[] { new Item("Aged Brie", -2, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test public void
    should_increase_quality_by_1_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 30, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(41, app.items[0].quality);
    }

    @Test public void
    should_increase_quality_by_2_when_sellin_less_than_11_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(42, app.items[0].quality);
    }

    @Test public void
    should_increase_quality_by_3_when_sellin_less_than_6_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(43, app.items[0].quality);
    }

    @Test public void
    should_not_increase_quality_greater_equal_50_when_sellin_less_than_11_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test public void
    should_not_increase_quality_greater_equal_50_when_sellin_less_than_6_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 48) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test public void
    should_not_increase_quality_if_greater_equal_than_50_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 30, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test public void
    should_not_change_sellin_nor_quality_for_Sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 30, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(30, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test public void
    should_decrease_quality_by_2_after_sell_date_for_normal_item_quality_positive() {
        Item[] items = new Item[] { new Item("foo", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }

    @Test public void
    should_not_decrease_quality_0_if_after_sell_date_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test public void
    should_not_decrease_quality_if_after_sell_date_for_Backstage_for_Sulfuras() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test public void
    should_decrease_quality_to_0_if_after_sell_date_for_Backstage() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}
