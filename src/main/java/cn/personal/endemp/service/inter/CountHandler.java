package cn.personal.endemp.service.inter;

import java.util.Map;

/**
 * create by: End Emptiness
 * description:词频统计处理器接口
 * create time: 11:05 2019/5/27
 * 
 * @param  * @Param: null
 * @return 
 */
public interface CountHandler {

    /**
     * create by: End Emptiness
     * description：统计
     * create time: 11:06 2019/5/27
     *
     * @param  * @Param: null
     * @return {"result":"this a result of count"}
     */
     Map<String ,String> count(String dataText);
}
