package socialcode.service;

import org.springframework.web.multipart.MultipartFile;
import socialcode.model.Image;

import java.io.File;
import java.io.IOException;

public interface ImageService {
    Image save(MultipartFile file, String path) throws IOException;
    Image findById(int id);
    File getImage(int id);
}
