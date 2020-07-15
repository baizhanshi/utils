
package com.rambo.enumTest;

import lombok.Getter;

/**
 * 业务类型枚举
 * 
 * @author baizhanshi
 */
public enum BusinessTypeEnum implements BaseEnum<String, String, String> {

    RENEWAL("1", "个险续保", "renewal"),

    GUIDE_FLOW("2", "广告线索", "ad"),

    LOSS_ORDER_FLOW("3", "流失订单", "lossOrder"),

    ZHIYING_UNPAID_ORDER("4", "直营催付", "zhiying"),

    CREDIT_APPLICATION("5", "贷款申请", "credit");

    @Getter
    private String code;

    @Getter
    private String value;
    @Getter
    private String desc;

    /**
     * @param code
     * @param value
     * @param desc
     */
    BusinessTypeEnum(String code, String value, String desc) {
        this.code = code;
        this.value = value;
        this.desc = desc;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
