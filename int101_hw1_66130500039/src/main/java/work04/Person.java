package work04;

public class Person {
    private int id;
    public Person(int id){
        this.id=id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return "Person("+id+")";
    }

}
