package com.micro.service.biz.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.micro.service.biz.dao.BookInfoMapper;
import com.micro.service.biz.entity.BookInfo;
import com.micro.service.biz.service.IBookInfoService;
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
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements IBookInfoService {
	
}
