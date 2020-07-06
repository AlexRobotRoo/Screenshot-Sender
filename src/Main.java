import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

import static java.lang.Thread.sleep;


public class Main {
    public static void main(String[] args) {

        MyThread thread = new MyThread();
        thread.start();

    }
}
