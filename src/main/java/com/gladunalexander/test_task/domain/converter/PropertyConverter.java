package com.gladunalexander.test_task.domain.converter;

/**
 * This class helps to convert Json property
 * to String from {@link org.springframework.web.bind.annotation.RequestBody}
 *
 * Created by Alexander Gladun on 08/11/2017.
 */
public class PropertyConverter {

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
