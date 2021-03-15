package rec;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class DataProvider {

  private static final List<String> JSON_DATA;

  private static final ObjectMapper MAPPER = new ObjectMapper();

  static {
    JSON_DATA = List.of(
        "{\"id\":1,\"user\":{\"firstname\":\"Chicky\",\"lastname\":\"Benedikt\",\"email\":\"cbenedikt0@jugem.jp\",\"gender\":\"Bigender\"},\"location\":{\"position\":{\"lat\":59.2733875,\"lon\":17.8926893},\"speed\":133.79,\"timestamp\":\"11/3/2020\"}}",
        "{\"id\":2,\"user\":{\"firstname\":\"Valle\",\"lastname\":\"Dole\",\"email\":\"vdole1@1688.com\",\"gender\":\"Male\"},\"location\":{\"position\":{\"lat\":-7.5029075,\"lon\":107.8613334},\"speed\":149.44,\"timestamp\":\"11/12/2020\"}}",
        "{\"id\":3,\"user\":{\"firstname\":\"Janey\",\"lastname\":\"Fildery\",\"email\":\"jfildery2@paypal.com\",\"gender\":\"Agender\"},\"location\":{\"position\":{\"lat\":1.5991751,\"lon\":11.5759672},\"speed\":99.28,\"timestamp\":\"6/20/2020\"}}",
        "{\"id\":4,\"user\":{\"firstname\":\"Doretta\",\"lastname\":\"Slite\",\"email\":\"dslite3@bigcartel.com\",\"gender\":\"Polygender\"},\"location\":{\"position\":{\"lat\":-23.4114953,\"lon\":30.1560436},\"speed\":63.27,\"timestamp\":\"3/17/2020\"}}",
        "{\"id\":5,\"user\":{\"firstname\":\"Liuka\",\"lastname\":\"Janouch\",\"email\":\"ljanouch4@berkeley.edu\",\"gender\":\"Bigender\"},\"location\":{\"position\":{\"lat\":35.7914051,\"lon\":140.2792041},\"speed\":135.15,\"timestamp\":\"8/14/2020\"}}",
        "{\"id\":6,\"user\":{\"firstname\":\"Jordan\",\"lastname\":\"Tyas\",\"email\":\"jtyas5@spiegel.de\",\"gender\":\"Agender\"},\"location\":{\"position\":{\"lat\":-20.1514708,\"lon\":-44.2010909},\"speed\":146.1,\"timestamp\":\"4/19/2020\"}}",
        "{\"id\":7,\"user\":{\"firstname\":\"Towny\",\"lastname\":\"Quinion\",\"email\":\"tquinion6@cyberchimps.com\",\"gender\":\"Bigender\"},\"location\":{\"position\":{\"lat\":48.9098794,\"lon\":2.2829955},\"speed\":55.22,\"timestamp\":\"8/14/2020\"}}",
        "{\"id\":8,\"user\":{\"firstname\":\"Jehu\",\"lastname\":\"Boughtflower\",\"email\":\"jboughtflower7@discuz.net\",\"gender\":\"Agender\"},\"location\":{\"position\":{\"lat\":55.7184184,\"lon\":39.7362416},\"speed\":139.46,\"timestamp\":\"1/19/2021\"}}",
        "{\"id\":9,\"user\":{\"firstname\":\"Maddy\",\"lastname\":\"Penwright\",\"email\":\"mpenwright8@smh.com.au\",\"gender\":\"Non-binary\"},\"location\":{\"position\":{\"lat\":49.9638636,\"lon\":22.0339385},\"speed\":106.18,\"timestamp\":\"2/26/2020\"}}",
        "{\"id\":10,\"user\":{\"firstname\":\"Zonnya\",\"lastname\":\"Attow\",\"email\":\"zattow9@ustream.tv\",\"gender\":\"Female\"},\"location\":{\"position\":{\"lat\":-6.8243672,\"lon\":110.7880536},\"speed\":25.61,\"timestamp\":\"8/31/2020\"}}"
    );
  }

  public static Map<String,Object> getRandomRecord() {
    try {
      return MAPPER.readValue(JSON_DATA.get(new Random().nextInt(JSON_DATA.size())),
          new TypeReference<LinkedHashMap<String,Object>>() {});
    } catch (Exception e) {
      System.err.println("failed to parse with library -> falling back to manual record");
    }
    //single fallback map created manually in case something goes wrong with the lib
    return new LinkedHashMap<>() {{
      put("id",5);
      put("user",new LinkedHashMap<>(){{
        put("firstname","Liuka");
        put("lastname","Janouch");
        put("email","ljanouch4@berkeley.edu");
        put("gender","Bigender");
      }});
      put("location",new LinkedHashMap<>(){{
        put("position",new LinkedHashMap<>(){{
          put("lat",35.7914051);
          put("lon",140.2792041);
        }});
        put("speed",135.15);
        put("timestamp","8/14/2020");
      }});
    }};
  }

}
