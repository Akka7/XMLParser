package list.example.DangList.controllers;

import list.example.DangList.Services.CompVerificationService;
import list.example.DangList.Services.SanctionVerificationService;
import list.example.DangList.model.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private SanctionVerificationService sanctionVerificationService;

    @Autowired
    private CompVerificationService compVerificationService;

    @PostMapping("/verify")
    public ResponseEntity<Object> verifySanction(@RequestBody Map<String, String> requestData) {
        try {
            String name = requestData.get("name");
            boolean isVerified = sanctionVerificationService.verifySanction(name);
            return new ResponseEntity<>(isVerified, HttpStatus.OK);
        } catch (InvalidRequestException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/verifyComp")
    public ResponseEntity<Object> verifyComp(@RequestBody Map<String, String> requestData) {
        try {
            String name = requestData.get("name");
            boolean isVerified = compVerificationService.verifyCompany(name);
            if (isVerified) {
                return new ResponseEntity<>("Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Mismatch", HttpStatus.OK);
            }
        } catch (InvalidRequestException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
