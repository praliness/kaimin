/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.MutterDAO0;
import java.util.List;

/**
 *
 * @author 
 */
public class PostMutterLogic {
    public void execute(Mutter mutter/*,List<Mutter> mutterList*/){
        //mutterList.add(0,mutter);
        MutterDAO0 dao=new MutterDAO0();
        dao.create(mutter);
    }
    
}
