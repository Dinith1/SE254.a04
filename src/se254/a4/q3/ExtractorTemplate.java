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
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\t";
  protected final String TEXT_3 = NL + "\t";
  protected final String TEXT_4 = NL + "\t";
  protected final String TEXT_5 = NL + "\t\t";
  protected final String TEXT_6 = NL + "\t\t\t";
  protected final String TEXT_7 = NL + "\t\t\t";
  protected final String TEXT_8 = NL + "\t\t";
  protected final String TEXT_9 = NL + "\t";
  protected final String TEXT_10 = NL + "public class ";
  protected final String TEXT_11 = " {" + NL + "\t";
  protected final String TEXT_12 = NL + "\tprotected ";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = ";" + NL + "\t";
  protected final String TEXT_15 = NL + "}" + NL + "" + NL + "public class ";
  protected final String TEXT_16 = " extends ";
  protected final String TEXT_17 = " {" + NL + "\t";
  protected final String TEXT_18 = NL + "\tprivate ";
  protected final String TEXT_19 = " ";
  protected final String TEXT_20 = ";" + NL + "\t";
  protected final String TEXT_21 = NL + "}" + NL + "" + NL + "public class ";
  protected final String TEXT_22 = " extends ";
  protected final String TEXT_23 = " {" + NL + "\t";
  protected final String TEXT_24 = NL + "\tprivate ";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = ";" + NL + "\t";
  protected final String TEXT_27 = NL + "}" + NL;
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     se254.a4.q3.ExtractorArgument arg = (se254.a4.q3.ExtractorArgument)argument; 
     Class<se254.a4.q3.ExtractorArgument> cl = (Class<se254.a4.q3.ExtractorArgument>)arg.getClass(); 
     Class<?> a = null; 
     Class<?> b = null; 
     try { 
    stringBuffer.append(TEXT_1);
     a = arg.a; 
    stringBuffer.append(TEXT_2);
     b = arg.b; 
     } catch (Exception e) { 
    stringBuffer.append(TEXT_3);
     e.printStackTrace(); 
    }
     List<Field> superFields = new ArrayList<Field>(); 
     List<Field> aFields = new ArrayList<Field>(Arrays.asList(a.getFields())); 
     List<Field> bFields = new ArrayList<Field>(Arrays.asList(b.getFields())); 
     List<Field> bFieldsToRemove = new ArrayList<Field>(); 
     for (Field fa : aFields) { 
    stringBuffer.append(TEXT_4);
     for (Field fb : bFields) { 
    stringBuffer.append(TEXT_5);
     if ((fa.getName() == fb.getName()) && (fa.getType().equals(fb.getType())) && Modifier.isPublic(fa.getModifiers()) && Modifier.isPublic(fb.getModifiers())) { 
    stringBuffer.append(TEXT_6);
     superFields.add(fa); 
    stringBuffer.append(TEXT_7);
     bFieldsToRemove.add(fb); 
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    }
    }
     aFields.removeAll(superFields);
     bFields.removeAll(bFieldsToRemove);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(arg.className);
    stringBuffer.append(TEXT_11);
     for (Field f : superFields) { 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(f.getType().getSimpleName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(f.getName());
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(a.getSimpleName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(arg.className);
    stringBuffer.append(TEXT_17);
     for (Field f : aFields) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(f.getType().getSimpleName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(f.getName());
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(b.getSimpleName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(arg.className);
    stringBuffer.append(TEXT_23);
     for (Field f : bFields) { 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(f.getType().getSimpleName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(f.getName());
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
