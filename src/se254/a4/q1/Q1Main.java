package se254.a4.q1;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * SE254 Assignment 4 Question 1 Main. This class should be implemented to contain the functionality described in the
 * assignment handout. you may implement additional classes if you wish, but this class should be the main program entry
 * point.
 * 
 * 
 * Completed by: Dinith Wannigama - dwan609 - 834713594
 */
public class Q1Main {
	// Keeps track of declared public method of the user-specified class
	private static List<String> methodList = new ArrayList<String>();

	public static void main(String[] args) {
		System.out.print("Enter a fully qualified class name: ");
		String usrIn = getUserInput();

		Class<?> cl = getSpecifiedClass(usrIn);
		checkValidObject(cl, 1);
		Object obj = getSpecifiedObject(cl);
		checkValidObject(obj, 2);
		System.out.println("An object has been created for this class.\n");

		while (true) {
			printPublicFields(cl, obj); 
			printPublicMethods(cl);
			int errCode = 1;
			// Ask user to enter a method name until a valid one is entered
			while (errCode != 0) {
				System.out.println("Enter the name of a method to execute on the object (exactly as spelled above and without the brackets): ");
				String methodName = getUserInput();
				errCode = performSpecifiedMethod(cl, obj, methodName);
			}
		}

	}


	private static String getUserInput() {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		return s.trim();
	}


	private static Class<?> getSpecifiedClass(String className) {
		try {
			Class<?> cl = Class.forName(className);
			return cl;
		} catch (ClassNotFoundException e) {
			return null;
		}
	}


	private static Object getSpecifiedObject(Class<?> cl) {
		try {
			Object obj = cl.newInstance();
			return obj;
		} catch (InstantiationException | IllegalAccessException e) {
			return null;
		}
	}
	
	
	/**
	 * Checks if the Class or Object made is null or not and prints an error message depending on whether a
	 * Class or Object is being checked for invalidity. type = 1 is for Class, type = 2 is for Object.
	 */
	private static void checkValidObject(Object obj, int type) {
		if (obj == null) {
			System.err.println("ERROR: " + checkIfObjectOrClass(type) + "... Exiting program...\n\n");
			System.exit(-1);
		}
		return;
	}
	
	
	private static String checkIfObjectOrClass(int type) {
		if (type == 1) {
			return "Invalid class name";
		}
		return "Cannot instantiate this class";
	}


	private static void printPublicFields(Class<?> cl, Object obj) {
		System.out.println("Public fields:");
		for (Field f : cl.getFields()) {
			try {
				System.out.println("    " + f.getName() + ": " + f.get(obj));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}


	private static void printPublicMethods(Class<?> cl) {
		methodList.clear();
		System.out.println("Declared public methods without input parameters:");
		for (Method m : cl.getDeclaredMethods()) {
			if (m.getParameterTypes().length == 0 && Modifier.isPublic(m.getModifiers())) {
				System.out.println("    " + m.getName() + "()");
				methodList.add(m.getName());
			}
		}
		System.out.println();
	}


	private static int performSpecifiedMethod(Class<?> cl, Object obj, String methodName) {
		try {
			if (methodList.contains(methodName)) {
				Method m = cl.getMethod(methodName, null);
				m.invoke(obj, null);
				System.out.println("\nTHE " + methodName + "() METHOD HAS BEEN INVOKED");
				System.out.println("=======================================\n");
				return 0;
			} else {
				throw new Exception("method not declared");
			}
		} catch (Exception e) {
			System.err.println("ERROR: '" + methodName + "' is and invalid method name. Please select from the list printed above.");
			return 1;
		}
	}
	
} 
