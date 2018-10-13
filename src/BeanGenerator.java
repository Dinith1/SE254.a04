import java.lang.reflect.*;

public class BeanGenerator
{
  protected static String nl;
  public static synchronized BeanGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    BeanGenerator result = new BeanGenerator();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class ";
  protected final String TEXT_2 = "Bean extends ";
  protected final String TEXT_3 = "{";
  protected final String TEXT_4 = NL + "public ";
  protected final String TEXT_5 = " get";
  protected final String TEXT_6 = "() {" + NL + "return ";
  protected final String TEXT_7 = ";" + NL + "}";
  protected final String TEXT_8 = NL + "public void set";
  protected final String TEXT_9 = "(";
  protected final String TEXT_10 = "value) {";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = " = value;" + NL + "}";
  protected final String TEXT_13 = "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     Class c = (Class) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(c.getSimpleName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(c.getName());
    stringBuffer.append(TEXT_3);
     for(Field f : c.getFields()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(f.getType().getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(f.getName().substring(0,1).toUpperCase()+ f.getName().substring(1));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(f.getName());
    stringBuffer.append(TEXT_7);
     if(!Modifier.isFinal(f.getModifiers())) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(f.getName().substring(0,1).toUpperCase() + f.getName().substring(1));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(f.getType().getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(f.getName());
    stringBuffer.append(TEXT_12);
    }
    }
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}
