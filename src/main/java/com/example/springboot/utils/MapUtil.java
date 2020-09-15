package com.example.springboot.utils;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

@Component
public class MapUtil {

	/**
	 * Object to map
	 *
	 * @param object object
	 * @return map
	 * @throws IllegalAccessException exception
	 */
	public static Map<Object, Object> object2Map(Object object) throws IllegalAccessException {
		Map<Object, Object> map = new HashMap<>();
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(object));
		}
		return map;
	}

	/**
	 * map to object
	 *
	 * @param map   map
	 * @param clazz class
	 * @return object
	 * @throws Exception exception
	 */
	public static Object map2Object(Map<Object, Object> map, Class<?> clazz) throws Exception {
		if (map.isEmpty()) return null;
		Object object = clazz.newInstance();//该类必须有无参构造方法
		Field[] fieldArray = object.getClass().getDeclaredFields();//获取该类下申明的字段
		for (Field field : fieldArray) {
			int modifier = field.getModifiers();//获取字段修饰符
			if (Modifier.isStatic(modifier) || Modifier.isFinal(modifier)) {//如果修饰符是static 或者final则跳过
				continue;
			}
			field.setAccessible(true);//设置可访问
			if (map.containsKey(field.getName())) {
				field.set(object, map.get(field.getName()));
			}
		}
		return object;
	}
}
