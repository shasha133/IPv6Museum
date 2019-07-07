package museum.util;

public class PathUtil {
    private static String seperator = System.getProperty("file.separator");
    public static String getImgBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if(os.toLowerCase().startsWith("win")) {
            basePath = "C:\\ipv6\\workProject";
        }else {
            basePath = "/home/skymei/图片/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    public static String getShopImgPath(Long shopId) {
        String imagePath = "/home/skymei/图片/"+shopId+"/";
        return imagePath.replace("/", seperator);
    }
}
