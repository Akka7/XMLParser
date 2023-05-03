package list.example.DangList;

import jakarta.annotation.PostConstruct;
import list.example.DangList.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DangListApplication {

    @Autowired
    private TestService testService;

    @Autowired
    private SanctionService sanctionService;

    @Autowired
    private SancCompaniesService sancCompaniesService;

    public static void main(String[] args) throws IOException {

        String fileUrl1 = "https://scsanctions.un.org/xml/ru/taliban";
        String filePath1 = "C:/Users/LEGION/IdeaProjects/DangList/taliban.xml";

        String fileUrl2 = "https://scsanctions.un.org/xml/ru/dprk";
        String filePath2 = "C:/Users/LEGION/IdeaProjects/DangList/DPRK.xml";

        String fileUrl3 = "https://scsanctions.un.org/xml/ru/al-qaida";
        String filePath3 = "C:/Users/LEGION/IdeaProjects/DangList/ISIL.xml";

        ResourceLoaderService1988 resourceLoaderService1988 = new ResourceLoaderService1988();
        ResourceLoaderService1718 resourceLoaderService1718 = new ResourceLoaderService1718();
        ResourceLoaderService1267 resourceLoaderService1267 = new ResourceLoaderService1267();

        // Download the files sequentially
        boolean isDownloaded1 = resourceLoaderService1988.downloadFile(fileUrl1, filePath1);
        boolean isDownloaded2 = resourceLoaderService1718.downloadFile2(fileUrl2, filePath2);
        boolean isDownloaded3 = resourceLoaderService1267.downloadFile3(fileUrl3, filePath3);

        // If all files are downloaded successfully, start the parsing process
        if (isDownloaded1 && isDownloaded2 && isDownloaded3) {
            SpringApplication.run(DangListApplication.class, args);
        }
    }


    @PostConstruct
    public void init() {
        sancCompaniesService.parseXmlAndInsertCompDataTaliban();
        sancCompaniesService.parseXmlAndInsertCompDataDPRK();
        sancCompaniesService.parseXmlAndInsertCompDataISIL();
        sanctionService.parseXmlAndInsertDataTaliban();
        sanctionService.parseXmlAndInsertDataDPRK();
        sanctionService.parseXmlAndInsertDataISIL();
    }



    //@PostConstruct
    //public void init() {
      // sanctionService.parseXmlAndInsertDataTaliban();
    //}
}
