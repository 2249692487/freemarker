package com.test;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.*;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/2/21
 */
public class freemarkerTest {
    public static void main(String[] args) throws Exception {
        //1. 创建freemarker初始化对象
        Configuration configuration = new Configuration();
        //2. 加载模板所在目录位置
        configuration.setDirectoryForTemplateLoading(new File("D:\\GitHub\\freemarker\\src\\main\\resources\\ftl"));
        //3. 创建模板对象, 指定加载的模板的文件名
        Template template = configuration.getTemplate("test.ftl");
        //4. 模拟假数据, 传入模板中使用
        Map<String, Object> rootMap = new HashMap<String, Object>();
        //模拟向模板中传入字符串数据
        rootMap.put("name", "张三");
        rootMap.put("message", "早上好");
        // 向模板中写入List数据
        List<String> list = new ArrayList<String>();
        list.add("一");
        list.add("二");
        list.add("三");
        list.add("四");
        rootMap.put("personList",list);
        // 向模板中写入Map数据
        Map<String,String> map = new HashMap<String, String>();
        map.put("001","Java");
        map.put("002","php");
        map.put("003","GO");
        map.put("004","大数据");
        rootMap.put("personMap",map);
        rootMap.put("today",new Date());
        rootMap.put("point",11111);
        //5. 创建输出流, 指定生成的静态页面的位置和名称
        Writer out = new FileWriter(new File("test.html"));
        //6. 生成
        template.process(rootMap, out);
        //7. 关闭流
        out.close();
    }
}
