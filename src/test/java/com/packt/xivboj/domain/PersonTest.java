package com.packt.xivboj.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PersonTest {




    @Test
    public void method_getPersonId_should_return_not_null_is_such_id_exists() {

        Person person = new Person("P1", "Patryk", "Kruk");

        String id = person.getNameId();

        Assert.assertEquals(id, "P1");
    }
}
