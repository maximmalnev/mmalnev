package ru.job4j.bank;

import java.util.*;

public class Bank {
    @Override
    public String toString() {
        return "Bank{" +
                "usersList=" + usersList +
                '}';
    }

    private Map<User, List<Account>> usersList = new HashMap<>();

    //добавление пользователя
    public void addUser(User user) {

        usersList.put(user, new ArrayList<>());
    }

    //удаление пользователя
    public void deleteUser(User user) {
        usersList.remove(user);
    }

    //добавить счёт пользователю
    public void addAccountToUser(String passport, Account account) {
        usersList.forEach((user, acc) -> {
            if (passport.equals(user.getPassport())) {
                acc.add(account);
            }
        });
    }

    //удалить один счёт пользователя
    public void deleteAccountFromUser(String passport, Account account) {

    }

    //получить список счетов для пользователя
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        Iterator<Map.Entry<User, List<Account>>> entries = usersList.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<User, List<Account>> entry = entries.next();
            User user = entry.getKey();
            if (passport.equals(user.getPassport())) {
                list = entry.getValue();
            }
        }
        return list;
    }

    //метод для перечисления денег с одного счёта на другой счёт:
    //если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
    public boolean transferMoney(String srcPassport, Integer srcRequisite, String destPassport, Integer dstRequisite, int amount) {
        boolean result = false;
        boolean haveMoney = false;
        List<Account> accountsList;
        Iterator<Map.Entry<User, List<Account>>> entries = usersList.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<User, List<Account>> entry = entries.next();
            User user = entry.getKey();
            if (srcPassport.equals(user.getPassport())) {
                accountsList = entry.getValue();
                for (Account account : accountsList) {
                    if (account.getRequisites().equals(srcRequisite)) {
                        int x = account.getValue();
                        if (x >= amount) {
                            account.setValue(x - amount);
                            haveMoney = true;
                        }
                    }
                }
            }
        }
        if (haveMoney) {
            Iterator<Map.Entry<User, List<Account>>> entries1 = usersList.entrySet().iterator();
            while (entries1.hasNext()) {
                Map.Entry<User, List<Account>> entry = entries1.next();
                User user = entry.getKey();
                if (destPassport.equals(user.getPassport())) {
                    accountsList = entry.getValue();
                    for (Account account : accountsList) {
                        if (account.getRequisites().equals(dstRequisite)) {
                            int x = account.getValue();
                            account.setValue(x + amount);
                            result = true;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // новый банк
        Bank bank = new Bank();

        //новые пользователи
        User user1 = new User("Ivan", "111111");
        User user2 = new User("Vladimir", "222222");
        //User user3 = new User("Petr", "333333");

        //новые аакаунты
        Account acc1 = new Account(432311, 1000);
        Account acc2 = new Account(213588, 200);

        bank.addUser(user1);
        bank.addUser(user2);
        //bank.addUser(user3);

        bank.addAccountToUser("111111", acc1);
        bank.addAccountToUser("222222", acc2);

        System.out.println(bank);
        System.out.println("-----------------");
        System.out.println(bank.getUserAccounts("111111"));
        System.out.println("-----------------");
        boolean print = bank.transferMoney("111111", 432311, "222222", 213588, 100);
        System.out.println(print);
        System.out.println("-----------------");
        System.out.println(bank);

    }
}
