package socialcode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socialcode.model.Code;
import socialcode.repository.CodeRepository;

@Service("CodeService")
public class CodeServiceImpl implements CodeService {

    @Autowired
    private CodeRepository codeRepository;

    public Code save(Code code) {
        codeRepository.save(code);
        return code;
    }

    public Code findById(int id) {
        return codeRepository.findOne(id);
    }

}
