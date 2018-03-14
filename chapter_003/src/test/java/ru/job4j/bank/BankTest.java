package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "111111");
        bank.addUser(user1);
        assertThat(bank.getUsersList().containsKey(user1), is(true));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "111111");
        bank.addUser(user1);
        bank.deleteUser(user1);
        assertThat(bank.getUsersList().containsKey(user1), is(false));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "111111");
        Account acc1 = new Account(332211, 1000);
        Account acc2 = new Account(443322, 1000);
        bank.addUser(user1);
        bank.addAccountToUser("111111", acc1);
        bank.addAccountToUser("111111", acc2);
        assertThat(bank.getUsersList().get(user1).get(0), is(acc1));
        assertThat(bank.getUsersList().get(user1).get(1), is(acc2));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "111111");
        Account acc1 = new Account(332211, 1000);
        Account acc2 = new Account(443322, 1000);
        bank.addUser(user1);
        bank.addAccountToUser("111111", acc1);
        bank.addAccountToUser("111111", acc2);
        bank.deleteAccountFromUser("111111", acc1);
        assertThat(bank.getUsersList().get(user1).get(0), is(acc2));
    }

    @Test
    public void whenGetUserAccounts() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "111111");
        Account acc1 = new Account(332211, 1000);
        Account acc2 = new Account(443322, 1000);
        bank.addUser(user1);
        bank.addAccountToUser("111111", acc1);
        bank.addAccountToUser("111111", acc2);
        List<Account> accList = new ArrayList<>();
        accList.add(acc1);
        accList.add(acc2);
        assertThat(bank.getUsersList().get(user1), is(accList));
    }

    @Test
    public void whenCanTransferMoney() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "111111");
        User user2 = new User("Vova", "222222");
        Account acc1 = new Account(332211, 1000);
        Account acc2 = new Account(443322, 1000);
        bank.addUser(user1);
        bank.addAccountToUser("111111", acc1);
        bank.addUser(user2);
        bank.addAccountToUser("222222", acc2);
        bank.transferMoney("111111", 332211, "222222", 443322, 500);
        assertThat(bank.getUsersList().get(user1).get(0).getValue(), is(500));
        assertThat(bank.getUsersList().get(user2).get(0).getValue(), is(1500));
    }

    @Test
    public void whenCantTransferMoney() {
        Bank bank = new Bank();
        User user1 = new User("Ivan", "111111");
        User user2 = new User("Vova", "222222");
        Account acc1 = new Account(332211, 1000);
        Account acc2 = new Account(443322, 1000);
        bank.addUser(user1);
        bank.addAccountToUser("111111", acc1);
        bank.addUser(user2);
        bank.addAccountToUser("222222", acc2);
        bank.transferMoney("111111", 332211, "222222", 443322, 5000);
        assertThat(bank.getUsersList().get(user1).get(0).getValue(), is(1000));
        assertThat(bank.getUsersList().get(user2).get(0).getValue(), is(1000));
    }
}
