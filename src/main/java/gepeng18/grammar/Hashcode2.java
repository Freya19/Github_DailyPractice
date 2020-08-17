package gepeng18.grammar;

import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class Hashcode2 {
    Integer a;
    Integer b;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hashcode2 vo = (Hashcode2) o;
        return Objects.equals(a, vo.a) &&
                Objects.equals(b, vo.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public static void main(String[] args) {
        Hashcode2 vo = new Hashcode2(1, 2);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        System.out.println(vo.hashCode());
        System.out.println(list.hashCode());
        System.out.println(vo.equals(list));
    }
}
