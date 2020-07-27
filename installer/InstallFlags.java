/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lostontrelokiv.installer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import lostontrelokiv.logic.Fork;


/**
 *
 * @author jedi
 */
public class InstallFlags {

    private Connection connection;

    public InstallFlags(Connection connection) {
        this.connection = connection;
    }


    public void install() {
        System.out.println("installing flags");

        addFlag(1, "description flag 1");
        addFlag(2, "description flag 2");
        addFlag(3, "description flag 3");
        addFlag(5, "description flag 4");
    }


    public void addFlag(int flagId, String flag_description) {
        String s = "INSERT INTO Flags"
                + "(flag_id, first, second, third, flag_description) VALUES (?,?,?,?,?)";

        // TextUserInterface.printlnDebug("InstallFlags.addFlag(): " + s);

        PreparedStatement p = null;

        try {
            p = this.connection.prepareStatement(s);
            p.setInt(1, flagId);
            p.setBoolean(2, false);
            p.setBoolean(3, false);
            p.setBoolean(4, false);
            p.setString(5, flag_description);
            p.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        } 
    }


}
