package com.rambo.designMethod.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象被观察者
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/26 15:04
 */
public abstract class Subject {

    private List<Observer> observerList = new ArrayList<>();

    public void attachObserver(Observer observer) {
        observerList.add(observer);
    }

    public void detachObserver(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update();
        }
    }
}
