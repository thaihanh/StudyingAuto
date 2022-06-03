package Exercise1;

import dao.TableDAO;
import entity.Table;

import java.util.List;

public class Main {

    public static void main(String[] args){

        List<Table> ls = new TableDAO().getInfo();
        ls.forEach(table -> System.out.println(table));
    }
}
