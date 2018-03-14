package ru.job4j.bank;

import java.util.*;

public class Bank {
    @Override
    public String toString() {
        return "Bank{" + "usersList=" + usersList + '}';
    }

    public Map<User, List<Account>> getUsersList() {
        return usersList;
    }

    private Map<User, List<Account>> usersList = new HashMap<>();

    /**
     * Добавление нового пользователя банка
     *
     * @param user - пользователь
     */
    public void addUser(User user) {
        usersList.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаление пользователя банка
     *
     * @param user - пользователь
     */
    public void deleteUser(User user) {
        usersList.remove(user);
    }

    /**
     * Добавление аккаунта пользователю
     *
     * @param passport - паспортные данные пользователя
     * @param account  - аккаунт для добавления
     */
    public void addAccountToUser(String passport, Account account) {
        usersList.forEach((user, acc) -> {
            if (passport.equals(user.getPassport())) {
                acc.add(account);
            }
        });
    }

    /**
     * Удаление аккаунта пользователя
     *
     * @param passport - паспортные данные пользователя
     * @param account  - аккаунт для удаления
     */
    public void deleteAccountFromUser(String passport, Account account) {
        usersList.forEach((user, acc) -> {
            if (passport.equals(user.getPassport())) {
                if (acc.indexOf(account) >= 0) {
                    acc.remove(acc.indexOf(account));
                }
            }
        });
    }

    /**
     * Получение списка аккаунтов пользователя
     *
     * @param passport - паспортные данные пользователя
     * @return - список аккаунтов пользователя
     */
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

    /**
     * Перевод средств со счета на счет
     *
     * @param srcPassport  - паспортные данные пользователя от которого переводятся средства
     * @param srcRequisite - реквизиты аккаунта пользователя от которого переводятся средства
     * @param destPassport - паспортные данные пользователя которому переводятся средства
     * @param dstRequisite - реквизиты аккаунта пользователя которому переводятся средства
     * @return - true если удалось перевести средства, false если нет
     */
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
                            break;
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
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}
