package ttw.springbe.transactional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttw.springbe.transactional.entities.TableA;
import ttw.springbe.transactional.repositories.TableARepository;

import java.util.List;

@Service
public class TableAService {
    
    @Autowired
    private TableARepository tableARepository;

    @Autowired
    private TableBService tableBService;

    public List<TableA> getAll() {
        return tableARepository.findAll();
    }

    public List<TableA> resetToNormalAndGetDataA() {
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

    public void updateAAndBFailTransactionalFail() {
        updateValueRow1Transactional("5");
        tableBService.updateValueRow2Transactional("a");
    }

    @Transactional
    public void updateAAndBFailTransactionalSuccess() {
        updateValueRow1Transactional("5");
        tableBService.updateValueRow2Transactional("a");
    }

    @Transactional
    public void updateValueRow1Transactional(String newValue) {
        TableA dataRow1 = tableARepository.findById(1).get();
        dataRow1.setCurrentValue(Integer.valueOf(newValue));
        tableARepository.save(dataRow1);
    }

    @Transactional
    public void updateValueRow2Transactional(String newValue) {
        TableA dataRow2 = tableARepository.findById(2).get();
        dataRow2.setCurrentValue(Integer.valueOf(newValue));
        tableARepository.save(dataRow2);
    }

    @Transactional
    public void updateValueRow3Transactional(String newValue) {
        TableA dataRow3 = tableARepository.findById(3).get();
        dataRow3.setCurrentValue(Integer.valueOf(newValue));
        tableARepository.save(dataRow3);
    }
}
