package xiongchang.jdk8.bean;

public class LambdaDemo {

    private  Integer age;

    private  Double salary;

    private  String name;

    public LambdaDemo() {
    }

    public LambdaDemo(Integer age, Double salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LambdaDemo{" +
                "age=" + age +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }
}
