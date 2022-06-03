package entity;

import lombok.*;

@Getter
@Setter
@ToString
@Builder

public class Account {

    private int id;
    private String username;
    private String password;
    private int type;
    private int status;

}
