package sort;

public class Person implements Comparable<Person> {
    private int age;
    
    public Person(int age) {
        this.age = age;
    }
    
    @Override
    public String toString() {
        return Integer.toString(age);
    }
    
    @Override
    public int compareTo(Person t) {
        if (this.age < t.age) {
            return -1;
        } else if (this.age > t.age) {
            return 1;
        } else {
            return 0;
        }        
    }    
}
