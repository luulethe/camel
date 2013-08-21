package SimpleRouting;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * User: luult
 * Date: 8/21/13
 * Time: 5:00 PM
 */
public class MainClassTest
{
    @Test
    public void testMain() throws Exception
    {
        MainClass mainClass = new MainClass();
        String url = "http://uet.vnu.edu.vn/~chauttm/TDD/";
        String folderName = "file://D:/Temp";
        File file = new File("D://Temp");
        deleteFolder(file);
        mainClass.getDataFromWebsite(url, folderName);
        assertTrue(file.listFiles().length > 0);
    }

    public static void deleteFolder(File folder)
    {
        File[] files = folder.listFiles();
        System.out.println(files);
        if (files != null)
        { //some JVMs return null for empty dirs
            for (File f : files)
            {
                System.out.println(f);
                if (f.isDirectory())
                {
                    deleteFolder(f);
                }
                else
                {
                    f.delete();
                }
            }
        }
        folder.delete();
    }
}
