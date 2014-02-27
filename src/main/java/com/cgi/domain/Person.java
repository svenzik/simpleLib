package com.cgi.domain;

import java.util.List;

/**
 * Person with children
 */
interface Person {
    String getName();
    List<Person> getChildren();
}
