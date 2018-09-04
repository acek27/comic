
package comic;

import java.io.File;

public class session {
    static String id_user = "";
    static File imageFile;
    static String path;
    
    public session() {
    }
    
    public void setFile(File x){
        imageFile = x;
    }
    
    public File getFile(){
        return imageFile;
    }
    
    public void setPath (String x){
        path = x;
    }
    
    public String getPath(){
        return path;
    }
    
    public void set(String a) {
        id_user = a;
    }
    
    public String get() {
        return id_user;
    }
}
