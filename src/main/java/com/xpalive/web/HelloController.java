package com.xpalive.web;

import com.xpalive.Codes;
import org.apache.commons.text.StrSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by xiongp on 2017/9/5.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private Codes codes;

    @GetMapping("world")
    @ResponseBody
    public String world(){
        Map<String,String> valuesMap = new WeakHashMap<>();
        String envName = codes.getEnv().getName();
        String port = codes.getEnvironment().getProperty("");
        valuesMap.put("envName", envName);
        valuesMap.put("port", port);
        StrSubstitutor sub = new StrSubstitutor(valuesMap);
        return sub.replace("${envName}--helloWorld--${port}");
    }
}
