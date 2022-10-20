package ttw.springbe.transactional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttw.springbe.transactional.entities.TableB;
import ttw.springbe.transactional.repositories.TableBRepository;

import java.util.List;

@Service
public class TableBService {

    @Autowired
    private TableBRepository tableBRepository;

    public List<TableB> getAll() {
        return tableBRepository.findAll();
    }

    public List<TableB> resetToNormalAndGetDataA() {
        updateValueRow1Transactional("0");
        updateValueRow2Transactional("0");
        updateValueRow3Transactional("0");
        return getAll();
    }

    public void updateFailTransactionalFail() {
        updateValueRow1Transactional("5");
        updateValueRow2Transactional("a");
    }

    @Transactional
    public void updateFailTransactionalSuccess() {
        updateValueRow1Transactional("10");
        updateValueRow2Transactional("a");
    }

    @Transactional
    public void updateValueRow1Transactional(String newValue) {
        TableB dataRow1 = tableBRepository.findById(1).get();
        dataRow1.setCurrentValue(Integer.valueOf(newValue));
        tableBRepository.save(dataRow1);
    }

    @Transactional
    public void updateValueRow2Transactional(String newValue) {
        TableB dataRow2 = tableBRepository.findById(2).get();
        dataRow2.setCurrentValue(Integer.valueOf(newValue));
        tableBRepository.save(dataRow2);
    }

    @Transactional
    public void updateValueRow3Transactional(String newValue) {
        TableB dataRow3 = tableBRepository.findById(3).get();
        dataRow3.setCurrentValue(Integer.valueOf(newValue));
        tableBRepository.save(dataRow3);
    }
}
