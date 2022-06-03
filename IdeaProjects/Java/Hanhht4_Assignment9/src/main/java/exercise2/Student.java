package exercise2;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Student {
    private int id;
    private int paper1;
    private int paper2;
    private int paper3;
    private int paper4;
    private int paper5;
    private int paper6;
    private int paper7;
    private int total;

    public Student(int id, int paper1, int paper2, int paper3, int paper4, int paper5, int paper6, int paper7) {
        this.id = id;
        this.paper1 = paper1;
        this.paper2 = paper2;
        this.paper3 = paper3;
        this.paper4 = paper4;
        this.paper5 = paper5;
        this.paper6 = paper6;
        this.paper7 = paper7;
    }
}
