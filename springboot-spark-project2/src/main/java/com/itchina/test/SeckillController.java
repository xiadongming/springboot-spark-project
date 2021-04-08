package com.itchina.test;

import com.itchina.seckill.GoodsSeckillBO;
import com.itchina.seckill.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date: 2021/3/28 17:27
 * @Desc:
 */
@RestController
@RequestMapping("/seckill")
public class SeckillController {

    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value = "/seckill",method = {RequestMethod.GET,RequestMethod.POST})
    public Object seckill(Integer id,String userId) throws Exception {
        GoodsSeckillBO goodsSeckillBO = seckillService.processSeckill(id,userId,1);
        System.out.println("goodsSeckillBO=  "+goodsSeckillBO);

        return  "successful";
    }

}
