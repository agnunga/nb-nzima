/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.factory;

/**
 *
 * @author agunga
 */
public class AbstractFactoryFactory {

    AbstractFactoryType type;

    public AbstractFactoryFactory(AbstractFactoryType type) {
        this.type = type;
    }

    public AbstractFactory getFactory() {
        switch (type) {
            case DAO: {
                return new AnotherFactory();
            }
            case ANOTHER: {
                return new DaoFactory();
            }
            default:
                return null;
        }
    }
}
