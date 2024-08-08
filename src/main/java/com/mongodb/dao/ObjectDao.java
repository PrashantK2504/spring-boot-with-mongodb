package com.mongodb.dao;

import java.io.Serializable;

public interface ObjectDao {

	void saveObject(Object entity) throws Exception;

	void deleteObject(Object entity);

	void updateObject(Object entity);

	<T> T getObjectById(Class<T> entity, Serializable id);

	<T> T getObjectByParam(Class<T> entity, String param, Object paramValue);

	<T> T listObject(Class<T> entity, String id);

	<T> T listObjectByParam(Class<T> entity, String param, String orderBy, Object obj);

	<T> T listObjectByParamAsc(Class<T> entity, String param, String orderBy, Object obj);

	<T> T listObjectByParamDesc(Class<T> entity, String param, String orderBy, Object obj);

	Long listCount(Class<?> entity);

	Long listObjectByParamCount(Class<?> entity, String param, Object obj);

	<T> T getObjectByMultipleParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2);

	<T> T getObjectByThreeParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3,
			Object obj3);

	<T> T getObjectByFourParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3,
			Object obj3, String param4, Object obj4);

	void deleteByParam(String collection, String param, String value);

//	Long idByNo(String collection, String columnToCompare, String compareValue, String columnToGet);

	<T> T listObjectByMultipleParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2,
			String orderBy);

	<T> T listObjectByThreeParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3,
			Object obj3, String orderBy);

	<T> T listObjectByFourParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3,
			Object obj3, String param4, Object obj4, String orderBy);

	<T> T listObjectByMultipleParamAsc(Class<T> entity, String param1, Object obj1, String param2, Object obj2,
			String orderBy);

	<T> String getColumnByParam(Class<T> entity, String param);
}
