package com.hwd.service.impl;

import com.hwd.NotFoundException;
import com.hwd.dao.TypeDao;
import com.hwd.domain.Type;
import com.hwd.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Transactional
    @Override
    public Type save(Type type) {
        return typeDao.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getOne(id);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeDao.findAll(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t=typeDao.getOne(id);
        if (t==null){
            throw  new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,t);

        return typeDao.save(t);
    }

    @Transactional
    @Override
    public void deleteType(Long id) {

        typeDao.deleteById(id);
    }

    @Override
    public Type getTypeByName(String name) {

        return  typeDao.findByName(name);
    }

    @Override
    public List<Type> listType() {
        return typeDao.findAll();
    }

    @Override
    public List<Type> listTypeTop(Integer size) {

        Sort sort=new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable=new PageRequest(0,size,sort);
        return typeDao.findTop(pageable);
    }
}
