package co.yiiu.pybbs.service.impl;


import co.yiiu.pybbs.mapper.MemberTypeMapper;
import co.yiiu.pybbs.model.MemberType;
import co.yiiu.pybbs.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberTypeServiceImpl implements MemberTypeService {

    @Autowired
    MemberTypeMapper memberTypeMapper;

    @Override
    public List<MemberType> getAll() {

        return memberTypeMapper.selectList(null);
    }
}
