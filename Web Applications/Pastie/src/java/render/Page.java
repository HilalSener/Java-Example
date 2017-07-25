
package render;

public class Page 
{
    public static String getHeader(String title)
    {
        return "<!DOCTYPE html>\n" +
"<html>\n" +
"    <head>\n" +
"        <script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>\n" +
"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"        <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +
"        <title>"+title+"</title>\n" +
"    </head>\n<body>";
    }
    
    public static String getPageEnd()
    {
        return "</body>\n</html>";
    }
}
