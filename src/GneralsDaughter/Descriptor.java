package GneralsDaughter;

import java.util.Date;

/**
 * Created by brandon on 12/14/2016.
 */
public class Descriptor {

    private int type;
    private String path, name;
    private Date orig, mod;

    Descriptor(int type, String name) {
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
