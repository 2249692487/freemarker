package com.test;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.*;

/**
 * 描述：待描述
 * </p>
 *
 * @author QinLiNa
 * @data 2019/2/21
 */
public class TestFreemarker {
    public static void main(String[] args) throws Exception {
        //1. 创建freemarker初始化对象
        Configuration conf = new Configuration();
        //2. 加载模板所在目录位置
        conf.setDirectoryForTemplateLoading(new File("D:\\GitHub\\freemarkerDemo\\src\\main\\resources\\ftl"));
        //3. 创建模板对象, 指定加载的模板的文件名
        Template template = conf.getTemplate("test.ftl");

        //4. 模拟假数据, 传入模板中使用
        Map<String, Object> rootMap = new HashMap<String, Object>();
        //模拟向模板中传入字符串数据
        rootMap.put("name", "张三");
        rootMap.put("message", "欢迎来到神奇的品优购世界!");

        //模拟向模板中传入List数据
        List<String> personList = new ArrayList<String>();
        personList.add("青龙");
        personList.add("白虎");
        personList.add("朱雀");
        personList.add("玄武");
        rootMap.put("personList", personList);

        //模拟向模板中传入Map数据
        Map<String, String> personMap = new HashMap<String, String>();
        personMap.put("001", "穷奇");
        personMap.put("002", "饕鬄");
        personMap.put("003", "梼杌");
        personMap.put("004", "混沌");
        rootMap.put("personMap", personMap);

        rootMap.put("today", new Date());
        rootMap.put("point", 102920122);

        //5. 创建输出流, 指定生成的静态页面的位置和名称
        Writer out = new FileWriter(new File("test.html"));
        //6. 生成
        template.process(rootMap, out);
        //7. 关闭流
        out.close();
    }
}
