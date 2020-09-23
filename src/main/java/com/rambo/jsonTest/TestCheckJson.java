package com.rambo.jsonTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/3/17 9:54
 */
public class TestCheckJson {

    public static void main(String[] args) {
        String json = "{" +
                "    \"activityCode\": \"OBC0000004001\"," +
                "    \"outBizNo\": \"HA1200001456308227\"," +
                "    \"content\": [" +
                "        {" +
                "            \"newOutBizNo\": \"IH12345678903333\"," +
                "            \"newPackageDefName\": \"电商产品组合名称\"," +
                "            \"newInsureDate\": \"20200315140509\"," +
                "            \"newPremium\": \"500\"" +
                "        }," +
                "        {" +
                "            \"newOutBizNo\": \"IH123456789035553\"," +
                "            \"newPackageDefName\": \"电商产品组合名称\"," +
                "            \"newInsureDate\": \"20200315140509\"," +
                "            \"newPremium\": \"500\"" +
                "        }" +
                "    ]" +
                "}";

        JSONArray read = (JSONArray) JSONPath.read(json, "$.content");
        for (Object o : read) {
            System.out.println(o.toString());
        }
    }
}
