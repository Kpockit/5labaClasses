package laba5_Pokitku;

public class Tree extends Plant {
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private static int count = 0;

    public static int getCount() { return count; }

    private int age;

    public int getAge() { return age; }

    public void setAge(int age) throws IllegalArgumentException {
        if (age<0){
            throw new IllegalArgumentException("Введен неправильный возраст!");
        }
        this.age = age;
    }

    public Tree(String name, int age) throws IllegalArgumentException{
        super(name);
        this.setAge(age);
    }

    @Override
    public String info(){
        return super.info() + ", тип - дерево, возраст - " + this.age;
    }
}
