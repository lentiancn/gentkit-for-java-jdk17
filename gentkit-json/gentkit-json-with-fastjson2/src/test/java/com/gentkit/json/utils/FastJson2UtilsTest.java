package com.gentkit.json.utils;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class FastJson2UtilsTest {

    @Test
    public void testToBean() {
        String json = "{\"name\":\"John\", \"age\":30}";
        TestBean bean = FastJson2Utils.toBean(json, TestBean.class);
        assertNotNull(bean);
        assertEquals("John", bean.getName());
        assertEquals(30, bean.getAge());
    }

    @Test
    public void testToBeanWithNullJson() {
        TestBean bean = FastJson2Utils.toBean(null, TestBean.class);
        assertNull(bean);
    }

    @Test
    public void testToBeanWithEmptyJson() {
        TestBean bean = FastJson2Utils.toBean("", TestBean.class);
        assertNull(bean);
    }

    @Test
    public void testGetShortFromJsonObject() {
        JSONObject json = new JSONObject();
        json.put("value", (short) 10);
        short result = FastJson2Utils.getShort(json, "value", (short) 0);
        assertEquals(10, result);
    }

    @Test
    public void testGetIntFromJsonObject() {
        JSONObject json = new JSONObject();
        json.put("value", 42);
        int result = FastJson2Utils.getInt(json, "value", 0);
        assertEquals(42, result);
    }

    @Test
    public void testGetLongFromJsonObject() {
        JSONObject json = new JSONObject();
        json.put("value", 1234567890L);
        long result = FastJson2Utils.getLong(json, "value", 0L);
        assertEquals(1234567890L, result);
    }

    @Test
    public void testGetFloatFromJsonObject() {
        JSONObject json = new JSONObject();
        json.put("value", 3.14f);
        float result = FastJson2Utils.getFloat(json, "value", 0.0f);
        assertEquals(3.14f, result, 0.01f);
    }

    @Test
    public void testGetDoubleFromJsonObject() {
        JSONObject json = new JSONObject();
        json.put("value", 3.14159);
        double result = FastJson2Utils.getDouble(json, "value", 0.0);
        assertEquals(3.14159, result, 0.0001);
    }

    @Test
    public void testGetStringFromJsonObject() {
        JSONObject json = new JSONObject();
        json.put("value", "test");
        String result = FastJson2Utils.getString(json, "value", "default");
        assertEquals("test", result);
    }

    @Test
    public void testGetBooleanFromJsonObject() {
        JSONObject json = new JSONObject();
        json.put("value", true);
        boolean result = FastJson2Utils.getBoolean(json, "value", false);
        assertTrue(result);
    }

    @Test
    public void testGetJsonObjectFromJsonObject() {
        JSONObject json = new JSONObject();
        JSONObject inner = new JSONObject();
        inner.put("innerKey", "innerValue");
        json.put("inner", inner);
        
        JSONObject result = FastJson2Utils.getJsonObject(json, "inner", null);
        assertNotNull(result);
        assertEquals("innerValue", result.getString("innerKey"));
    }

    @Test
    public void testGetJsonArrayFromJsonObject() {
        JSONObject json = new JSONObject();
        JSONArray array = new JSONArray();
        array.add("item1");
        array.add("item2");
        json.put("array", array);
        
        JSONArray result = FastJson2Utils.getJsonArray(json, "array", null);
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("item1", result.getString(0));
        assertEquals("item2", result.getString(1));
    }

    @Test
    public void testGetShortFromJsonArray() {
        JSONArray json = new JSONArray();
        json.add((short) 5);
        short result = FastJson2Utils.getShort(json, 0, (short) 0);
        assertEquals(5, result);
    }

    @Test
    public void testGetIntFromJsonArray() {
        JSONArray json = new JSONArray();
        json.add(99);
        int result = FastJson2Utils.getInt(json, 0, 0);
        assertEquals(99, result);
    }

    @Test
    public void testGetLongFromJsonArray() {
        JSONArray json = new JSONArray();
        json.add(9876543210L);
        long result = FastJson2Utils.getLong(json, 0, 0L);
        assertEquals(9876543210L, result);
    }

    @Test
    public void testGetFloatFromJsonArray() {
        JSONArray json = new JSONArray();
        json.add(2.71f);
        float result = FastJson2Utils.getFloat(json, 0, 0.0f);
        assertEquals(2.71f, result, 0.01f);
    }

    @Test
    public void testGetDoubleFromJsonArray() {
        JSONArray json = new JSONArray();
        json.add(2.71828);
        double result = FastJson2Utils.getDouble(json, 0, 0.0);
        assertEquals(2.71828, result, 0.0001);
    }

    @Test
    public void testGetStringFromJsonArray() {
        JSONArray json = new JSONArray();
        json.add("test");
        String result = FastJson2Utils.getString(json, 0, "default");
        assertEquals("test", result);
    }

    @Test
    public void testGetBooleanFromJsonArray() {
        JSONArray json = new JSONArray();
        json.add(false);
        boolean result = FastJson2Utils.getBoolean(json, 0, true);
        assertFalse(result);
    }

    @Test
    public void testGetJsonObjectFromJsonArray() {
        JSONArray json = new JSONArray();
        JSONObject inner = new JSONObject();
        inner.put("key", "value");
        json.add(inner);
        
        JSONObject result = FastJson2Utils.getJsonObject(json, 0, null);
        assertNotNull(result);
        assertEquals("value", result.getString("key"));
    }

    @Test
    public void testGetJsonArrayFromJsonArray() {
        JSONArray json = new JSONArray();
        JSONArray inner = new JSONArray();
        inner.add("nestedItem");
        json.add(inner);
        
        JSONArray result = FastJson2Utils.getJsonArray(json, 0, null);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("nestedItem", result.getString(0));
    }

    // Test bean class for JSON deserialization
    public static class TestBean {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}