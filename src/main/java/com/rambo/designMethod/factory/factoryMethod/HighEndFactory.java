package com.rambo.designMethod.factory.factoryMethod;

import com.rambo.designMethod.factory.HighEndMask;
import com.rambo.designMethod.factory.IMask;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/23 17:56
 */
public class HighEndFactory implements IMaskFactory {
    @Override
    public IMask createMask() {
        return new HighEndMask();
    }
}
