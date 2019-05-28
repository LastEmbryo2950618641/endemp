package cn.personal.endemp.controller;

import cn.personal.endemp.service.inter.CountHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ Author     ：liu
 * @ Date       ：Created in 11:01 2019/5/27
 * @ Description：
 * @ Modified By：
 * @Version: $
 */
@RestController
@RequestMapping("/WordsCounts")
public class WordsCounts {



    @Autowired
    CountHandler chineseCount;

    @RequestMapping("/count")
    public Map<String,String> wordsCounts(@RequestParam("dataType") String dataType,@RequestParam("dataText") String dataText)
    {
        return chineseCount.count(dataText);

    }
}
