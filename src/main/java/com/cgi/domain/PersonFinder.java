package com.cgi.domain;

/**
 *
 */
public class PersonFinder {
    /**
     * Where is Waldo? Uses depth-first pre-order algorithm
     * @param p Family tree for somebody
     * @return waldo or null if Waldo is not found
     */
    public Person findWaldo(Person p) {
        if (p.getName().equals("Waldo")) {
            return p;
        }
        for (Person child : p.getChildren()) {
            //we will go
            Person result = findWaldo(child);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
