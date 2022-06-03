package JDBCMain;

import dao.AccountDAO;
import entity.Account;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        AccountDAO ad = new AccountDAO();
        //System.out.println(ad.getOne("Hanhht4"));

//        Account accDel = Account.builder()
//                .username("QuanVV")
//                .build();
//
//        System.out.println(ad.delete(accDel));

//        List<Account> ls = ad.getAll();
//        ls.forEach(account -> System.out.println(account));

        List<Account> ls = ad.search2(5, 10);
        ls.forEach(account -> System.out.println(account));

    }
}
