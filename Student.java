import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Students {
    
    int id;
    String name;
    String role;
    String city;

    public Students(int id, String name, String role, String city){
        this.id=id;
        this.name=name;
        this.role=role;
        this.city=city;
    }
public class Student {

    public static void main(String[] args) {
        
        List<Students> list = Arrays.asList(new Students(1, "Meharban", "Java Developer", "Delhi"),
        new Students(2, "Rimsha", "House-Wife", "New Delhi"));

       List<String> newList = list.stream()
       .map((name)->name.name)
       .collect(Collectors.toList());
       System.out.println(newList);
        };
    }
}
