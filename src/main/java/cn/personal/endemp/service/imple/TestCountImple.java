package cn.personal.endemp.service.imple;

import cn.personal.endemp.service.inter.CountHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("testCountImple")
public class TestCountImple implements CountHandler {
    @Override
    public Map<String, String> count(String dataText) {
        return null;
    }
}
