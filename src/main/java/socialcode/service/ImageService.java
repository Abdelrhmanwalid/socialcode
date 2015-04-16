package socialcode.service;

import org.springframework.web.multipart.MultipartFile;
import socialcode.model.Image;

import java.io.IOException;

public interface ImageService {
    Image save(MultipartFile file) throws IOException;
    Image findById(int id);
    String imageSrc(Image image) throws IOException;
}
