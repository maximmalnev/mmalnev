package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StoreTest {

    @Test
    public void whenFindRoleById() {
        RoleStore roleStore = new RoleStore();
        Role r1 = new Role("111");
        Role r2 = new Role("222");
        Role r3 = new Role("333");

        roleStore.add(r1);
        roleStore.add(r2);
        roleStore.add(r3);

        assertThat(roleStore.findById("111"), is(r1));
        assertThat(roleStore.findById("222"), is(r2));
        assertThat(roleStore.findById("333"), is(r3));
        assertNull(roleStore.findById("444"));
    }

    @Test
    public void whenDeleteRoleThenReturnNull() {
        RoleStore roleStore = new RoleStore();
        Role r1 = new Role("111");
        Role r2 = new Role("222");
        Role r3 = new Role("333");

        roleStore.add(r1);
        roleStore.add(r2);
        roleStore.add(r3);

        roleStore.delete("111");

        assertNull(roleStore.findById("111"));
    }

    @Test
    public void whenReplaceRoleThenReturnNewRole() {
        RoleStore roleStore = new RoleStore();
        Role r1 = new Role("111");
        Role r2 = new Role("222");
        Role r3 = new Role("333");

        roleStore.add(r1);
        roleStore.add(r2);
        roleStore.add(r3);

        roleStore.replace("222", r3);

        assertNull(roleStore.findById("222"));
        assertThat(roleStore.findById("333"), is(r3));

    }
}
