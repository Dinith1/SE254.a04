package se254.a4.q3;

import java.lang.reflect.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ExtractorTemplate
{
  protected static String nl;
  public static synchronized ExtractorTemplate create(String lineSeparator)
  {
    nl = lineSeparator;
    ExtractorTemplate result = new ExtractorTemplate();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + "\t";
  protected final String TEXT_6 = NL + "\t";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\t\t";
  protected final String TEXT_12 = NL + "\t\t\t";
  protected final String TEXT_13 = NL + "\t\t\t";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = NL + "\t";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     se254.a4.q3.ExtractorArgument arg = (se254.a4.q3.ExtractorArgument)argument; 
    stringBuffer.append(TEXT_2);
     Class<se254.a4.q3.ExtractorArgument> cl = (Class<se254.a4.q3.ExtractorArgument>)arg.getClass(); 
    stringBuffer.append(TEXT_3);
     Class<?> a = null; 
     Class<?> b = null; 
     try { 
    stringBuffer.append(TEXT_4);
     a = cl.getDeclaredField("a").getType(); 
    stringBuffer.append(TEXT_5);
     b = cl.getDeclaredField("b").getType(); 
     } catch (Exception e) { 
    stringBuffer.append(TEXT_6);
     e.printStackTrace(); 
    }
    stringBuffer.append(TEXT_7);
     List<Field> superFields = new ArrayList<Field>(); 
     List<Field> aFields = new ArrayList<Field>(Arrays.asList(a.getFields())); 
     List<Field> bFields = new ArrayList<Field>(Arrays.asList(b.getFields())); 
    stringBuffer.append(TEXT_8);
     for (Field fa : aFields) { 
    stringBuffer.append(TEXT_9);
     for (Field fb : bFields) { 
    stringBuffer.append(TEXT_10);
     if ((fa.getName() == fb.getName()) && Modifier.isPublic(fa.getModifiers()) && Modifier.isPublic(fb.getModifiers())) { 
    stringBuffer.append(TEXT_11);
     superFields.add(fa); 
    stringBuffer.append(TEXT_12);
     aFields.remove(fa); 
    stringBuffer.append(TEXT_13);
     bFields.remove(fb); 
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    }
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
