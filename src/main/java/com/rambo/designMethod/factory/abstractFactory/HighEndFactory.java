package com.rambo.designMethod.factory.abstractFactory;

import com.rambo.designMethod.factory.HighEndMask;
import com.rambo.designMethod.factory.IMask;

/**
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/23 18:18
 */
public class HighEndFactory implements IFactory {
    @Override
    public IMask createMask() {
        return new HighEndMask();
    }

    @Override
    public IProtectiveSuit createSuit() {
        return new HighEndProtectiveSuit();
    }
}
