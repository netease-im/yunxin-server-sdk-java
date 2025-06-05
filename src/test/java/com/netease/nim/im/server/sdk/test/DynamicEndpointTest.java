package com.netease.nim.im.server.sdk.test;

import com.netease.nim.server.sdk.core.endpoint.DynamicEndpointSelector;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by caojiajun on 2024/12/10
 */
public class DynamicEndpointTest {

    @Test
    public void test1() {
        String endpoint1 = "a";
        String endpoint2 = "b";
        String endpoint3 = "c";
        String endpoint4 = "d";
        String endpoint5 = "e";
        DynamicEndpointSelector.Entry entry1 = new DynamicEndpointSelector.Entry(endpoint1, 1.0, 60.0, true);
        DynamicEndpointSelector.Entry entry2 = new DynamicEndpointSelector.Entry(endpoint2, 1.0, 60.0, false);
        DynamicEndpointSelector.Entry entry3 = new DynamicEndpointSelector.Entry(endpoint3, 1.0, 60.0, false);
        DynamicEndpointSelector.Entry entry4 = new DynamicEndpointSelector.Entry(endpoint4, 1.0, 60.0, false);
        DynamicEndpointSelector.Entry entry5 = new DynamicEndpointSelector.Entry(endpoint5, 1.0, 60.0, false);

        List<DynamicEndpointSelector.Entry> list = new ArrayList<>();
        list.add(entry3);
        list.add(entry1);
        list.add(entry2);
        list.add(entry5);
        list.add(entry4);
        Collections.shuffle(list);

        Collections.sort(list);

        Assert.assertEquals(endpoint1, list.get(0).endpoint);
    }

    @Test
    public void test2() {
        String endpoint1 = "a";
        String endpoint2 = "b";
        String endpoint3 = "c";
        String endpoint4 = "d";
        String endpoint5 = "e";
        DynamicEndpointSelector.Entry entry1 = new DynamicEndpointSelector.Entry(endpoint1, 1.0, 60.0, true);
        DynamicEndpointSelector.Entry entry2 = new DynamicEndpointSelector.Entry(endpoint2, 1.0, 70.0, false);
        DynamicEndpointSelector.Entry entry3 = new DynamicEndpointSelector.Entry(endpoint3, 1.0, 80.0, false);
        DynamicEndpointSelector.Entry entry4 = new DynamicEndpointSelector.Entry(endpoint4, 1.0, 90.0, false);
        DynamicEndpointSelector.Entry entry5 = new DynamicEndpointSelector.Entry(endpoint5, 1.0, 50.0, false);

        List<DynamicEndpointSelector.Entry> list = new ArrayList<>();
        list.add(entry3);
        list.add(entry1);
        list.add(entry2);
        list.add(entry5);
        list.add(entry4);
        Collections.shuffle(list);

        Collections.sort(list);

        Assert.assertEquals(endpoint5, list.get(0).endpoint);
    }

    @Test
    public void test3() {
        String endpoint1 = "a";
        String endpoint2 = "b";
        String endpoint3 = "c";
        String endpoint4 = "d";
        String endpoint5 = "e";
        DynamicEndpointSelector.Entry entry1 = new DynamicEndpointSelector.Entry(endpoint1, 1.0, 60.0, true);
        DynamicEndpointSelector.Entry entry2 = new DynamicEndpointSelector.Entry(endpoint2, 0.99, 70.0, false);
        DynamicEndpointSelector.Entry entry3 = new DynamicEndpointSelector.Entry(endpoint3, 0.999, 80.0, false);
        DynamicEndpointSelector.Entry entry4 = new DynamicEndpointSelector.Entry(endpoint4, 0.8, 90.0, false);
        DynamicEndpointSelector.Entry entry5 = new DynamicEndpointSelector.Entry(endpoint5, 0.7, 50.0, false);

        List<DynamicEndpointSelector.Entry> list = new ArrayList<>();
        list.add(entry3);
        list.add(entry1);
        list.add(entry2);
        list.add(entry5);
        list.add(entry4);
        Collections.shuffle(list);

        Collections.sort(list);

        Assert.assertEquals(endpoint1, list.get(0).endpoint);
    }

