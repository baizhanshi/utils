package com.rambo.copy;

import lombok.Data;

/**
 * 深拷贝
 * @author ：baizhanshi
 * @date ：Created in 2020/9/23 15:02
 */
@Data
public class MajorSheep  implements Cloneable{

    private String majorName;

    private int majorId;

    public MajorSheep(String majorName, int majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
