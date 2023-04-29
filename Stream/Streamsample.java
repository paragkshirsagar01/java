import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Streamsample{
    public static void main(String[] args){
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        List<Integer> arr2=arr.stream().filter(x->x%2==0).collect(Collectors.toList());//collectors
        for(Integer x:arr2){//for each concept
            System.out.println(x);
        }
        System.out.println(arr.stream().count());//count
        Map<Integer,Integer> map1=arr.stream().collect(Collectors.toMap(x->x,x->x%2));
        for (Entry<Integer, Integer> integer : map1.entrySet()) {
            System.out.println(integer.getKey()+" "+integer.getValue());
        }
        List<Integer> l2=arr.parallelStream().filter(i->i%2==0).collect(Collectors.toList());
        for (Integer integer : l2) {
            System.out.println(integer);
        }
        for (Integer integer : l2.stream().map(x->x*2).collect(Collectors.toList())){//map
            System.out.println(integer);
        }
        List<List<Integer>> arrlist=new ArrayList<>();
        arrlist.add(l2);
        arrlist.add(arr);
        for(Integer intx:arrlist.stream().flatMap(x->x.stream()).collect(Collectors.toList())){
            System.out.println("list flatmap "+intx);
        }
    }
}