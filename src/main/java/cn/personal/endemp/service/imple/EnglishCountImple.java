package cn.personal.endemp.service.imple;

import cn.personal.endemp.service.inter.CountHandler;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;

import java.util.Map;

/**
 * 英文词频统计
 */
@Service("englishCountImple")
public class EnglishCountImple implements CountHandler {

    @Override
    public Map<String, String> count(String dataText) {

        Map<String,String> resultMap =  new HashMap<String,String>();


        String shPath = "/home/liuqi/space/shell/countWords/English/countWords.sh";
        String resultPath = "/home/liuqi/space/shell/countWords/English/result.txt";
        String inputPath="/home/liuqi/space/shell/countWords/English/input.txt";
        String param1 = "/hadoop/test/countwords/input";
        String param2 = "/hadoop/test/countwords/result";
        File result = new File(resultPath);

        File dataTextFile=new File(inputPath);

        if(!dataTextFile.exists()){
            try {
                dataTextFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(dataTextFile);
            fileWriter.write(dataText);
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


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

        String auth = shPath+" " + param1+ " " + param2+" " + resultPath+" "+inputPath;

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
