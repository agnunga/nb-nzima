/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author agunga
 */
public interface CRUDBeanI {

    Object add(Object o);

    Object update(Object o);

    List<Object> findAll(Object o);

    Object readById(Object o);

    boolean delete(long id);
}
