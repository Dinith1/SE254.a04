package se254.a4.q2;

import java.lang.reflect.*;
import java.util.*;

public class UnitTestTemplate
{
  protected static String nl;
  public static synchronized UnitTestTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    UnitTestTemplate result = new UnitTestTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = " ";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = NL + NL + "import static org.junit.Assert.*;" + NL + "import org.junit.Test;" + NL + "" + NL + "public class ";
  protected final String TEXT_8 = "Test {" + NL + "\t";
  protected final String TEXT_9 = NL + "\t@Test" + NL + "\tpublic void test";
  protected final String TEXT_10 = "() {" + NL + "\t\tfail(\"Not yet implemented\");" + NL + "\t}" + NL + "\t";
  protected final String TEXT_11 = NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Class<?> cl = (Class<?>) argument; 
     List<String> methodNames = new ArrayList<String>(); 
     List<String> methodNamesOverload = new ArrayList<String>(); 
    stringBuffer.append(TEXT_2);
     for (Method m : cl.getDeclaredMethods()) { 
    stringBuffer.append(TEXT_3);
     methodNames.add(m.getName()); 
    }
    stringBuffer.append(TEXT_4);
     for (Method m : cl.getDeclaredMethods()) { 
    stringBuffer.append(TEXT_5);
     methodNamesOverload.add(m.getName() + "_" + Collections.frequency(methodNames, m.getName())); 
    stringBuffer.append(TEXT_6);
     methodNames.remove(methodNames.indexOf(m.getName())); 
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cl.getSimpleName());
    stringBuffer.append(TEXT_8);
     for (String s : methodNamesOverload) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(s.substring(0,1).toUpperCase() + s.substring(1));
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
