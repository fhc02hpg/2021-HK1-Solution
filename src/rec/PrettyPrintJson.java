package rec;

import java.util.Map;

public class PrettyPrintJson {

  public static final String NEW_LINE = System.lineSeparator();
  public static final String DOUBLE_QUOTE = "\"";

  public static void main(String[] args) {

    for(int i=0; i < 5; i++) {
      Map<String,Object> data = DataProvider.getRandomRecord();
      String pretty = formatJsonString("",data);
      System.out.println(pretty);
    }

  }

  public static String formatJsonString(String indent,Map<String,Object> data) {
    String output = indent+"{"+NEW_LINE;
    int fieldCount = 0;
    for(Map.Entry<String,Object> e : data.entrySet()) {
      output += indent+"  " + DOUBLE_QUOTE + e.getKey() + DOUBLE_QUOTE + ": ";
      if(e.getValue() instanceof Map) {
        output += NEW_LINE+formatJsonString(indent+"  ",(Map<String,Object>)e.getValue());
      }
      else if (e.getValue() instanceof String) {
        output += DOUBLE_QUOTE+e.getValue()+DOUBLE_QUOTE;
      } else {
        output += e.getValue();
      }
      if(++fieldCount < data.size()) {
        output += ",";
      }
      output += NEW_LINE;
    }
    output += indent+"}";
    return output;
  }

}
