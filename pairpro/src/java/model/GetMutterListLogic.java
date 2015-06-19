/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterDAO0;
import dao.MutterDAO0;
import java.util.List;

/**
 *
 * @author
 */
public class GetMutterListLogic {
    public List<Mutter> execute() {
        MutterDAO0 dao = new MutterDAO0();
        List<Mutter> mutterList = dao.findAll();
        return mutterList;
    }
}
