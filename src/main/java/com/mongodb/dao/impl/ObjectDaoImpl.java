package com.mongodb.dao.impl;

import com.mongodb.dao.ObjectDao;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("objectDao")
public class ObjectDaoImpl implements ObjectDao{

	

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveObject(Object entity) throws Exception {
        mongoTemplate.save(entity);
    }

    @Override
    public void deleteObject(Object entity) {
        mongoTemplate.remove(entity);
    }

    @Override
    public void updateObject(Object entity) {
        mongoTemplate.save(entity);
    }

    @Override
    public <T> T getObjectById(Class<T> entity, Serializable id) {
        return mongoTemplate.findById(id, entity);
    }

    @Override
    public <T> T getObjectByParam(Class<T> entity, String param, Object paramValue) {
        Query query = new Query(Criteria.where(param).is(paramValue));
        return mongoTemplate.findOne(query, entity);
    }

    @Override
    public <T> T listObject(Class<T> entity, String id) {
        Query query = new Query().with(Sort.by(Sort.Direction.DESC, id));
        return (T) mongoTemplate.find(query, entity);
    }

    @Override
    public <T> T listObjectByParam(Class<T> entity, String param, String orderBy, Object obj) {
        Query query = new Query(Criteria.where(param).is(obj)).with(Sort.by(Sort.Direction.DESC, orderBy));
        return (T) mongoTemplate.find(query, entity);
    }

    @Override
    public <T> T listObjectByParamAsc(Class<T> entity, String param, String orderBy, Object obj) {
        Query query = new Query(Criteria.where(param).is(obj)).with(Sort.by(Sort.Direction.ASC, orderBy));
        return (T) mongoTemplate.find(query, entity);
    }

    @Override
    public <T> T listObjectByParamDesc(Class<T> entity, String param, String orderBy, Object obj) {
        Query query = new Query(Criteria.where(param).is(obj)).with(Sort.by(Sort.Direction.DESC, orderBy));
        return (T) mongoTemplate.find(query, entity);
    }

    @Override
    public Long listCount(Class<?> entity) {
        Query query = new Query();
        return mongoTemplate.count(query, entity);
    }

    @Override
    public Long listObjectByParamCount(Class<?> entity, String param, Object obj) {
        Query query = new Query(Criteria.where(param).is(obj));
        return mongoTemplate.count(query, entity);
    }

    @Override
    public <T> T getObjectByMultipleParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2) {
        Query query = new Query(Criteria.where(param1).is(obj1).and(param2).is(obj2));
        return mongoTemplate.findOne(query, entity);
    }

    @Override
    public <T> T getObjectByThreeParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3, Object obj3) {
        Query query = new Query(Criteria.where(param1).is(obj1).and(param2).is(obj2).and(param3).is(obj3));
        return mongoTemplate.findOne(query, entity);
    }

    @Override
    public <T> T getObjectByFourParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3, Object obj3, String param4, Object obj4) {
        Query query = new Query(Criteria.where(param1).is(obj1).and(param2).is(obj2).and(param3).is(obj3).and(param4).is(obj4));
        return mongoTemplate.findOne(query, entity);
    }

    @Override
    public void deleteByParam(String collection, String param, String value) {
        Query query = new Query(Criteria.where(param).is(value));
        mongoTemplate.remove(query, collection);
    }

//    @Override
//    public Long idByNo(String collection, String columnToCompare, String compareValue, String columnToGet) {
//        Query query = new Query(Criteria.where(columnToCompare).is(compareValue));
//        query.fields().include(columnToGet);
//        Map<String, Object> result = mongoTemplate.findOne(query, Map.class, collection);
//        return result != null ? (Long) result.get(columnToGet) : null;
//    }

    @Override
    public <T> T listObjectByMultipleParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String orderBy) {
        Query query = new Query(Criteria.where(param1).is(obj1).and(param2).is(obj2)).with(Sort.by(Sort.Direction.DESC, orderBy));
        return (T) mongoTemplate.find(query, entity);
    }

    @Override
    public <T> T listObjectByThreeParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3, Object obj3, String orderBy) {
        Query query = new Query(Criteria.where(param1).is(obj1).and(param2).is(obj2).and(param3).is(obj3)).with(Sort.by(Sort.Direction.DESC, orderBy));
        return (T) mongoTemplate.find(query, entity);
    }

    @Override
    public <T> T listObjectByFourParam(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String param3, Object obj3, String param4, Object obj4, String orderBy) {
        Query query = new Query(Criteria.where(param1).is(obj1).and(param2).is(obj2).and(param3).is(obj3).and(param4).is(obj4)).with(Sort.by(Sort.Direction.DESC, orderBy));
        return (T) mongoTemplate.find(query, entity);
    }

    @Override
    public <T> T listObjectByMultipleParamAsc(Class<T> entity, String param1, Object obj1, String param2, Object obj2, String orderBy) {
        Query query = new Query(Criteria.where(param1).is(obj1).and(param2).is(obj2)).with(Sort.by(Sort.Direction.ASC, orderBy));
        return (T) mongoTemplate.find(query, entity);
    }

	@Override
	public <T> String getColumnByParam(Class<T> entity, String param) {
		// TODO Auto-generated method stub
		return null;
	}
}
