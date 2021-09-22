import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Container<T>{
    void set(T a);
    T get();
}
class Store<T> implements Container<T>{

    private T a;
    @Override
    public void set(T a) {
        this.a=a;
    }

    @Override
    public T get() {
        return a;
    }
}
public class Genericdemo {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Genericdemo{}";
    }

    public static void main(String [] args){
        Container<String> stringStore = new Store<>();
        stringStore.set("hello");
        System.out.println(stringStore.get());

        Container<Integer> integerStore = new Store<>();
        integerStore.set(1);
        integerStore.set(10);
        System.out.println(integerStore.get());

        Container<List<Integer>> integerListStore = new Store<>();
        integerListStore.set(Arrays.asList(1,2,3,4));

        System.out.println(integerListStore.get());

        List<Number> list = new ArrayList<>();

        list.add(new Integer(8));
        list.add(new Double(9.098));

        System.out.println(list);
    }
}
