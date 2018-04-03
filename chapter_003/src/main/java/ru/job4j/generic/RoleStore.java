package ru.job4j.generic;

public class RoleStore implements Store {
    private SimpleList<Role> sl = new SimpleList<>(10);

    @Override
    public void add(Base model) {
        sl.add((Role) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        for (Role role : sl) {
            if (role.getId() == id) {
                role = (Role) model;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        for (int i = 0; i < sl.index; i++) {
            if (sl.get(i).getId() == id){
                sl.delete(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Base findById(String id) {
        for (Role role : sl) {
            if (role.getId() == id) {
                return role;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RoleStore roleStore = new RoleStore();
        Role r1 = new Role("111");
        Role r2 = new Role("222");
        Role r3 = new Role("333");

        roleStore.add(r1);
        roleStore.add(r2);
        roleStore.add(r3);

        //roleStore.delete("111");
        System.out.println(roleStore.findById("111"));
    }
}
