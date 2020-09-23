package com.rambo.copy;

import lombok.Data;

/**
 * 浅拷贝
 * @author ：baizhanshi
 * @date ：Created in 2020/9/23 15:02
 */
@Data
public class Major {

    private String majorName;

    private int majorId;

    public Major(String majorName, int majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }
}
