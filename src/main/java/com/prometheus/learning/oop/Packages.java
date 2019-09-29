package com.prometheus.learning.oop;

import org.w3c.dom.Node;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

/** Like with regular imports, it is not possible to static import 2 members with the same name */

/**
 * Wildcard * imports do not have negative effect on program performance
 */

//this packages' inner packages, but using .* may cause threads when the package and its subpackage
//contain the class with the same name, because Java doesn't know which one to choose
/**
 * Classes directly in src folder do not require package statement, they are in default package
 * <p>
 * Packages enable to categorize related classes and enables namespace for that package
 * so that classes with the same names won't be conflicted.
 * Package names start with the projects domain name reversed, e.g com.google etc
 * Package declaration must be the first thing in a class file and the name must
 * be in correspondence to the actual folder structure.
 * <p>
 * Classes within the same package have unrestricted access to each other by default,
 * but are hidden from the classes outside of that package (by default).
 * <p>
 * java.lang package is automatically and implicitly imported, so classes within lang package
 * can be used without importing java.lang explicitly.
 * <p>
 * Packages enable to categorize related classes and enables namespace for that package
 * so that classes with the same names won't be conflicted.
 * Package names start with the projects domain name reversed, e.g com.google etc
 * Package declaration must be the first thing in a class file and the name must
 * be in correspondence to the actual folder structure.
 * <p>
 * Classes within the same package have unrestricted access to each other by default,
 * but are hidden from the classes outside of that package (incl. subpackages)(by default).
 * <p>
 * java.lang package is automatically and implicitly imported, so classes within lang package
 * can be used without importing java.lang explicitly.
 * <p>
 * Packages enable to categorize related classes and enables namespace for that package
 * so that classes with the same names won't be conflicted.
 * Package names start with the projects domain name reversed, e.g com.google etc
 * Package declaration must be the first thing in a class file and the name must
 * be in correspondence to the actual folder structure.
 * <p>
 * Classes within the same package have unrestricted access to each other by default,
 * but are hidden from the classes outside of that package (incl. subpackages)(by default).
 * <p>
 * java.lang package is automatically and implicitly imported, so classes within lang package
 * can be used without importing java.lang explicitly.
 */
//import org.dom4j.Node; //Class with the same name can only be imported from one package
/**
 * Packages enable to categorize related classes and enables namespace for that package
 * so that classes with the same names won't be conflicted.
 * Package names start with the projects domain name reversed, e.g com.google etc
 * Package declaration must be the first thing in a class file and the name must
 * be in correspondence to the actual folder structure.
 */
/**
 * Classes within the same package have unrestricted access to each other by default,
 * but are hidden from the classes outside of that package (incl. subpackages)(by default).
 */
/**
 * java.lang package is automatically and implicitly imported, so classes within lang package
 * can be used without importing java.lang explicitly.
 */

public class Packages {

    /** Static methods can be imported with static keyword, so the class of the
     * static method does not have to be referenced when using its static method.
     */
    public void staticImports() {

        System.out.println(sqrt(2)); //imported static method
        System.out.println(PI); //imported static field
    }

    Node node1;
    org.dom4j.Node node2; //Other classes have to be specified by their full package + classname each time.
    Set set = new HashSet();
    CancellationException ex;

    Date date;
    Date sqlDate;

    /** Classes in default package (directly in src folder) cannot be used in classes
     *  of other packages
     */

}
