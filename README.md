simpleLib
=========

1.	Write method that reverse items in string input to reversed order (words are separated with spaces). Input can contain arbitrary number of words.
E.g. If input is vanitas vanitatum omnia vanitas, given return value would be vanitas omnia vanitatum vanitas

    Could have used Guava `Splitter.on(' ').split("vanitas vanitatum omnia vanitas")`, 
    but adding Guava dependecy for one method seemed like overdoing.
    In real life one should use the Guava lib.
    
    Created my own implementation that takes account for multiple consequtive separators - `_a____b_c_` to return `_c____b_a_`. Here the `_` is space.
    
    UnitTests are in `simpleLib/src/test/java/com/cgi/lang/StringUtilsTest.java`
    
    To run them, use `mvn test`

2.	Family tree search algorithm: write content to method that gets Person object as input (see specs below) and returns first Person instance from offsprings whose name is Waldo (or Person instance itself if name matches). Applicant does not need to implement Person object.

    ```Java
    interface Person {
        String getName();
        List<Person> getChildren();
    }
    
    public Person findWaldo(Person p) {
        /* Implementation to here */
    }
    ```

    Result can be found in `simpleLib/src/main/java/com/cgi/domain/PersonFinder.java`