    @Test
    public void test4() {
        String endpoint1 = "a";
        String endpoint2 = "b";
        String endpoint3 = "c";
        String endpoint4 = "d";
        String endpoint5 = "e";
        DynamicEndpointSelector.Entry entry1 = new DynamicEndpointSelector.Entry(endpoint1, 0.999, 60.0, true);
        DynamicEndpointSelector.Entry entry2 = new DynamicEndpointSelector.Entry(endpoint2, 0.99, 70.0, false);
        DynamicEndpointSelector.Entry entry3 = new DynamicEndpointSelector.Entry(endpoint3, 0.999, 80.0, false);
        DynamicEndpointSelector.Entry entry4 = new DynamicEndpointSelector.Entry(endpoint4, 1.0, 90.0, false);
        DynamicEndpointSelector.Entry entry5 = new DynamicEndpointSelector.Entry(endpoint5, 0.7, 50.0, false);

        List<DynamicEndpointSelector.Entry> list = new ArrayList<>();
        list.add(entry3);
        list.add(entry1);
        list.add(entry2);
        list.add(entry5);
        list.add(entry4);
        Collections.shuffle(list);

        Collections.sort(list);

        Assert.assertEquals(endpoint4, list.get(0).endpoint);
    }

    @Test
    public void test5() {
        String endpoint1 = "a";
        String endpoint2 = "b";
        String endpoint3 = "c";
        String endpoint4 = "d";
        String endpoint5 = "e";
        DynamicEndpointSelector.Entry entry1 = new DynamicEndpointSelector.Entry(endpoint1, 0.999, 60.0, true);
        DynamicEndpointSelector.Entry entry2 = new DynamicEndpointSelector.Entry(endpoint2, 0.9999, 30.0, false);
        DynamicEndpointSelector.Entry entry3 = new DynamicEndpointSelector.Entry(endpoint3, 0.999, 80.0, false);
        DynamicEndpointSelector.Entry entry4 = new DynamicEndpointSelector.Entry(endpoint4, 0.8, 90.0, false);
        DynamicEndpointSelector.Entry entry5 = new DynamicEndpointSelector.Entry(endpoint5, 0.7, 50.0, false);

        List<DynamicEndpointSelector.Entry> list = new ArrayList<>();
        list.add(entry3);
        list.add(entry1);
        list.add(entry2);
        list.add(entry5);
        list.add(entry4);
        Collections.shuffle(list);

        Collections.sort(list);

        Assert.assertEquals(endpoint2, list.get(0).endpoint);
    }

    @Test
    public void test6() {
        String endpoint1 = "a";
        String endpoint2 = "b";
        String endpoint3 = "c";
        String endpoint4 = "d";
        String endpoint5 = "e";
        DynamicEndpointSelector.Entry entry1 = new DynamicEndpointSelector.Entry(endpoint1, 0.9999, 60.0, true);
        DynamicEndpointSelector.Entry entry2 = new DynamicEndpointSelector.Entry(endpoint2, 0.9999, 30.0, false);
        DynamicEndpointSelector.Entry entry3 = new DynamicEndpointSelector.Entry(endpoint3, 0.9999, 80.0, false);
        DynamicEndpointSelector.Entry entry4 = new DynamicEndpointSelector.Entry(endpoint4, 0.9999, 90.0, false);
        DynamicEndpointSelector.Entry entry5 = new DynamicEndpointSelector.Entry(endpoint5, 0.9999, 50.0, false);

        List<DynamicEndpointSelector.Entry> list = new ArrayList<>();
        list.add(entry3);
        list.add(entry1);
        list.add(entry2);
        list.add(entry5);
        list.add(entry4);
        Collections.shuffle(list);

        Collections.sort(list);

        Assert.assertEquals(endpoint2, list.get(0).endpoint);
    }


    @Test
    public void test7() {
        String endpoint1 = "a";
        String endpoint2 = "b";
        String endpoint3 = "c";
        String endpoint4 = "d";
        String endpoint5 = "e";
        DynamicEndpointSelector.Entry entry1 = new DynamicEndpointSelector.Entry(endpoint1, 0.8, 60.0, true);
        DynamicEndpointSelector.Entry entry2 = new DynamicEndpointSelector.Entry(endpoint2, 0.6, 30.0, false);
        DynamicEndpointSelector.Entry entry3 = new DynamicEndpointSelector.Entry(endpoint3, 0.8, 80.0, false);
        DynamicEndpointSelector.Entry entry4 = new DynamicEndpointSelector.Entry(endpoint4, 0.7, 90.0, false);
        DynamicEndpointSelector.Entry entry5 = new DynamicEndpointSelector.Entry(endpoint5, 0.6, 50.0, false);

        List<DynamicEndpointSelector.Entry> list = new ArrayList<>();
        list.add(entry3);
        list.add(entry1);
        list.add(entry2);
        list.add(entry5);
        list.add(entry4);
        Collections.shuffle(list);

        Collections.sort(list);

        Assert.assertEquals(endpoint1, list.get(0).endpoint);
    }

}
