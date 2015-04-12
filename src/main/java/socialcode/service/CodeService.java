package socialcode.service;

import socialcode.model.Code;

public interface CodeService {

    Code save(Code code);
    Code findById(int id);
}
