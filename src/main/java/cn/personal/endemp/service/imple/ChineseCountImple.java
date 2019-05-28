package cn.personal.endemp.service.imple;

import cn.personal.endemp.service.inter.CountHandler;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：刘奇
 * @ Date       ：Created in 11:08 2019/5/27
 * @ Description：中文词频统计
 * @ Modified By：
 * @Version: v.1.0.0$
 */
@Service("chineseCountImple")
public class ChineseCountImple implements CountHandler {

    @Override
    public Map<String, String> count(String dataText) {

        Map<String,String> resultMap =  new HashMap<String,String>();


        String shPath = "/home/liuqi/space/shell/countWords/Chinese/countWords.sh";

        String resultPath = "/home/liuqi/space/shell/countWords/Chinese/result.txt";

        String param1 = "/hadoop/test/countwords/input";
        String param2 = "/hadoop/test/countwords/result";

        File result = new File(resultPath);

        if (!result.exists())
        {
            try {
                result.createNewFile();
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }

        Process process = null;

        String auth = shPath+" " + param1+ " " + param2+" " + resultPath;
        try{
            process = Runtime.getRuntime().exec(auth);
            process.waitFor();

        }catch (Exception e)
        {
            e.printStackTrace();
        }


        try {
            FileInputStream fileInputStream = new FileInputStream(result);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String resultText = "";
            String line ="";
            while( (line = bufferedReader.readLine())!=null)
            {
                line = line.trim().replace("\\t","    ");
                resultText += (line+"<br />");
            }

            resultMap.put("resultText",resultText);
            return resultMap;

        }catch (Exception e)
        {
            e.printStackTrace();
        }
        resultMap.put("resultText","");
        return resultMap;
    }
}
