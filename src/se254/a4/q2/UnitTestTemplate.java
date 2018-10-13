package se254.a4.q2;

import java.lang.reflect.*;

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
  protected final String TEXT_1 = " " + NL + "import static org.junit.Assert.*;" + NL + "import org.junit.Test;" + NL;
  protected final String TEXT_2 = NL + "public class ";
  protected final String TEXT_3 = "Test {" + NL + "\t";
  protected final String TEXT_4 = NL + "\t\t@Test" + NL + "\t\tpublic void test";
  protected final String TEXT_5 = "() {" + NL + "\t\t\tfail(\"Not yet implemented\");" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_6 = NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     Class cl = (Class) argument; 
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cl.getSimpleName());
    stringBuffer.append(TEXT_3);
     for (Method m : cl.getDeclaredMethods()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(m.getName().substring(0,1).toUpperCase() + m.getName().substring(1));
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
