package com.rambo.api;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/12/18 18:31
 */

public class TestReflect {
    public static void main(String[] args) throws Exception {
        CreateUserAPI createUserAPI = new CreateUserAPI("zhangsan", "123", "18516528892", 3);
        remoteCall(createUserAPI);
    }

    private static void remoteCall(AbstractAPI api) throws IOException {
        //从BankAPI注解获取请求地址
        BankAPI bankAPI = api.getClass().getAnnotation(BankAPI.class);
        System.out.println(bankAPI.url());
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(api.getClass().getDeclaredFields()) //获得所有字段
                .filter(field -> field.isAnnotationPresent(BankAPIField.class)) //查找标记了注解的字段
                .sorted(Comparator.comparingInt(a -> a.getAnnotation(BankAPIField.class).order())) //根据注解中的order对字段排序
                .peek(field -> field.setAccessible(true)) //设置可以访问私有字段
                .forEach(field -> {
                    //获得注解
                    BankAPIField bankAPIField = field.getAnnotation(BankAPIField.class);
                    Object value = "";
                    try {
                        //反射获取字段值
                        value = field.get(api);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    //根据字段类型以正确的填充方式格式化字符串
                    switch (bankAPIField.type()) {
                        case "S": {
                            stringBuilder.append(String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(' ', '_')).append("**");
                            break;
                        }
                        case "N": {
                            stringBuilder.append(String.format("%" + bankAPIField.length() + "s", value.toString()).replace(' ', '0')).append("**");
                            break;
                        }
                        case "M": {
                            if (!(value instanceof BigDecimal)) {
                                throw new RuntimeException(String.format("{} 的 {} 必须是BigDecimal", api, field));
                            }
                            stringBuilder.append(String.format("%0" + bankAPIField.length() + "d",
                                    ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue())).append("**");
                            break;
                        }
                        default:
                            break;
                    }
                });
        //签名逻辑
        stringBuilder.append(DigestUtils.md2Hex(stringBuilder.toString()));
        String param = stringBuilder.toString();
        //发请求
//        String result = Request.Post("http://localhost:45678/reflection" + bankAPI.url())
//                .bodyString(param, ContentType.APPLICATION_JSON)
//                .execute().returnContent().asString();
        System.out.println(param);
    }
}
