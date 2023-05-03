package list.example.DangList.Services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component("resourceLoaderService1")
public class ResourceLoaderService1988 {

    public boolean downloadFile(String fileUrl, String filePath) throws IOException {
        URL url = new URL(fileUrl);
        InputStream in = url.openStream();
        FileOutputStream out = new FileOutputStream(filePath);

        byte[] buffer = new byte[1024];
        int bytesRead = 0;

        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        in.close();
        out.close();

        System.out.println("File downloaded to " + filePath);
        return true;
    }
}
