/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.util;

/**
 *
 * @author agunga
 */
public class NoMatchFound extends Exception {

    public NoMatchFound() {
        super();
    }

    public NoMatchFound(String message) {
        super(message);
    }

    public NoMatchFound(Throwable cause) {
        super(cause);
    }

    public NoMatchFound(String message, Throwable cause) {
        super(message, cause);
    }

}
