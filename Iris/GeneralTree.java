
public class GeneralTree {
	GenNode root;
    GenNode current;

    GeneralTree(){
        root = new GenNode(1, null, "root");
        current = root;
    }

    void insert(String s, int i){
        current.addChildren(new GenNode(i, current, s));
    }

    boolean delete(String s){
        if(!search(s)){
        	System.out.println("No such file or directory");
        	return false;
        }else{
        	current.removeChildren(search2(s));
        	return true;
        }
    }

    void rename(String s1,String s2){
    	if(search(s2)){
    		System.out.println("New File or Directory Name already exists");
    	}else{
    		if(search2(s1)!=null){
    			GenNode gn = search2(s1);
    	    	gn.getItem().setName(s2);
    		}else{
    			System.out.println("File or Directory doesn't exist.");
    		}
    	}
    	
    }
    void copy(String s1,String s2){
    	if(search(s2)){
    		System.out.println("File or Directory destination already exists");
    	}else{
    		if(search2(s1)!=null){
    			GenNode gn = search2(s1);
    			GenNode g = new GenNode(gn);
    			g.getItem().setName(s2);
    			current.addChildren(g);
    		}else{
    			System.out.println("File or Directory source does not exist");
    		}
    	}
    }
    GenNode search2(String s){
    	 for(GenNode n : current.getChildren()){
             if(n.getItem().getName().equals(s)) {
                 return n;
             }
         }
         return null;
    }
    boolean search(String s){
        for(GenNode n : current.getChildren()){
            if(n.getItem().getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    void edit(String s1,String s2){
    	String newData = search2(s1).getItem().getData().concat(s2);
    	search2(s1).getItem().setData(newData);
    }

    void show(String s){
    	if(!search(s)){
    		System.out.println("No such file");
    	}else{
    		if(search2(s).getItem().type == 2){
    			search2(s).getItem().printData();
    		}else{
    			System.out.println("No such file");
    		}
    	}
    }
    void changeCurrent(String s){
    	if(s.equals("..")){
            if(current.getParent() != null) current = current.getParent();
        }else{
            if(!search(s)) System.out.println("cd: " + s +": No such file or directory");
            else{
            	if(search2(s).getItem().getType()==2){
            		System.out.println("No such directory");
            	}else{
            		current = search2(s);
            	}
                
            }
        } 
    }

    void list(){
    	if(current.getChildren().isEmpty()){
    		System.out.println("usage: mkdir <directory name>");
    	}else{
    		for(GenNode n : current.getChildren()){
                System.out.println(n.getItem().getName());
            }
    	}
        
    }
}
