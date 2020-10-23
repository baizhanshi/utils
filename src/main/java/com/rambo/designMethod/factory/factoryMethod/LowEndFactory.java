package com.rambo.designMethod.factory.factoryMethod;

import com.rambo.designMethod.factory.IMask;
import com.rambo.designMethod.factory.LowEndMask;

/**
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/23 17:57
 */
public class LowEndFactory implements IMaskFactory {
    @Override
    public IMask createMask() {
        return new LowEndMask();
    }
}
