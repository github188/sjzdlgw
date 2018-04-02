
package com.hbdl.web.sys.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;

public class SerializeUtils {

	private static final Logger logger = Logger.getLogger("Log4gTest");

	public static byte[] serialize(Object obj) {
		 byte[] bytes = null;      
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();      
	        try {        
	            ObjectOutputStream oos = new ObjectOutputStream(bos);         
	            oos.writeObject(obj);        
	            oos.flush();         
	            bytes = bos.toByteArray ();      
	            oos.close();         
	            bos.close();        
	        } catch (IOException ex) {     
	        	logger.error("jedis serializObj error:" + ex.getMessage());
	            ex.printStackTrace();   
	        }      
	        return bytes;   
	}

	public static Object unserialize(byte[] bytes) {

        Object obj = null;      
        try {        
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);        
            ObjectInputStream ois = new ObjectInputStream(bis);        
            obj = ois.readObject();      
            ois.close();   
            bis.close();   
        } catch (IOException ex) {   
        	logger.error("jedis serializObj error:" + ex.getMessage());
            ex.printStackTrace();   
        } catch (ClassNotFoundException ex) { 
        	logger.error("jedis serializObj error:" + ex.getMessage());
            ex.printStackTrace();   
        }      
        return obj;    
        
	}
}