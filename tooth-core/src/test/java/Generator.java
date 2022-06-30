import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;

import java.util.Arrays;
import java.util.Map;

/**
 * @author czt
 * @description TODO
 * @date 2022/6/28 8:49 AM
 */
public class Generator {

    public static void main(String[] args) {

        //第一次生成请设置成true，否则设置成false 避免service serviceImpl被覆盖
        boolean override = false;

        String moduleName = "user";
        String tableName = "user";

        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
                            .fileOverride()
                            .outputDir(BASE_OUT_CLASS); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(BASE_PACKAGE) // 设置父包名
                            .entity("entity."+ moduleName)
                            .service("service." + moduleName)
                            .serviceImpl("service.impl."+ moduleName)
                            .mapper("mapper." + moduleName)
                            .xml("mapper." + moduleName)
                            .pathInfo(pathMap(moduleName)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder ->
                    builder.addInclude(Arrays.asList(tableName.split(",")))
                    .entityBuilder()
                            .fileOverride()
                            .enableLombok()//开启lombock
                            .enableTableFieldAnnotation().logicDeleteColumnName(DELETE_COLUMNS_NAME)
                    .mapperBuilder().fileOverride()

                )
                .templateConfig(builder -> {
                    if(!override){
                        builder.service(null).serviceImpl(null).controller(null);
                    }
                })
                .execute();
    }


    private static final String URL = "jdbc:mysql://localhost:3306/tooth?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";
    private static final String AUTHOR = "czt";
    private static final String BASE_PACKAGE = "com.py.tooth.core";
    private static final String BASE_OUT_CLASS ="/Users/chengzhentao/workspace/tooth/tooth-core/src/main/java/com/py/tooth/core/";
    private static final String BASE_MAPPER ="/Users/chengzhentao/workspace/tooth/tooth-core/src/main/resources/mapper/";
    private static final String DELETE_COLUMNS_NAME = "is_delete";
    private static Map pathMap(String moduleName){
        Map pathInfo = MapUtil.newHashMap();
        pathInfo.put(OutputFile.xml, BASE_MAPPER + moduleName);
        pathInfo.put(OutputFile.service,BASE_OUT_CLASS + "service/" + moduleName);
        pathInfo.put(OutputFile.serviceImpl,BASE_OUT_CLASS + "service/impl/" + moduleName);
        pathInfo.put(OutputFile.entity,BASE_OUT_CLASS + "entity/" + moduleName);
        pathInfo.put(OutputFile.controller,BASE_OUT_CLASS + "web/" + moduleName);
        pathInfo.put(OutputFile.mapper,BASE_OUT_CLASS + "mapper/" + moduleName);
        return pathInfo;
    }
}
