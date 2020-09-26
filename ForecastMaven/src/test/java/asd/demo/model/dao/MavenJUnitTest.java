/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

/**
 *
 * @author yujiwon
 
 * 
 */

import DAO.MongoDBConnector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class MavenJUnitTest 
{
    private static MongoDBConnector mdb;
    
    public MavenJUnitTest()
    {

    }
    /*
    @BeforeClass
    public static void setUpClass() throws UnknownHostExcpetion
    {
        System.out.println("\n<- Starting test-->");
        String name ="dbuser";
        String password="helloworld99";
        mdb = new MongoDBConnector(name,password);
    }
    
    @Test
    public void testMongoDBConnect() throws UnknownHostException
    {
        Assert.assertNotNull("Cannot establish connect to MDB", mdb.getMongoDB());
        System.out.println("\n-Connection to MongoDB ");
    
    }*/
}
