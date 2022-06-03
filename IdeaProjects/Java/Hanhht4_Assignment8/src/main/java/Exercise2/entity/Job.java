package Exercise2.entity;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Job {

    private String employer;
    private Duration duration;
    private String title;
    private String description;

}
