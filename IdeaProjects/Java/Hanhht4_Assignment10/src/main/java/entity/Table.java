package entity;

import lombok.*;

@Getter
@Setter
@ToString
@Builder

public class Table {

    private String name;
    private String columnName;
    private String dataType;


}
