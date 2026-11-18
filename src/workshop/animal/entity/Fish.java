package workshop.animal.entity;

public class Fish extends Animal implements Pet{
    private String name;

    public Fish(){
        super(0);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void play(){
        System.out.println(this.name + " cool play");
    }
    public void eat(){
        System.out.println(this.name + " is eating!");
    }
    @Override
    public void walk(){
        System.out.println(this.name + " is swimming!");
    }

}
