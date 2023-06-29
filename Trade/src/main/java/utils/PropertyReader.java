package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	FileReader reader;  
    
    Properties p ;
    
    public PropertyReader(String path) throws IOException
    {
    	reader = new FileReader(new File(path));
    	
    	p = new Properties();
    	
    	p.load(reader);
    }
    
    public String getPropValue(String propKey)
    {
    	return p.getProperty(propKey);
    }
}
