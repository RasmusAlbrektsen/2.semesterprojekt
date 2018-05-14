/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import data.SQLDatabase;

/**
 *
 * @author Bruger
 */
public class Bootstrap {

    public static void main(String[] args){
        SQLDatabase fisk = new SQLDatabase();
        fisk.loadData();
        Runner r = new Runner();
        r.run();
    }
}
