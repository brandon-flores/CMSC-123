import java.util.Date;

public class Descriptor {

    int type; //1-dir 2-file
    String path, name, data;
    Date original, modified;

    Descriptor(int type, String name){
        this.type = type;
        path = "";
        data = "";
        original = new Date();
        modified = new Date();
        this.name = name;
    }

    Descriptor(Descriptor src){
    	type = src.type;
    	path = src.path;
    	name = src.name;
    	data = src.data;
    	original = src.original;
    	modified = src.modified;
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
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void printData(){
    	System.out.println(data);
    }

    public Date getOrig() {
        return original;
    }

    public void setOrig(Date orig) {
        this.original = orig;
    }

    public Date getMod() {
        return modified;
    }

    public void setMod(Date mod) {
        this.modified = mod;
    }
}
