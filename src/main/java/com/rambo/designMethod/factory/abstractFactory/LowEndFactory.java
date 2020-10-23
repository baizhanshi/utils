package com.rambo.designMethod.factory.abstractFactory;

import com.rambo.designMethod.factory.IMask;
import com.rambo.designMethod.factory.LowEndMask;

/**
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/23 18:17
 */
public class LowEndFactory implements IFactory {
    @Override
    public IMask createMask() {
        return new LowEndMask();
    }

    @Override
    public IProtectiveSuit createSuit() {
        return new LowEndProtectiveSuit();
    }
}
