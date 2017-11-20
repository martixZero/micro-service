package com.micro.service.biz.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.micro.service.biz.dao.ReaderMapper;
import com.micro.service.biz.entity.Reader;
import com.micro.service.biz.service.IReaderService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhy
 * @since 2017-11-17
 */
@Service
public class ReaderServiceImpl extends ServiceImpl<ReaderMapper, Reader> implements IReaderService {
	
}
