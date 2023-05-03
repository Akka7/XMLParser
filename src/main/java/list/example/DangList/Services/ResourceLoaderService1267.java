package list.example.DangList.Services;

import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component("resourceLoaderService3")
public class ResourceLoaderService1267 {

    public boolean downloadFile3(String fileUrl3, String filePath3) throws IOException {
        URL url = new URL(fileUrl3);
        InputStream in = url.openStream();
        FileOutputStream out = new FileOutputStream(filePath3);

        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.close();

        System.out.println("File downloaded to " + filePath3);

        return true;
    }
}
