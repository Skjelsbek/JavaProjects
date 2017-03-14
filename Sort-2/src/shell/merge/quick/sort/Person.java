package shell.merge.quick.sort;

public class Person implements Comparable<Person> {
    private int age;
    
    public Person(int age) {
        this.age = age;
    }    
    
    public int getAge() {
        return this.age;
    }
    
    @Override
    public int compareTo(Person o) {
        if (this.age < o.getAge()) return -1;
        if (this.age > o.getAge()) return 1;
        return 0;
    }
    
}
