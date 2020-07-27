package lostontrelokiv.installer;

import java.sql.Connection;


public class InstallNodesToFlags {

    private Connection connection;

    public InstallNodesToFlags(Connection connection) {
        this.connection = connection;
    }


    public void install() {
        System.out.println("installing nodestoflags");;
    }


}
