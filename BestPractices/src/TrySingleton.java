/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agunga
 */
public class TrySingleton {

    private static TrySingleton trySingleton = new TrySingleton();

    private TrySingleton() {
    }

    public static TrySingleton getTrySingleton() {
        return trySingleton;
    }

    public void printName(String name) {
        System.out.println("Name is: " + name);
    }

}
