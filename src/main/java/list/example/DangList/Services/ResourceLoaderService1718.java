package list.example.DangList.Services;

import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component("resourceLoaderService2")
public class ResourceLoaderService1718 {

    public boolean downloadFile2(String fileUrl2, String filePath2) throws IOException {
        URL url = new URL(fileUrl2);
        InputStream in = url.openStream();
        FileOutputStream out = new FileOutputStream(filePath2);

        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.close();

        System.out.println("File downloaded to " + filePath2);
        return true;
    }
}
