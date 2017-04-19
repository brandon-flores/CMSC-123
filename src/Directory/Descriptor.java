package Directory;

import java.util.Date;
import java.util.List;

/**
 * Created by brandon on 12/9/2016.
 */
public class Descriptor {

    int type;
    String path, name;
    Date orig, mod;

    Descriptor(int type, String name){
        this.type = type;
        path = "";
        orig = new Date();
        mod = new Date();
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getOrig() {
        return orig;
    }

    public void setOrig(Date orig) {
        this.orig = orig;
    }

    public Date getMod() {
        return mod;
    }

    public void setMod(Date mod) {
        this.mod = mod;
    }
}
