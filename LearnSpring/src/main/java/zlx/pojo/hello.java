package zlx.pojo;

public class hello {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    @Override
    public String toString(){
        //System.out.println(this.name);
        return this.name;
    }
}
