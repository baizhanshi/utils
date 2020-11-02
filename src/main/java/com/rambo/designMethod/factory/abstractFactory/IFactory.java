package com.rambo.designMethod.factory.abstractFactory;

import com.rambo.designMethod.factory.IMask;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/23 18:17
 */
public interface IFactory {
    //创建口罩
    IMask createMask();
    //创建防护服
    IProtectiveSuit createSuit();

}
