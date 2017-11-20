package com.micro.service.admin.controller;

import com.micro.service.biz.entity.Reader;
import com.micro.service.biz.service.IReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhy
 * @since 2017-11-17
 */
@RestController
@RequestMapping("/reader")
public class ReaderController {



    @Autowired
    private IReaderService readerService;


    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addReader(@RequestBody Reader reader){

        boolean flag= readerService.insert(reader);
        if (flag){
            return "add success";
        }else {
            return "add fail";
        }

    }
	
}
