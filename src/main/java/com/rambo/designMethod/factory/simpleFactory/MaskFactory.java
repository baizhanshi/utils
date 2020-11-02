package com.rambo.designMethod.factory.simpleFactory;

import com.rambo.designMethod.factory.HighEndMask;
import com.rambo.designMethod.factory.IMask;
import com.rambo.designMethod.factory.LowEndMask;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/23 17:52
 */
public class MaskFactory {

    public IMask createMask(String type) {
        IMask mask = null;
        if ("高端口罩".equals(type)) {
            mask = new HighEndMask();
        } else if ("低端口罩".equals(type)) {
            mask = new LowEndMask();
        }
        return mask;
    }
}
