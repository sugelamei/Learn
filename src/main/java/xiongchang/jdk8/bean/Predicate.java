package xiongchang.jdk8.bean;

@FunctionalInterface
public interface Predicate<T> {

    Boolean filt(T t);

}
